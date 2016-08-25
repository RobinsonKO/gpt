package com.gpengtao.extract.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by gpengtao on 16/8/18.
 */
public class CaptureService {

    public static List<String> capture(String url) {
        List<String> result = doCapture(url);

        for (int i = 2; ; ++i) {
            String nextUrl = getNextUrl(url, i);
            List<String> list = doCapture(nextUrl);
            if (CollectionUtils.isEmpty(list)) {
                break;
            } else {
                result.addAll(list);
            }
        }
        return result;
    }

    private static String getNextUrl(String url, int i) {
        return url.replace(".html", "_" + i + ".html");
    }


    private static List<String> doCapture(String url) {
        List<String> result = Lists.newArrayList();

        try {
            Connection connect = Jsoup.connect(url);
            Response response = connect.execute();

            if (response.statusCode() == 200) {
                Document document = response.parse();

                Element contents = document.getElementById("contents");
                Elements imgages = contents.select("img");

                for (Element element : imgages) {
                    String image = element.toString();
                    result.add(image);
                }
            }
        } catch (HttpStatusException e) {
            System.out.println("end");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }

    public static Map<String, String> parseTag(String url) {
        Map<String, String> result = Maps.newLinkedHashMap();

        try {
            Connection connect = Jsoup.connect(url);
            Response response = connect.execute();

            if (response.statusCode() == 200) {
                Document document = response.parse();

                Elements imgages = document.select("img");

                for (Element element : imgages) {
                    String src = element.attr("src");
                    String alt = element.attr("alt");
                    alt = alt.replace("“", "").replace(" ", "");
                    alt = alt.substring(0, alt.indexOf("("));
                    result.put(src, alt);
                }
            }
        } catch (HttpStatusException e) {
            System.out.println("error");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }

    public static boolean download(String url, String fileName) {
        url = url.replaceAll("!960.jpg", "");
        fileName = fileName + "_" + url.substring(url.lastIndexOf("/") + 1);

        fileName = "/Users/gpengtao/Downloads/11/" + fileName;

        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("file " + fileName + " had exist");
            return false;
        }

        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            response = httpclient.execute(new HttpGet(url));

            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();

            ByteStreams.copy(content, new FileOutputStream(file));
            return true;
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        } finally {

            if (response != null) {
                try {
                    response.close();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }
}

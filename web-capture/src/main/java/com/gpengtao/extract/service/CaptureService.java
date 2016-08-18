package com.gpengtao.extract.service;

import com.google.common.collect.Lists;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
                    result.add(element.toString());
                }
            }
        } catch (HttpStatusException e) {
            System.out.println("end");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }
}

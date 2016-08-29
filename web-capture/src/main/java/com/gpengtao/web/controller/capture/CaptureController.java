package com.gpengtao.web.controller.capture;

import com.gpengtao.capture.CaptureUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by gpengtao on 16/8/19.
 */
@Controller
public class CaptureController {

    @RequestMapping("/capture")
    public ModelAndView capture(String url) {
        if (!url.startsWith("http://")) {
            url = "http://" + url;
        }
        List<String> contentList = CaptureUtil.capture(url);

        contentList.forEach(System.out::println);

        ModelAndView modelAndView = new ModelAndView("capture");
        modelAndView.addObject("contents", contentList);
        return modelAndView;
    }

    @RequestMapping("/download")
    @ResponseBody
    public Object download(String url) {

        int successCount = 0;
        int failCount = 0;
        Map<String, String> urlMap = CaptureUtil.parseTag(url);
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            System.out.println("download entry: " + entry.getKey() + " -> " + entry.getValue());
            boolean success = CaptureUtil.download(entry.getKey(), entry.getValue());
            if (success) {
                successCount++;
            } else {
                failCount++;
            }

        }
        return "sum: " + urlMap.size() + "   successCount: " + successCount + "   failCount: " + failCount;
    }
}

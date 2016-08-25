package com.gpengtao.extract.web;

import com.gpengtao.extract.service.CaptureService;
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
public class HelloController {

    @RequestMapping("/capture")
    public ModelAndView capture(String url) {
        if (!url.startsWith("http://")) {
            url = "http://" + url;
        }
        List<String> contentList = CaptureService.capture(url);

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
        Map<String, String> urlMap = CaptureService.parseTag(url);
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            System.out.println("download entry: " + entry.getKey() + " -> " + entry.getValue());
            boolean success = CaptureService.download(entry.getKey(), entry.getValue());
            if (success) {
                successCount++;
            } else {
                failCount++;
            }

        }
        return "sum: " + urlMap.size() + "   successCount: " + successCount + "   failCount: " + failCount;
    }
}

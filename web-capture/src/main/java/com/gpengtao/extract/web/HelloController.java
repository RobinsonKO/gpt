package com.gpengtao.extract.web;

import com.gpengtao.extract.service.CaptureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
}

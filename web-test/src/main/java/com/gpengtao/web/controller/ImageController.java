package com.gpengtao.web.controller;

/**
 * Created by gpengtao on 2015/7/4.
 */

import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @RequestMapping("/images")
    public ModelAndView images(@RequestParam("dir") String dirString) {
        ModelAndView modelAndView = new ModelAndView("image");

        File dir = new File(dirString);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            modelAndView.addObject("errMsg", "û���ļ�");
            return modelAndView;
        }

        List<String> pathList = Lists.newArrayList();
        for (File file : files) {
            if (file.getName().endsWith(".jpg")) {
                pathList.add(file.getPath());
            }
        }

        Collections.shuffle(pathList);

        modelAndView.addObject("pathList", pathList);
        return modelAndView;
    }

    @RequestMapping("/viewImage")
    public void viewImage(@RequestParam("path") String path, HttpServletResponse response) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            ByteStreams.copy(fileInputStream, response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

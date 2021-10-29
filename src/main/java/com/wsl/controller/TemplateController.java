package com.wsl.controller;

import com.wsl.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private WXConfig wxConfig;

    @GetMapping("freemaker")
    public String index1(ModelMap map) {
        map.addAttribute("setting",wxConfig);
        return "/user/fm/index";
    }
    @GetMapping("thymeleaf")
    public String index2(ModelMap map) {
        map.addAttribute("setting",wxConfig);
        return "/user/tl/index";
    }

}

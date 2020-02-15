package com.taibin.bbsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/15 15:20
 */

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model)
    {
        model.addAttribute("name",name);
        return  "hello";

    }
}

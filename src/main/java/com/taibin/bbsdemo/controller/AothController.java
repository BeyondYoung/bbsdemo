package com.taibin.bbsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/15 21:48
 */

@Controller
public class AothController {

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state
                            ){
        
        return  "index";
    }
}



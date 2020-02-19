package com.taibin.bbsdemo.controller;

import com.taibin.bbsdemo.Service.QuestionService;
import com.taibin.bbsdemo.dto.QuestionDTO;
import com.taibin.bbsdemo.mapper.UserMaper;
import com.taibin.bbsdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/17 12:31
 */

@Controller
public class IndexController {

    @Autowired
    private UserMaper userMaper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals("token")) {
                    User user = userMaper.selectUserBytoken(ck.getValue());
                    if (user != null) {
                        request.getSession().setAttribute("user", user);

                    }
                    break;
                }
            }
        }
        //get question fron db
        List<QuestionDTO> questionDTOList = questionService.getList();
        model.addAttribute("Questions", questionDTOList);
        return "index";
    }
}

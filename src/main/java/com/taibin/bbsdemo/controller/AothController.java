package com.taibin.bbsdemo.controller;

import com.taibin.bbsdemo.Provider.GithubProvider;
import com.taibin.bbsdemo.dto.AccessTokenDTO;
import com.taibin.bbsdemo.dto.GithubUser;
import com.taibin.bbsdemo.mapper.UserMaper;
import com.taibin.bbsdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/15 21:48
 */

@Controller
public class AothController {

    @Autowired
    private GithubProvider githubProvider;


    @Value("${github.client_id}")
    private  String clientid;

    @Value("${github.client_secret}")
    private  String clientsecret;

    @Value("${github.redirect_uri}")
    private  String redirecturi;

    @Autowired
    private UserMaper userMaper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                            HttpServletResponse response) throws IOException {
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientid);
        accessTokenDTO.setClient_secret(clientsecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirecturi);
        accessTokenDTO.setState(state);
        String token= githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getuser(token);
        if (githubUser!=null)
        {
            User user=new User();
            user.setToken(UUID.randomUUID().toString());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setCreateDate(System.currentTimeMillis());
            user.setModifyDate(user.getCreateDate());
            userMaper.insertuser(user);

            //login success add  and cookie
          //  request.getSession().setAttribute("user",githubUser);
            response.addCookie(new Cookie("token",user.getToken()));

            return "redirect:/";
        }
        else
        {
            return "redirect:/";
        }
    }
}



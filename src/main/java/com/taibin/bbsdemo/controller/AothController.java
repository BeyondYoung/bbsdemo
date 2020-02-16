package com.taibin.bbsdemo.controller;

import com.taibin.bbsdemo.Provider.GithubProvider;
import com.taibin.bbsdemo.dto.AccessTokenDTO;
import com.taibin.bbsdemo.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

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

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state
                            ) throws IOException {
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientid);
        accessTokenDTO.setClient_secret(clientsecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirecturi);
        accessTokenDTO.setState(state);
        String token= githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user=githubProvider.getuser(token);
        System.out.println(user.getName());
        return  "index";
    }
}



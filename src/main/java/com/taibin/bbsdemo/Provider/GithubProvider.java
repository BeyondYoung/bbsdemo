package com.taibin.bbsdemo.Provider;

import com.alibaba.fastjson.JSON;
import com.taibin.bbsdemo.dto.AccessTokenDTO;
import com.taibin.bbsdemo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/16 13:26
 */

@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();

            String token=str.split("&")[0].split("=")[1].toString();
            System.out.println(token);
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }


    public GithubUser getuser(String accessToken) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();


        Response rs = null;

        rs = client.newCall(request).execute();

        String str = rs.body().string();
        GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
        return githubUser;


    }
}

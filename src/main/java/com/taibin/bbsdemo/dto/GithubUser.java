package com.taibin.bbsdemo.dto;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/16 14:33
 */
public class GithubUser {
    private  String name;
    private  long id;
    private  String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

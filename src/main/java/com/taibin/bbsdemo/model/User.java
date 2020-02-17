package com.taibin.bbsdemo.model;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/16 17:51
 */
public class User {

    private  int   id;
    private String   account_id  ;
    private String     name;
    private String    token;
    private long create_date;
    private long modify_date;

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }

    public long getModify_date() {
        return modify_date;
    }

    public void setModify_date(long modify_date) {
        this.modify_date = modify_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}

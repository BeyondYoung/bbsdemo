package com.taibin.bbsdemo.mapper;

import com.taibin.bbsdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author: hi@yangbin.cc
 * @date 2020/2/16 17:26
 */


@Repository
@Mapper
public interface UserMaper {

    @Insert("INSERT INTO TEST.USER (name,account_id,token,create_date,modify_date) VALUES (#{name},#{account_id},#{token},#{create_date},#{modify_date})")
    void  insertuser(User user);
}

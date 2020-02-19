package com.taibin.bbsdemo.mapper;

import com.taibin.bbsdemo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author: hi@yangbin.cc
 * @date 2020/2/16 17:26
 */


@Repository
@Mapper
public interface UserMaper {

    @Insert("INSERT INTO TEST.USER (name,account_id,token,create_date,modify_date) VALUES (#{name},#{accountId},#{token},#{createDate},#{modifyDate})")
    void insertuser(User user);


    @Select("SELECT * FROM TEST.USER WHERE TOKEN=#{token}")
    User selectUserBytoken(@Param("token") String token);

    @Select("SELECT * FROM TEST.USER WHERE name=#{creator}")
    User findByName(@Param("creator") String creator);


    @Select("SELECT * FROM TEST.USER WHERE ID=#{creator}")
    User findById(@Param("creator") String creator);

    @Select("SELECT * FROM TEST.USER")
    List<User> selectAll();


}

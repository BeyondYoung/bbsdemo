package com.taibin.bbsdemo.mapper;

import com.taibin.bbsdemo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/18 10:40
 */
@Repository
@Mapper
public interface QuestionMapper {


    @Insert("INSERT INTO TEST.QUESTION(title,description,create_date,modify_date,crator,comment_count,view_count,like_count,tag) VALUES(#{title},#{description},#{createDate},#{modifyDate},#{crator},0,0,0,#{tag})")
    void addQuestion(Question question);

    @Select("SELECT * FROM TEST.QUESTION")
    List<Question> selectAll();

    @Select("SELECT * FROM TEST.QUESTION")
    List<Question> getTest();
}


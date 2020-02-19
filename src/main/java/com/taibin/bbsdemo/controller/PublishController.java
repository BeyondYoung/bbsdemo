package com.taibin.bbsdemo.controller;

import com.taibin.bbsdemo.mapper.QuestionMapper;
import com.taibin.bbsdemo.mapper.UserMaper;
import com.taibin.bbsdemo.model.Question;
import com.taibin.bbsdemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/17 17:02
 */

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMaper userMaper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }


    /**
     * @return
     */
    @PostMapping("/publish")
    public String doPublish(@Param("title") String title,
                            @Param("description") String description,
                            //@Param("comment_count") String comment_count,
                            //@Param("view_count") int view_count,
                            // @Param("like_count") int like_count,
                            @Param("tag") String tag,
                            HttpServletRequest request,
                            Model model
    ) {


        if (title.equals(null) || title == "") {
            model.addAttribute("title", "title is not null~");
            return "publish";
        }
        if (description.equals(null) || description == "") {
            model.addAttribute("description", "title is not null~");
            return "publish";
        }
        if (tag.equals(null) || tag == "") {
            model.addAttribute("tag", "title is not null~");
            return "publish";
        }

        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals("token")) {
                    user = userMaper.selectUserBytoken(ck.getValue());
                    break;
                }
            }
        }
        if (user != null) {
            Question question = new Question();
            question.setTitle(title);
            question.setDescription(description);
            question.setCreateDate(System.currentTimeMillis());
            question.setModifyDate(question.getCreateDate());
            question.setCrator(String.valueOf(user.getId()));
            //question.setComment_count(comment_count);
            //question.setLike_count(like_count);
            //  question.setView_count(view_count);
            question.setTag(tag);

            System.out.println("login success");
            questionMapper.addQuestion(question);
        } else {
            System.out.println("please login");
            model.addAttribute("error", "please login ~");
            return "publish";
        }

        return "publish";

    }

}

package com.taibin.bbsdemo.Service;

import com.taibin.bbsdemo.dto.QuestionDTO;
import com.taibin.bbsdemo.mapper.QuestionMapper;
import com.taibin.bbsdemo.mapper.UserMaper;
import com.taibin.bbsdemo.model.Question;
import com.taibin.bbsdemo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hi@yangbin.cc
 * @date 2020/2/18 22:50
 */

@Service
public class QuestionService {

    @Autowired
    private UserMaper userMaper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> getList() {

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        List<Question> questionList = questionMapper.selectAll();

        for (Question question : questionList) {
            User user = userMaper.findById(question.getCrator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;

    }
}

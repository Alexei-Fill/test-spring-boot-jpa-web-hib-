package com.af.qu.ok.service;

import com.af.qu.ok.entity.Answer;
import com.af.qu.ok.repository.AnswerRepository;
import com.af.qu.ok.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public int getScore(ResultSet resultSet){
        int score = 0;
        List<Answer> answers = answerRepository.findAllById( resultSet.stream().map(result -> result.getA_id()).collect(Collectors.toList()));
        for (Answer answer: answers){
            score= score + answer.getA_score();
        }
        return score;
    }

}

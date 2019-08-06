package com.af.qu.ok.service;

import com.af.qu.ok.entity.Answer;
import com.af.qu.ok.repository.AnswerRepository;
import com.af.qu.ok.util.QuestMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public int getScore(QuestMap questMap){
        int score = 0;
        List<Answer> answers = answerRepository.findAllById(questMap.values());
        for (Answer answer: answers){
            score= score + answer.getA_score();
        }
        return score;
    }

}

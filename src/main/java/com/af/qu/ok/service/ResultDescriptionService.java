package com.af.qu.ok.service;

import com.af.qu.ok.entity.ResultDescription;
import com.af.qu.ok.repository.ResultDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultDescriptionService {

    @Autowired
    private ResultDescriptionRepository resultDescriptionRepository;

    public ResultDescription findCorrectDescription(long score){
        return resultDescriptionRepository.findResultDescriptionByScore(score).get();
    }

}

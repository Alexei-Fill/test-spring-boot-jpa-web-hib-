package com.af.qu.ok.service;

import com.af.qu.ok.entity.Result;
import com.af.qu.ok.repository.ResultRepository;
import com.af.qu.ok.util.QuestMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public void saveAll(QuestMap questMap, String name) {
        for (Map.Entry<Long, Long> entry: questMap.entrySet()) {
            resultRepository.save(new Result(0, name, entry.getKey(), entry.getValue()));
        }
    }
}

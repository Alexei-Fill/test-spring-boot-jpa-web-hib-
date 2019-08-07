package com.af.qu.ok.service;

import com.af.qu.ok.entity.Result;
import com.af.qu.ok.repository.ResultRepository;
import com.af.qu.ok.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public void saveAll(ResultSet resultSet) {
        for (Result result : resultSet) {
            resultRepository.save(result);
        }
    }
}

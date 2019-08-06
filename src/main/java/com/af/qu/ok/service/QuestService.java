package com.af.qu.ok.service;

import com.af.qu.ok.entity.Quest;
import com.af.qu.ok.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

    @Autowired
    QuestRepository questRepository;


    public Page<Quest> findAll(int x) {
        return questRepository.findAll(PageRequest.of(x, 1));
    }


 }

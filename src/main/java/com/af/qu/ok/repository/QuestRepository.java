package com.af.qu.ok.repository;

import com.af.qu.ok.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long>{
}

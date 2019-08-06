package com.af.qu.ok.repository;

import com.af.qu.ok.entity.ResultDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ResultDescriptionRepository extends JpaRepository<ResultDescription, Long> {

    @Query("SELECT rd FROM ResultDescription rd WHERE rd.rd_max > :score AND rd.rd_min <= :score")
    Optional<ResultDescription> findResultDescriptionByScore(@Param("score") long score);
}

package com.af.qu.ok.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Quest implements Serializable {

    @Id
    @Column(name = "q_id")
    @SequenceGenerator(name = "q_seq", sequenceName = "questions_q_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "q_seq", strategy = GenerationType.SEQUENCE)
    private long q_id;

    @Column(name = "q_text")
    private String q_text;

    @OneToMany
    @JoinColumn(name = "q_id")
    private List<Answer> answers;
}

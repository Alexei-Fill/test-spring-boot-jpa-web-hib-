package com.af.qu.ok.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    @Column(name = "a_id")
    @SequenceGenerator(name = "a_seq", sequenceName = "answers_a_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "a_seq", strategy = GenerationType.SEQUENCE)
    private long a_id;

    @Column(name = "a_text")
    private String a_text;

    @Column(name = "a_score")
    private int a_score;
}

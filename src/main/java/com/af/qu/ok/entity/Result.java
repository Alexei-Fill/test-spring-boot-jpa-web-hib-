package com.af.qu.ok.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "results")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    @Column(name = "r_id")
    @SequenceGenerator(name = "r_seq", sequenceName = "results_r_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "r_seq", strategy = GenerationType.SEQUENCE)
    private long r_id;

    @Column(name = "name")
    private String name;

    @Column(name = "q_id")
    private long q_id;

    @Column(name = "a_id")
    private long a_id;

}

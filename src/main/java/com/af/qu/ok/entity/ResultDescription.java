package com.af.qu.ok.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "result_description")
@Data
public class ResultDescription {

    @Id
    @SequenceGenerator(name = "rd_seq", sequenceName = "result_description_rd_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "rd_seq", strategy = GenerationType.SEQUENCE)
    private long rd_id;

    @Column(name = "rd_min")
    private long rd_min;

    @Column(name = "rd_max")
    private long rd_max;

    @Column(name = "rd_text")
    private String rd_text;
}

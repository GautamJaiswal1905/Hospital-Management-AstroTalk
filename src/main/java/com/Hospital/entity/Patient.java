package com.Hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private long room;

    @Column(nullable = false)
    private long expenses;

    @Column(nullable = false)
    private String doctor_name;

    @Column(nullable = false)
    private String admit_date;

    @Column(nullable = false)
    private String status;


}


package com.example.demospringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * CRUD
 * C: create
 * R: read
 * U: update
 * D: delete
 */
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 5382787652176414516L;
    @Column(name = "student_code", unique = true)
    private String studentCode;
    @Column(name = "class_id")
    private String classId;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}

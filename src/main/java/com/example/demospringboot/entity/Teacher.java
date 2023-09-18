package com.example.demospringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
@Table(name = "teacher")
public class Teacher extends Person {
    @Column(name = "teacher_code", unique = true)
    private String teacherCode;
    @ManyToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

}

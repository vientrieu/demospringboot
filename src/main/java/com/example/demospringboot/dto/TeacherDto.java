package com.example.demospringboot.dto;

import com.example.demospringboot.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TeacherDto {
    private Long id;
    private String name;
    private Date birthday;
    private String sex;
    private String hobby;
    private String teacherCode;
    private List<Course> courses = new ArrayList<>();
}

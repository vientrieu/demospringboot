package com.example.demospringboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is dto of {@link com.example.demospringboot.entity.Student}
 */
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private Date birthday;
    private String sex;
    private String hobby;
    private String studentCode;
    private String classId;
    private List<CourseDto> courses = new ArrayList<>();
}

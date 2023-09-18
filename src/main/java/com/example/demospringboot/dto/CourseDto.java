package com.example.demospringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CourseDto {
    private Long id;
    private String courseName;
    private String courseCode;
    @JsonIgnore
    private TeacherDto teacher;
    @JsonIgnore
    private List<StudentDto> students = new ArrayList<>();
}

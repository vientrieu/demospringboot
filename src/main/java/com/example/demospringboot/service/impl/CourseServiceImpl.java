package com.example.demospringboot.service.impl;

import com.example.demospringboot.entity.Course;
import com.example.demospringboot.service.CRUDService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CRUDService<Course> {
    @Override
    public Course create(Course input) {
        return null;
    }

    @Override
    public List<Course> read() {
        return null;
    }

    @Override
    public Course update(Course newValue) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

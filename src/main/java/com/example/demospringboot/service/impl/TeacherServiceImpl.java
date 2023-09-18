package com.example.demospringboot.service.impl;

import com.example.demospringboot.entity.Teacher;
import com.example.demospringboot.service.CRUDService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements CRUDService<Teacher> {

    @Override
    public Teacher create(Teacher input) {
        return null;
    }

    @Override
    public List<Teacher> read() {
        return null;
    }

    @Override
    public Teacher update(Teacher newValue) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

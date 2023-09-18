package com.example.demospringboot.service.impl;

import com.example.demospringboot.entity.Student;
import com.example.demospringboot.repository.StudentRepository;
import com.example.demospringboot.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements CRUDService<Student> {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student input) {
        input.getCourses().forEach(course -> course.getStudents().add(input));
        return studentRepository.save(input);
    }

    @Override
    public List<Student> read() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Student newValue) {
        return studentRepository.save(newValue);
    }

    @Override
    public boolean delete(Long id) {
        studentRepository.deleteById(id);
        return true;
    }
}

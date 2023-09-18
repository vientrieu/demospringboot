package com.example.demospringboot.controller;

import com.example.demospringboot.dto.StudentDto;
import com.example.demospringboot.service.CRUDService;
import com.example.demospringboot.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Restful API gồm 4 method chính
 * GET: read
 * POST: create
 * PUT: update
 * DELETE: delete
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private CRUDService<StudentDto> studentCRUDService;
    @Autowired
    private RandomService randomService;

    @GetMapping
    public List<StudentDto> readStudents() {
        return studentCRUDService.read();
    }
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto input) {
        return studentCRUDService.create(input);
    }
    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto newValue) {
        return studentCRUDService.update(newValue);
    }
    @DeleteMapping
    public boolean deleteStudent(@RequestParam("id") Long id, @RequestParam("lop") Long lop) {
        return studentCRUDService.delete(id);
    }

    @GetMapping("/random-data")
    public Object random() {
        return randomService.random();
    }

}

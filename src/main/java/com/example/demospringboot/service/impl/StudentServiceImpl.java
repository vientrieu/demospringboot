package com.example.demospringboot.service.impl;

import com.example.demospringboot.dto.StudentDto;
import com.example.demospringboot.entity.Course;
import com.example.demospringboot.entity.Student;
import com.example.demospringboot.exception.CustomizeException;
import com.example.demospringboot.repository.CourseRepository;
import com.example.demospringboot.repository.StudentRepository;
import com.example.demospringboot.service.CRUDService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements CRUDService<StudentDto> {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @Transactional(noRollbackFor = CustomizeException.class)
    public StudentDto create(StudentDto input) {
        Student student = objectMapper.convertValue(input, Student.class);
        student.getCourses().clear();
        // kiểm tra dưới database khóa học này.
        input.getCourses().forEach(course -> {
            Course courseFound = courseRepository.findByCourseCode(course.getCourseCode());
            // Nếu tồn tại thì lưu
            if (courseFound != null) {
                courseFound.setCourseName(course.getCourseName());
                courseRepository.save(courseFound);
                student.getCourses().add(courseFound);
                // map từ dto => entity để tương tác với database
            } else { // nếu chưa thì ném ra lỗi là khóa học chưa tồn tại
                throw new CustomizeException("1001", "Mã khóa học " + course.getCourseCode() + " không được tìm thấy!");
            }
        });
        try {
            Student save = studentRepository.save(student);
            return objectMapper.convertValue(save, StudentDto.class);
        } catch (Exception e) {
            throw new CustomizeException("202", "Cái này lỗi nè!!!");
        }
    }

    @Override
    public List<StudentDto> read() {
        return studentRepository.findAll().stream()
                .map(entity -> objectMapper.convertValue(entity, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto update(StudentDto newValue) {
        newValue.getCourses().forEach(course -> course.getStudents().add(newValue));
        // map từ dto => entity để tương tác với database
        Student student = objectMapper.convertValue(newValue, Student.class);
        return objectMapper.convertValue(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public boolean delete(Long id) {
        studentRepository.deleteById(id);
        return true;
    }

    @VisibleForTesting
    public String mapData(String tenSinhVien, String lop) {
        return "Sinh vien " + tenSinhVien + " hoc lop " + lop;
    }

}

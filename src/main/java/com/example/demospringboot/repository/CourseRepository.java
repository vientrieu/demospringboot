package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    @Query("select c from Course c where c.courseCode = :courseCode")
//    @Query(value = "select * from course c where c.course_code = :courseCode", nativeQuery = true)
    Course findByCourseCode(String courseCode);
}

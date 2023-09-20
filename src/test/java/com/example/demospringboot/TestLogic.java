package com.example.demospringboot;

import com.example.demospringboot.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This is unit test class (UT = unit test)
 * Use junit4
 */
@RunWith(JUnit4.class)
public class TestLogic {

    @Test
    public void testMapdata() {
        StudentServiceImpl studentService = new StudentServiceImpl();
        String expected = "Sinh vien nam lop 11"; // ki vong
        String actual = studentService.mapData("nam", "11"); // thuc te
        Assert.assertEquals(expected, actual);
    }

}

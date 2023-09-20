package com.example.demospringboot;

import com.example.demospringboot.util.JwtUtil;
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
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateJwt();
    }

}

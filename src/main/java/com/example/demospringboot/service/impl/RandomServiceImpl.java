package com.example.demospringboot.service.impl;

import com.example.demospringboot.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RandomServiceImpl implements RandomService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Object random() {
        String url = "https://random-data-api.com/api/users/random_user";
        HttpEntity httpEntity = new HttpEntity(null);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);
    }
}

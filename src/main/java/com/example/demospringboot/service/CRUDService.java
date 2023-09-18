package com.example.demospringboot.service;

import java.util.List;

/**
 * Generic code for interface
 */
public interface CRUDService<T> {
    T create(T input);

    List<T> read();

    T update(T newValue);

    boolean delete(Long id);
}

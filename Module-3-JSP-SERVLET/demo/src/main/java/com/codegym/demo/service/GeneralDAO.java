package com.codegym.demo.service;

import com.codegym.demo.model.PaymentType;
import com.codegym.demo.model.RentRoom;

import java.util.List;

public interface GeneralDAO <E>{
    List<E> getAll();
    List<E> search(String key);
    void add(E entity);

    void insert(RentRoom room);

    void insert(PaymentType entity);

    void deleteById(int id);
}

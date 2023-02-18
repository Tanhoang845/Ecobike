package repository;

import entity.bikerenting.BikeRenting;
import exception.NotFoundException;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 19:46
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface Repository<T> {
    List<T> getAll();

    T findById(String id) throws NotFoundException;


    T save(T t);

    void delete(T t);

    void update(T t);
}

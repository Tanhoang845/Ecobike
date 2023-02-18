package repository;

import entity.bikerenting.BikeRenting;
import entity.user.User;
import exception.BikeRentingNotFoundException;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 23:10
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface BikeRentingRepository extends Repository<BikeRenting> {
    @Override
    List<BikeRenting> getAll();

    @Override
    BikeRenting findById(String id) throws BikeRentingNotFoundException;

    @Override
    BikeRenting save(BikeRenting bikeRenting);

    @Override
    void delete(BikeRenting bikeRenting);

    BikeRenting findByUser(User user) throws BikeRentingNotFoundException;
}

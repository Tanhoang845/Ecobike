package repository;

import entity.bike.Bike;
import entity.parking.Parking;
import exception.BikeNotFoundException;
import exception.NotFoundException;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 22:09
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface BikeRepository extends Repository<Bike> {
    @Override
    List<Bike> getAll();

    @Override
    Bike findById(String id) throws BikeNotFoundException;

    List<Bike> findByParking(Parking parking);

    @Override
    Bike save(Bike bike);

    @Override
    void delete(Bike bike);
}

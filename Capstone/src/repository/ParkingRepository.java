package repository;

import entity.parking.Parking;
import exception.NotFoundException;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 22:11
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface ParkingRepository extends Repository<Parking> {
    @Override
    List<Parking> getAll();

    @Override
    Parking findById(String id) throws NotFoundException;

    @Override
    Parking save(Parking parking);

    @Override
    void delete(Parking parking);

    int getTotalAvailable(Parking parking);
}

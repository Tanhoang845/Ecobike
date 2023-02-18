package repository;

import entity.parking.Parking;
import entity.parking.Place;
import exception.NotFoundException;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 23:10
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface PlaceRepository extends Repository<Place> {
    @Override
    List<Place> getAll();

    @Override
    Place findById(String id) throws NotFoundException;

    @Override
    Place save(Place place);

    @Override
    void delete(Place place);

    Place findByBike(String bikeID);
    List<Place> findByParking(Parking parking);
}

package controller;


import entity.parking.Parking;
import factory.DBFactory;
import repository.ParkingRepository;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 00:22
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class HomeController extends BaseController {
    public List<Parking> getAllParking() {
        DBFactory dbFactory = getDbFactory();
        ParkingRepository parkingRepository = dbFactory.getParkingRepository();
        return parkingRepository.getAll();
    }
}

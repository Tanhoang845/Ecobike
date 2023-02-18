package controller;

import entity.parking.Parking;
import factory.DBFactory;
import repository.ParkingRepository;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 23:46
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ViewParkingController extends BaseController {
    public int getTotalFreeHost(Parking parking) {
        DBFactory dbFactory = getDbFactory();
        ParkingRepository parkingRepository = dbFactory.getParkingRepository();
        return parkingRepository.getTotalAvailable(parking);
    }
}

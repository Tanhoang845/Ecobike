package controller;

import barcode.BarCodeAPI;
import entity.bike.Bike;
import entity.parking.Parking;
import factory.DBFactory;
import repository.BikeRepository;
import repository.ParkingRepository;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 08/02/2023
 * @Time: 00:27
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ViewBikesController extends BaseController {
    BarCodeAPI barCodeAPI;

    public List<Bike> getAllBike(Parking parking) {
        DBFactory dbFactory = getDbFactory();
        BikeRepository bikeRepository = dbFactory.getBikeRepository();
        return bikeRepository.findByParking(parking);
    }
    public BarCodeAPI getBarCodeAPI() {
        return barCodeAPI;
    }

    public void setBarCodeAPI(BarCodeAPI barCodeAPI) {
        this.barCodeAPI = barCodeAPI;
    }

    public String getBarCode(String bikeCode) {
        return barCodeAPI.toBarCode(bikeCode);
    }

    public String getBikeCode(String barCode) {
        return barCodeAPI.toBikeCode(barCode);
    }
}

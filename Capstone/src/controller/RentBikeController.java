package controller;

import barcode.BarCodeAPI;
import barcode.MyBarCode;
import entity.bike.Bike;
import entity.bikerenting.BikeRenting;
import entity.parking.Place;
import exception.BikeNotFoundException;
import exception.BikeStatusIsNotFreeException;
import exception.UserNotFoundException;
import factory.DBFactory;
import factory.SQLBDFactory;
import utils.ENV;

import java.util.Date;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 10/02/2023
 * @Time: 17:37
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class RentBikeController extends BaseController {

    BarCodeAPI barCodeAPI;

    public BarCodeAPI getBarCodeAPI() {
        return barCodeAPI;
    }

    public void setBarCodeAPI(BarCodeAPI barCodeAPI) {
        this.barCodeAPI = barCodeAPI;
    }

    public String getBarCode(String bikeCode) {
        return barCodeAPI.toBarCode(bikeCode);
    }

    public Bike getBike(String barCode) throws BikeNotFoundException, BikeStatusIsNotFreeException {
        String id = barCodeAPI.toBikeCode(barCode);
        DBFactory dbFactory = getDbFactory();
        Bike bike = dbFactory.getBikeRepository().findById(id);
        if (!bike.getStatus().equals("free")) {
            throw new BikeStatusIsNotFreeException();
        }
        return bike;
    }

    public void rentBike(Bike bike) {
        bike.setStatus("using");
        DBFactory dbFactory = getDbFactory();
        dbFactory.getBikeRepository().update(bike);
        //
        Place place = dbFactory.getPlaceRepository().findByBike(bike.getId());
        dbFactory.getPlaceRepository().delete(place);
        //
        try {
            BikeRenting bikeRenting = new BikeRenting(new Date().getTime(), bike, dbFactory.getUserRepository().findById(ENV.getenv("USER_ID")));
            dbFactory.getBikeRentingRepository().save(bikeRenting);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws BikeNotFoundException, BikeStatusIsNotFreeException {
        setDbFactory(new SQLBDFactory());
        RentBikeController c = new RentBikeController();
        c.setBarCodeAPI(new MyBarCode());
        System.out.println(c.getBike("#99998"));
    }
}

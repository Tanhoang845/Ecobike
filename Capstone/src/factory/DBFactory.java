package factory;

import repository.*;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:27
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public interface DBFactory {
    BikeRepository getBikeRepository();
    BikeRentingRepository getBikeRentingRepository();
    ParkingRepository getParkingRepository();
    PlaceRepository getPlaceRepository();

    UserRepository getUserRepository();
}

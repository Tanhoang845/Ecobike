package factory;

import repository.*;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:31
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class SQLBDFactory implements DBFactory {
    private static BikeRepositorySQL bikeRepositorySQLInstance;
    private static BikeRentingRepositorySQL bikeRentingRepositorySQL;
    private static ParkingRepositorySQL parkingRepositorySQL;
    private static PlaceRepositorySQL placeRepositorySQL;
    private static UserRepositorySQL userRepositorySQL;

    @Override
    public BikeRepository getBikeRepository() {
        if (bikeRepositorySQLInstance == null) return bikeRepositorySQLInstance = new BikeRepositorySQL();
        return bikeRepositorySQLInstance;
    }

    @Override
    public BikeRentingRepository getBikeRentingRepository() {
        if (bikeRentingRepositorySQL == null) return bikeRentingRepositorySQL = new BikeRentingRepositorySQL();
        return bikeRentingRepositorySQL;
    }

    @Override
    public ParkingRepository getParkingRepository() {
        if (parkingRepositorySQL == null) return parkingRepositorySQL = new ParkingRepositorySQL();
        return parkingRepositorySQL;
    }

    @Override
    public PlaceRepository getPlaceRepository() {
        if (placeRepositorySQL == null) return placeRepositorySQL = new PlaceRepositorySQL();
        return placeRepositorySQL;
    }

    @Override
    public UserRepository getUserRepository() {
        if (userRepositorySQL == null) return userRepositorySQL = new UserRepositorySQL();
        return userRepositorySQL;
    }
}

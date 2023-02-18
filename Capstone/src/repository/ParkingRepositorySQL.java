package repository;

import db.Database;
import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.parking.Parking;
import entity.parking.Place;
import exception.NotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:35
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ParkingRepositorySQL implements ParkingRepository {
    @Override
    public List<Parking> getAll() {
        List<Parking> parkings = new ArrayList<>();
        Parking temp;
        Database db = Database.getInstance();
        try {
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM parking");
            while (results.next()) {
                temp = new Parking(results.getString("ID"), results.getString("Name"), results.getString("Address"), results.getInt("MaxHost"), results.getInt("Area"));
                parkings.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return parkings;
    }

    @Override
    public Parking findById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public Parking save(Parking parking) {
        return null;
    }

    @Override
    public void delete(Parking parking) {

    }

    @Override
    public int getTotalAvailable(Parking parking) {
        Database db = Database.getInstance();
        int totalAvailableBike = 0;
        try {
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) as totalAvailableBike from place where ParkingID = '%s';".formatted(parking.getId()));
            resultSet.next();
            totalAvailableBike = resultSet.getInt("totalAvailableBike");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalAvailableBike;
    }

    @Override
    public void update(Parking parking) {

    }

    public static void main(String[] args) {
        int a = new ParkingRepositorySQL().getTotalAvailable(new Parking("p00002", "", "", 10, 1f));
        System.out.println(a);
    }
}

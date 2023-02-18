package repository;

import db.Database;
import entity.parking.Parking;
import entity.parking.Place;
import exception.NotFoundException;
import factory.DBFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:36
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class PlaceRepositorySQL implements PlaceRepository {
    @Override
    public List<Place> getAll() {
        return null;
    }

    @Override
    public Place findById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public Place save(Place place) {
        String query = "INSERT INTO place values ('%s', '%s', %d)".formatted(place.getParkingID(), place.getBikeID(), place.getHostNumber());        Database database = Database.getInstance();
        try {
            Statement statement = database.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Place place) {
        String query = "DELETE from place where ParkingID='%s' and BikeID='%s' and HostNumber=%d".formatted(place.getParkingID(), place.getBikeID(), place.getHostNumber());
        Database database = Database.getInstance();
        try {
            Statement statement = database.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Place findByBike(String bikeID) {
        String query = "SELECT * FROM place where BikeID = '%s'".formatted(bikeID);
        Database database = Database.getInstance();
        try {
            Statement statement = database.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return new Place(resultSet.getString("ParkingID"), resultSet.getInt("HostNumber"), resultSet.getString("BikeID"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Place> findByParking(Parking parking) {
        String query = "SELECT * FROM place where ParkingID = '%s'".formatted(parking.getId());
        Database database = Database.getInstance();
        List<Place> places = new ArrayList<>();
        try {
            Statement statement = database.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                places.add(new Place(resultSet.getString("ParkingID"), resultSet.getInt("HostNumber"), resultSet.getString("BikeID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return places;
    }

    @Override
    public void update(Place place) {

    }
}

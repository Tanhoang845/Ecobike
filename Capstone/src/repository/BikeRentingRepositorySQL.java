package repository;

import db.Database;
import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.bikerenting.BikeRenting;
import entity.user.User;
import exception.BikeNotFoundException;
import exception.BikeRentingNotFoundException;
import exception.NotFoundException;
import factory.DBFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:34
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class BikeRentingRepositorySQL implements BikeRentingRepository {
    @Override
    public List<BikeRenting> getAll() {
        return null;
    }

    @Override
    public BikeRenting findById(String id) throws BikeRentingNotFoundException {
        return null;
    }

    @Override
    public BikeRenting save(BikeRenting bikeRenting) {
        String query = "INSERT INTO rentbike (UserID, BikeID) values ('%s','%s')".formatted(bikeRenting.getUser().getId(), bikeRenting.getBike().getId());
        Database database = Database.getInstance();
        try {
            Statement statement = database.createStatement();
            statement.execute(query);
            return bikeRenting;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(BikeRenting bikeRenting) {

    }

    @Override
    public void update(BikeRenting bikeRenting) {
        String query = "UPDATE rentbike set isReturned = %d where ID = %s".formatted(bikeRenting.isReturned() ? 1 : 0, bikeRenting.getId());
        Database db = Database.getInstance();
        try{
            Statement statement = db.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BikeRenting findByUser(User user) throws BikeRentingNotFoundException {
        Database db = Database.getInstance();
        try {
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from rentbike where UserId = '%s' and isReturned = 0".formatted(user.getId()));
            if (!resultSet.next()) throw new BikeRentingNotFoundException();
            String id = resultSet.getString("ID");
            String bikeID = resultSet.getString("BikeID");
            Date rentAt = resultSet.getTimestamp("RentedAt");
            Bike bike = new BikeRepositorySQL().findById(bikeID);
            return new BikeRenting(id, rentAt.getTime(), bike, user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (BikeNotFoundException e) {
            throw new BikeRentingNotFoundException();
        }
    }
}

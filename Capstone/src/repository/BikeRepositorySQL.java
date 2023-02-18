package repository;

import db.Database;
import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
import entity.parking.Parking;
import exception.BikeNotFoundException;
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
 * @Time: 00:30
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class BikeRepositorySQL implements BikeRepository {
    @Override
    public List<Bike> getAll() {
        return null;
    }

    @Override
    public Bike findById(String id) throws BikeNotFoundException {
        Database db = Database.getInstance();
        Bike bike = null;
        try {
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bike where ID = '%s'".formatted(id));
            if (!resultSet.next()) throw new BikeNotFoundException();
            String query = "select bike.*, standardbike.ID SE, standardebike.ID S, twinbike.ID T, Battery from bike left join standardbike on bike.ID = standardbike.ID left join standardebike on bike.ID = standardebike.ID left join twinbike\n" +
                    "on bike.ID = twinbike.ID where bike.ID = '%s';";
            resultSet = statement.executeQuery(query.formatted(id));
            resultSet.next();
            String a = resultSet.getString("SE");
            String b = resultSet.getString("S");
            String c = resultSet.getString("T");
            if (a != null)
                return new StandardBike(id, resultSet.getString("Name"), resultSet.getString("LicensePlate"), resultSet.getString("Status"));
            if (b != null)
                return new StandardEBike(id, resultSet.getString("Name"), resultSet.getString("LicensePlate"), resultSet.getString("Status"), resultSet.getInt("Battery"));
            return new TwinBike(id, resultSet.getString("Name"), resultSet.getString("LicensePlate"), resultSet.getString("Status"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BikeNotFoundException();
        }
    }

    @Override
    public List<Bike> findByParking(Parking parking) {
        Database db = Database.getInstance();
        List<Bike> bikes = new ArrayList<>();
        try {
            Statement statement = db.createStatement();
            ResultSet standardSet = statement.executeQuery(("select bike.* from bike, standardbike type " +
                    "where bike.ID = type.ID and bike.ID in (select BikeID from place where ParkingID = '%s');").formatted(parking.getId()));
            statement = db.createStatement();
            ResultSet standardESet = statement.executeQuery(("select bike.*, type.Battery from bike, standardebike type " +
                    "where bike.ID = type.ID and bike.ID in (select BikeID from place where ParkingID = '%s');").formatted(parking.getId()));
            statement = db.createStatement();
            ResultSet twinSet = statement.executeQuery(("select bike.* from bike, twinbike type " +
                    "where bike.ID = type.ID and bike.ID in (select BikeID from place where ParkingID = '%s');").formatted(parking.getId()));
            while (standardSet.next()) {
                bikes.add(new StandardBike(standardSet.getString("ID"), standardSet.getString("Name"),
                        standardSet.getString("LicensePlate"), standardSet.getString("Status")));
            }
            while (standardESet.next()) {
                bikes.add(new StandardEBike(standardESet.getString("ID"), standardESet.getString("Name"),
                        standardESet.getString("LicensePlate"), standardESet.getString("Status"), standardESet.getInt("Battery")));
            }
            while (twinSet.next()) {
                bikes.add(new TwinBike(twinSet.getString("ID"), twinSet.getString("Name"),
                        twinSet.getString("LicensePlate"), twinSet.getString("Status")));
            }
            System.out.println(bikes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bikes;
    }

    @Override
    public Bike save(Bike bike) {
        return null;
    }

    @Override
    public void delete(Bike bike) {

    }

    @Override
    public void update(Bike bike) {
        Database db = Database.getInstance();
        try {
            Statement statement = db.createStatement();
            statement.executeUpdate("UPDATE bike set Name = '%s', LicensePlate = '%s', Status = '%s' where ID = '%s'".
                    formatted(bike.getName(), bike.getLicensePlate(), bike.getStatus(), bike.getId()));
            if (bike instanceof StandardEBike eBike){
                Statement statement1 = db.createStatement();
                statement1.executeUpdate("UPDATE standardebike set Battery=%d where ID='%s'".formatted(eBike.getBattery() ,eBike.getId()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws BikeNotFoundException {
        System.out.println(new BikeRepositorySQL().findById("b00036"));
    }
}

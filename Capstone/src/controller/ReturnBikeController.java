package controller;

import calculator.PriceCalculator;
import calculator.RentalFeeCalculator;
import entity.bike.Bike;
import entity.bikerenting.BikeRenting;
import entity.parking.Parking;
import entity.parking.Place;
import factory.DBFactory;
import repository.BikeRentingRepository;
import repository.BikeRepository;
import repository.ParkingRepository;
import repository.PlaceRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:44
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ReturnBikeController extends BaseController {
    private RentalFeeCalculator calculator = new RentalFeeCalculator();

    public List<Parking> getAllParking() {
        DBFactory dbFactory = getDbFactory();
        ParkingRepository parkingRepository = dbFactory.getParkingRepository();
        return parkingRepository.getAll();
    }

    public boolean checkDockValid(Parking parking) {
        int totalHost = parking.getTotalHost();
        int usingHost = parking.getPlaces().size();
        return totalHost > usingHost;
    }

    public void returnBike(BikeRenting rentbike, Parking parking) {
        DBFactory dbFactory = getDbFactory();
        //todo
        //step1: thay đổi trạng thái của rentbike là đã trả
        rentbike.setReturned(true);
        BikeRentingRepository bikeRentingRepository = dbFactory.getBikeRentingRepository();
        bikeRentingRepository.update(rentbike);
        //step2: thêm bike vào parking tương ứng
        PlaceRepository placeRepository = dbFactory.getPlaceRepository();
        List<Place> places = placeRepository.findByParking(parking);
        List<Integer> hostNumbers = new ArrayList<>();
        Bike bike = rentbike.getBike();
        places.forEach(place -> {
            hostNumbers.add(place.getHostNumber());
        });
        int number = 0;
        for (int i = 1; i <= parking.getTotalHost(); i++) {
            if (!hostNumbers.contains(i)) {
                number = i;
                break;
            }
        }
        Place place = new Place(parking.getId(), number, bike.getId());
        placeRepository.save(place);
        //step3: thay đổi trạng thái của xe sang free
        bike.setStatus("free");
        BikeRepository bikeRepository = dbFactory.getBikeRepository();
        bikeRepository.update(bike);
    }

    public int calculatePrice(BikeRenting bikeRenting, int rentTime) {
        calculator.setCalculator(bikeRenting.getBike().getCalculator());
        return calculator.calculateRentalFee(rentTime);
    }

    public int calculateRentTime(BikeRenting bikeRenting) {
        PriceCalculator priceCalculator = bikeRenting.getBike().getCalculator();
        calculator.setCalculator(priceCalculator);
        return calculator.calculateUseTime(bikeRenting.getStartTime());
    }
}

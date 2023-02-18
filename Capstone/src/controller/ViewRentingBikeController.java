package controller;

import calculator.PriceCalculator;
import calculator.RentalFeeCalculator;
import entity.bikerenting.BikeRenting;
import exception.BikeRentingNotFoundException;
import exception.UserNotFoundException;
import factory.DBFactory;
import repository.BikeRentingRepository;
import repository.UserRepository;
import utils.ENV;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:44
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ViewRentingBikeController extends BaseController {
    private final RentalFeeCalculator calculator = new RentalFeeCalculator();

    public BikeRenting getBikeRenting() throws BikeRentingNotFoundException {
        DBFactory dbFactory = getDbFactory();
        BikeRentingRepository bikeRentingRepository = dbFactory.getBikeRentingRepository();
        UserRepository userRepository = dbFactory.getUserRepository();
        try {
            return bikeRentingRepository.findByUser(userRepository.findById(ENV.getenv("USER_ID")));
        } catch (UserNotFoundException | BikeRentingNotFoundException e) {
            throw new BikeRentingNotFoundException();
        }
    }

    public int calculateRentTime(BikeRenting bikeRenting) {
        PriceCalculator priceCalculator = bikeRenting.getBike().getCalculator();
        calculator.setCalculator(priceCalculator);
        return calculator.calculateUseTime(bikeRenting.getStartTime());
    }

    public int calculatePrice(BikeRenting bikeRenting, int rentTime) {
        calculator.setCalculator(bikeRenting.getBike().getCalculator());
        return calculator.calculateRentalFee(rentTime);
    }
}

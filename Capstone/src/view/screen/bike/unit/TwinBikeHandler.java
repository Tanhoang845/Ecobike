package view.screen.bike.unit;

import entity.bike.TwinBike;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 01:46
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class TwinBikeHandler extends BikeHandler {

    public TwinBikeHandler(String path, TwinBike bike, String barcode) {
        super(path, bike, barcode);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        bikeImg.getStyleClass().add("bike2");
    }
}

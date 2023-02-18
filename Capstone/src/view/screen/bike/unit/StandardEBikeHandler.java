package view.screen.bike.unit;


import entity.bike.StandardEBike;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 01:46
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class StandardEBikeHandler extends BikeHandler {

    public StandardEBikeHandler(String path, StandardEBike bike, String barcode) {
        super(path, bike, barcode);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        bikeImg.getStyleClass().add("bike3");
    }
}

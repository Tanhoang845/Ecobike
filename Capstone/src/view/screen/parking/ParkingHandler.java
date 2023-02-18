package view.screen.parking;

import entity.parking.Parking;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import view.screen.ContentHandler;
import view.screen.home.HomeScreenHandler;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 23:00
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ParkingHandler extends ContentHandler {
    private Parking parking;
    private HomeScreenHandler homeScreen;
    @FXML
    Hyperlink parkingName;

    public ParkingHandler(String path, Parking parking) {
        super(path);
        this.parking = parking;
        setInfo();
    }

    public void setInfo() {
        parkingName.setText(parking.getName());
    }
}

package view.screen.bike.unit;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import view.screen.ContentHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 01:44
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class BikeHandler extends ContentHandler implements Initializable {
    Bike bike;
    @FXML
    Hyperlink bikeName;
    @FXML
    Pane bikeImg;
    @FXML
    Label barcode;
    String barCode;

    public BikeHandler(String path, Bike bike, String barcode) {
        super(path);
        this.bike = bike;
        this.barCode = barcode;
        setInfo();
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public void setInfo() {
        bikeName.setText(bike.getName());
        barcode.setText(barCode);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bikeImg.getStyleClass().add("bikeImg");
    }
}

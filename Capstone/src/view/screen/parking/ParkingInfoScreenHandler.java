package view.screen.parking;

import barcode.MyBarCode;
import controller.BaseController;
import controller.ViewBikesController;
import controller.ViewParkingController;
import entity.parking.Parking;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.bike.ViewBikesScreenHandler;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 00:31
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ParkingInfoScreenHandler extends BaseScreenHandler {
    private final Parking parking;
    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label phone;
    @FXML
    private Label area;
    @FXML
    private Label freeBikeNum;
    @FXML
    private Label usingBikeNum;
    @FXML
    private Label totalBikeNum;
    @FXML
    private ButtonBar viewBikesBtn;

    public ParkingInfoScreenHandler(String path, Stage stage, Parking parking) {
        super(path, stage);
        this.parking = parking;
    }

    @Override
    public ViewParkingController getController() {
        return (ViewParkingController) super.getController();
    }

    @Override
    public void initProp() {
        super.initProp();
        name.setText(parking.getName());
        address.setText(parking.getAddress());
        phone.setText("0353763078");
        area.setText(parking.getArea() + "M2");
        int totalBikeNum = parking.getTotalHost();
        int freeBikeNum = getController().getTotalFreeHost(parking);
        int usingBikeNum = totalBikeNum - freeBikeNum;
        this.totalBikeNum.setText(totalBikeNum + "");
        this.usingBikeNum.setText(usingBikeNum + "");
        this.freeBikeNum.setText(freeBikeNum + "");
    }

    @Override
    public void initEvent() {
        super.initEvent();
        viewBikesBtn.setOnMouseClicked(this::viewBikes);
    }

    private void viewBikes(MouseEvent mouseEvent) {
        ViewBikesScreenHandler viewBikesScreen = new ViewBikesScreenHandler(Configs.VIEW_BIKES_SCREEN_PATH, this.stage, parking);
        viewBikesScreen.setHomeScreen(this.getHomeScreen());
        viewBikesScreen.setPreviousScreen(this);
        ViewBikesController viewBikesController = new ViewBikesController();
        viewBikesController.setBarCodeAPI(new MyBarCode());
        viewBikesScreen.setController(viewBikesController);
        viewBikesScreen.show();
    }
}

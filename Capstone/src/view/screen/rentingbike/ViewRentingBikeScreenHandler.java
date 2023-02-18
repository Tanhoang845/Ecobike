package view.screen.rentingbike;

import controller.ReturnBikeController;
import controller.ViewRentingBikeController;
import entity.bike.Bike;
import entity.bike.StandardEBike;
import entity.bikerenting.BikeRenting;
import exception.BikeRentingNotFoundException;
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
import view.screen.returnbike.SelectDockScreenHandler;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 09:16
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ViewRentingBikeScreenHandler extends BaseScreenHandler {
    private BikeRenting bikeRenting;
    @FXML
    private Label type;
    @FXML
    private Label battery;
    @FXML
    private Label bikeName;
    @FXML
    private Label rentedAt;
    @FXML
    private Label rentTime;
    @FXML
    private Label price;
    @FXML
    private ButtonBar returnBikeBtn;

    public ViewRentingBikeScreenHandler(String path, Stage stage, ViewRentingBikeController controller) throws BikeRentingNotFoundException {
        super(path, stage);
        this.setController(controller);
        bikeRenting = getController().getBikeRenting();
    }

    @Override
    public ViewRentingBikeController getController() {
        return (ViewRentingBikeController) super.getController();
    }

    @Override
    public void initProp() {
        super.initProp();
        Bike bike = bikeRenting.getBike();
        type.setText(bike.getType());
        battery.setText("Null");
        if (bike instanceof StandardEBike eBike) {
            battery.setText(eBike.getBattery() + "%");
        }
        bikeName.setText(bike.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        rentedAt.setText(sdf.format(new Date(bikeRenting.getStartTime())));
        int rentTimeNum = getController().calculateRentTime(bikeRenting);
        rentTime.setText(rentTimeNum + " Minute");
        price.setText(getController().calculatePrice(bikeRenting, rentTimeNum) + " VND");
    }

    @Override
    public void initEvent() {
        super.initEvent();
        returnBikeBtn.setOnMouseClicked(this::returnBike);
    }

    private void returnBike(MouseEvent mouseEvent) {
        SelectDockScreenHandler selectDockScreen = new SelectDockScreenHandler(Configs.SELECT_DOCK_SCREEN_PATH, stage);
        selectDockScreen.setController(new ReturnBikeController());
        selectDockScreen.setBikeRenting(bikeRenting);
        selectDockScreen.setHomeScreen(this);
        selectDockScreen.setPreviousScreen(this);
        selectDockScreen.show();
    }
}

package view.screen.returnbike;

import controller.BaseController;
import controller.ReturnBikeController;
import entity.bikerenting.BikeRenting;
import entity.parking.Parking;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import view.screen.BaseScreenHandler;
import view.screen.popup.Popup;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 12/02/2023
 * @Time: 00:13
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ReturnBikeInfoScreenHandler extends BaseScreenHandler {
    private BikeRenting bikeRenting;
    private Parking parking;
    @FXML
    private Label rentedAt;
    @FXML
    private Label rentTime;
    @FXML
    private Label price;
    @FXML
    private Label deposit;
    @FXML
    private Label amount;
    @FXML
    private ButtonBar paymentBtn;

    public ReturnBikeInfoScreenHandler(String path, Stage stage, BikeRenting bikeRenting) {
        super(path, stage);
        this.bikeRenting = bikeRenting;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void initProp() {
        super.initProp();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        rentedAt.setText(sdf.format(new Date(bikeRenting.getStartTime())));
        int time = getController().calculateRentTime(bikeRenting);
        rentTime.setText(time + "Minute");
        int price1 = getController().calculatePrice(bikeRenting, time);
        price.setText(price1 + " VND");
        deposit.setText(bikeRenting.getBike().getDepositPrice() + " VND");
        amount.setText((price1 - bikeRenting.getBike().getDepositPrice()) + " VND");
    }

    @Override
    public void initEvent() {
        super.initEvent();
        paymentBtn.setOnMouseClicked(e -> {
            int rentalFee = getController().calculatePrice(bikeRenting, getController().calculateRentTime(bikeRenting));
            //todo chuyển sang usecase thanh toán
            getController().returnBike(bikeRenting, parking);
            Popup popup = Popup.popup("Return bike success", Popup.PopupType.SUCCESS);
            popup.setOnOK(e1 -> {
                getHomeScreen().show();
            });
            popup.show();
        });
    }

    @Override
    public ReturnBikeController getController() {
        return (ReturnBikeController) super.getController();
    }
}

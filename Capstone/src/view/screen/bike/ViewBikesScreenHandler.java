package view.screen.bike;

import barcode.MyBarCode;
import controller.RentBikeController;
import controller.ViewBikesController;
import entity.bike.Bike;
import entity.bike.StandardBike;
import entity.bike.StandardEBike;
import entity.bike.TwinBike;
import entity.parking.Parking;
import exception.BarCodeInvalidException;
import exception.BikeStatusIsNotFreeException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.bike.unit.BikeHandler;
import view.screen.bike.unit.StandardBikeHandler;
import view.screen.bike.unit.StandardEBikeHandler;
import view.screen.bike.unit.TwinBikeHandler;
import view.screen.bike.viewbike.ViewBikeScreenHandler;
import view.screen.bike.viewbike.ViewStandardBikeScreenHandler;
import view.screen.popup.InputBarcodeHandler;
import view.screen.popup.Popup;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 01:54
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ViewBikesScreenHandler extends BaseScreenHandler {
    private Parking parking;
    @FXML
    private VBox box1;
    @FXML
    private VBox box2;
    @FXML
    private VBox box3;
    @FXML
    private ButtonBar rentBikeBtn;

    public ViewBikesScreenHandler(String path, Stage stage, Parking parking) {
        super(path, stage);
        this.parking = parking;
    }

    @Override
    public ViewBikesController getController() {
        return (ViewBikesController) super.getController();
    }

    public void showBikeInfo(Bike bike) {
        ViewBikeScreenHandler viewBikeScreen = new ViewBikeScreenHandler(Configs.BIKE_SCREEN_PATH, stage, bike);
        viewBikeScreen.setPreviousScreen(this);
        viewBikeScreen.setHomeScreen(getHomeScreen());
        viewBikeScreen.setBarcode(getController().getBarCode(bike.getId()));
        viewBikeScreen.show();
    }

    public void showRentBikeInfo(String barcode) throws BarCodeInvalidException, BikeStatusIsNotFreeException {
        RentBikeController controller = new RentBikeController();
        controller.setBarCodeAPI(new MyBarCode());
        RentBikeScreenHandler rentBikeScreen = new RentBikeScreenHandler(Configs.RENT_BIKE_SCREEN_PATH, stage, barcode, controller);
        rentBikeScreen.setHomeScreen(getHomeScreen());
        rentBikeScreen.setPreviousScreen(this);
        rentBikeScreen.show();

    }

    @Override
    public void initProp() {
        super.initProp();
        box1.getChildren().clear();
        box2.getChildren().clear();
        box3.getChildren().clear();
        List<Bike> bikes = this.getController().getAllBike(parking);
        EventHandler<MouseEvent> event = null;
        for (int i = 0; i < bikes.size(); i++) {
            BikeHandler bikeHandler = null;
            Bike bike = bikes.get(i);
            System.out.println(bike);
            if (bike instanceof StandardBike)
                bikeHandler = new StandardBikeHandler(Configs.BIKE_SHOW_PATH, (StandardBike) bike, getController().getBarCode(bike.getId()));
            else if (bike instanceof StandardEBike)
                bikeHandler = new StandardEBikeHandler(Configs.BIKE_SHOW_PATH, (StandardEBike) bike, getController().getBarCode(bike.getId()));
            else if (bike instanceof TwinBike)
                bikeHandler = new TwinBikeHandler(Configs.BIKE_SHOW_PATH, (TwinBike) bike, getController().getBarCode(bike.getId()));
            event = e -> {
                showBikeInfo(bike);
            };
            VBox box;
            if (i % 3 == 0) box = box1;
            else if (i % 3 == 1) box = box2;
            else box = box3;
            bikeHandler.setMouseClickEvent(event);
            box.getChildren().add(bikeHandler.getContent());
        }
    }

    @Override
    public void initEvent() {
        super.initEvent();
        rentBikeBtn.setOnMouseClicked(this::showInputBarCode);
    }

    private void showInputBarCode(MouseEvent mouseEvent) {
        InputBarcodeHandler p = new InputBarcodeHandler(Configs.INPUT_BARCODE_POPUP_PATH);
        p.setOnOK(e -> {
            try {
                showRentBikeInfo("#" + p.getResult());
            } catch (BarCodeInvalidException ex) {
                Popup.popup("BarCode is invalid!", Popup.PopupType.ERROR).show();
            } catch (BikeStatusIsNotFreeException ex) {
                Popup.popup("Bike is using!", Popup.PopupType.ERROR).show();
            }
        });
        p.show();
    }
}

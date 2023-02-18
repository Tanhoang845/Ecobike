package view.screen.returnbike;

import controller.ReturnBikeController;
import entity.bikerenting.BikeRenting;
import entity.parking.Parking;
import exception.DockInvalidException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.parking.ParkingHandler;
import view.screen.popup.Popup;

import java.util.List;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 14:28
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class SelectDockScreenHandler extends BaseScreenHandler {
    @FXML
    private VBox box1;
    @FXML
    private VBox box2;
    @FXML
    private VBox box3;
    private BikeRenting bikeRenting;

    public SelectDockScreenHandler(String path, Stage stage) {
        super(path, stage);
    }

    @Override
    public ReturnBikeController getController() {
        return (ReturnBikeController) super.getController();
    }

    public void selectDock(Parking parking) throws DockInvalidException {
        if (getController().checkDockValid(parking)) {
            Popup popup = Popup.popup("Return bike to " + parking.getName() + " parking", Popup.PopupType.INFO);
            popup.setOnOK(e -> {
                this.confirmReturnBike(parking);
            });
            popup.show();
        } else throw new DockInvalidException();
    }

    public void confirmReturnBike(Parking parking) {
        ReturnBikeInfoScreenHandler returnBikeInfoScreen = new ReturnBikeInfoScreenHandler(Configs.RETURN_BIKE_INFO_SCREEN_PATH, stage, bikeRenting);
        returnBikeInfoScreen.setPreviousScreen(this);
        returnBikeInfoScreen.setHomeScreen(getHomeScreen());
        returnBikeInfoScreen.setController(getController());
        returnBikeInfoScreen.setParking(parking);
        returnBikeInfoScreen.show();
    }

    public void setBikeRenting(BikeRenting bikeRenting) {
        this.bikeRenting = bikeRenting;
    }

    @Override
    public void initProp() {
        super.initProp();
        box1.getChildren().clear();
        box2.getChildren().clear();
        box3.getChildren().clear();
        List<Parking> parkings = this.getController().getAllParking();
        EventHandler<MouseEvent> event;
        for (int i = 0; i < parkings.size(); i++) {
            Parking p = parkings.get(i);
            ParkingHandler parkingHandler = new ParkingHandler(Configs.PARKING_SHOW_PATH, p);
            event = (e) -> {
                try {
                    this.selectDock(p);
                } catch (DockInvalidException ex) {
                    Popup popup = Popup.popup("Dock Invalid", Popup.PopupType.ERROR);
                    popup.show();
                }
            };
            parkingHandler.setMouseClickEvent(event);
            VBox box;
            if (i % 3 == 0) box = box1;
            else if (i % 3 == 1) box = box2;
            else box = box3;
            box.getChildren().add(parkingHandler.getContent());
        }
    }
}

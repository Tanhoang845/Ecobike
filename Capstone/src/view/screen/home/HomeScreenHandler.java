package view.screen.home;

import controller.HomeController;
import controller.ReturnBikeController;
import controller.ViewParkingController;
import controller.ViewRentingBikeController;
import entity.parking.Parking;
import exception.BikeRentingNotFoundException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.BaseScreenHandler;
import view.screen.parking.ParkingHandler;
import view.screen.parking.ParkingInfoScreenHandler;
import view.screen.popup.Popup;
import view.screen.rentingbike.ViewRentingBikeScreenHandler;
import view.screen.returnbike.SelectDockScreenHandler;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 21:20
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class HomeScreenHandler extends BaseScreenHandler{
    @FXML
    private VBox box1;
    @FXML
    private VBox box2;
    @FXML
    private VBox box3;
    @FXML
    private TextField searchField;
    @FXML
    private ButtonBar viewRentingBikeBtn;

    @FXML
    private ButtonBar returnBikeBtn;

    public HomeScreenHandler(String path, Stage stage) {
        super(path, stage);
    }

    @Override
    public HomeController getController() {
        return (HomeController) super.getController();
    }

    @Override
    public void initProp() {
        super.initProp();
        box1.getChildren().clear();
        box2.getChildren().clear();
        box3.getChildren().clear();
        List<Parking> parkings = this.getController().getAllParking();
        EventHandler<MouseEvent> clickParkingEvent;

        for (int i = 0; i < parkings.size(); i++) {
            Parking p = parkings.get(i);
            ParkingHandler parkingHandler = new ParkingHandler(Configs.PARKING_SHOW_PATH, p);
            clickParkingEvent = (e) -> {
                this.showParkingInfo(p);
            };
            parkingHandler.setMouseClickEvent(clickParkingEvent);
            VBox box;
            if (i % 3 == 0) box = box1;
            else if (i % 3 == 1) box = box2;
            else box = box3;
            box.getChildren().add(parkingHandler.getContent());
        }
    }

    @Override
    public void initEvent() {
        super.initEvent();
        searchField.setOnKeyTyped(this::onSearch);
        viewRentingBikeBtn.setOnMouseClicked(this::viewRentingBike);
        returnBikeBtn.setOnMouseClicked(this::returnBike);
    }

    public void onSearch(KeyEvent event) {
        //todo Chức năng này chưa phát triển
        String keyword = searchField.getText();
        System.out.println(keyword);
    }

    private void viewRentingBike(MouseEvent mouseEvent) {
        System.out.println("View renting bike");
        try {
            ViewRentingBikeScreenHandler viewRentingBikeScreen = new ViewRentingBikeScreenHandler(Configs.VIEW_RENTING_BIKE_SCREEN_PATH, stage, new ViewRentingBikeController());
//            viewRentingBikeScreen.setController();
            viewRentingBikeScreen.setPreviousScreen(this);
            viewRentingBikeScreen.setHomeScreen(this);
            viewRentingBikeScreen.show();
        } catch (BikeRentingNotFoundException e) {
//            throw new RuntimeException(e);
            //todo in ra thông báo không có xe đang thuê
            Popup.popup("BikeRenting Not Found!", Popup.PopupType.ERROR).show();
        }
    }

    private void returnBike(MouseEvent mouseEvent) {
        SelectDockScreenHandler selectDockScreen = new SelectDockScreenHandler(Configs.SELECT_DOCK_SCREEN_PATH, stage);
        selectDockScreen.setController(new ReturnBikeController());
        try {
            selectDockScreen.setBikeRenting(new ViewRentingBikeController().getBikeRenting());
            selectDockScreen.setHomeScreen(this);
            selectDockScreen.setPreviousScreen(this);
            selectDockScreen.show();
        } catch (BikeRentingNotFoundException e) {
            Popup.popup("BikeRenting Not Found!", Popup.PopupType.ERROR).show();
        }
    }

    public void showParkingInfo(Parking parking) {
        System.out.println(parking);
        ParkingInfoScreenHandler parkingInfo = new ParkingInfoScreenHandler(Configs.PARKING_INFO_SCREEN_PATH, this.stage, parking);
        parkingInfo.setHomeScreen(this);
        parkingInfo.setPreviousScreen(this);
        parkingInfo.setController(new ViewParkingController());
        parkingInfo.show();
    }
}

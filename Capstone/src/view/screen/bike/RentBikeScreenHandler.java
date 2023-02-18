package view.screen.bike;

import controller.BaseController;
import controller.RentBikeController;
import entity.bike.Bike;
import exception.BikeNotFoundException;
import exception.BikeStatusIsNotFreeException;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.screen.BaseScreenHandler;
import exception.BarCodeInvalidException;
import view.screen.popup.Popup;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 10/02/2023
 * @Time: 17:40
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class RentBikeScreenHandler extends BaseScreenHandler {
    private final String barcode;
    private final Bike bike;
    @FXML
    private ButtonBar paymentBtn;
    @FXML
    private Label name;
    @FXML
    private Label type;
    @FXML
    private Label licensePlate;
    @FXML
    private Label barcode1;
    @FXML
    private Label barcode2;
    @FXML
    private Label deposit;

    public RentBikeScreenHandler(String path, Stage stage, String barcode, BaseController controller) throws BarCodeInvalidException, BikeStatusIsNotFreeException {
        super(path, stage);
        this.barcode = barcode;
        this.setController(controller);
        try {
            this.bike = getController().getBike(barcode);
        } catch (BikeNotFoundException e) {
            throw new BarCodeInvalidException();
        }
    }

    @Override
    public RentBikeController getController() {
        return (RentBikeController) super.getController();
    }

    @Override
    public void initProp() {
        super.initProp();
        name.setText(bike.getName());
        type.setText(bike.getType());
        licensePlate.setText(bike.getLicensePlate());
        barcode1.setText(getController().getBarCode(bike.getId()));
        barcode2.setText(getController().getBarCode(bike.getId()));
        deposit.setText(bike.getDepositPrice() + " VND");
    }

    @Override
    public void initEvent() {
        super.initEvent();
        //Chuyển sang usecase thanh toán
        paymentBtn.setOnMouseClicked(e -> {
            //todo Chuyển sang usecase thanh toán
            //Sau khi thanh toán thành công thì cập nhật lại db
            getController().rentBike(bike);
            Popup popup = Popup.popup("Rent bike success", Popup.PopupType.SUCCESS);
            popup.setOnOK(e1 -> {
                this.getHomeScreen().show();
            });
            popup.show();
            //Trở lại màn hình chính sau khi thuê thành công
        });
    }
}
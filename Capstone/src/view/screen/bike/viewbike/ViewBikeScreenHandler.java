package view.screen.bike.viewbike;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.screen.BaseScreenHandler;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 09/02/2023
 * @Time: 00:14
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ViewBikeScreenHandler extends BaseScreenHandler {
    private Bike bike;
    @FXML
    private Label name;
    @FXML
    private Label type;
    @FXML
    private Label deposit;
    @FXML
    private Label licensePlate;
    @FXML
    private Label barcode1;
    @FXML
    private Label barcode2;

    public ViewBikeScreenHandler(String path, Stage stage, Bike bike) {
        super(path, stage);
        this.bike = bike;
    }

    public void setBarcode(String barcode) {
        barcode1.setText(barcode);
        barcode2.setText(barcode);
    }

    @Override
    public void initProp() {
        super.initProp();
        name.setText(bike.getName());
        type.setText(bike.getType());
        licensePlate.setText(bike.getLicensePlate());
        deposit.setText(bike.getDepositPrice()+" VND");
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }
}

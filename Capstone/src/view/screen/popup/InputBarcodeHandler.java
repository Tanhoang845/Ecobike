package view.screen.popup;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.screen.BaseScreenHandler;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 09/02/2023
 * @Time: 01:21
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class InputBarcodeHandler extends BaseScreenHandler {
    private EventHandler<MouseEvent> onOK;
    private EventHandler<MouseEvent> onCancel;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button okeBtn;
    @FXML
    private TextField result;

    public InputBarcodeHandler(String path) {
        super(path);
    }

    public String getResult() {
        return result.getText();
    }

    public EventHandler<MouseEvent> getOnOK() {
        return onOK;
    }

    public void setOnOK(EventHandler<MouseEvent> onOK) {
        this.onOK = onOK;
    }

    public EventHandler<MouseEvent> getOnCancel() {
        return onCancel;
    }

    public void setOnCancel(EventHandler<MouseEvent> onCancel) {
        this.onCancel = onCancel;
    }

    @Override
    public void initEvent() {
        super.initEvent();
        okeBtn.setOnMouseClicked(e -> {
            if (onOK != null) onOK.handle(e);
            this.stage.close();
        });
        cancelBtn.setOnMouseClicked(e -> {
            if (onCancel != null) onCancel.handle(e);
            this.stage.close();
        });
    }
}

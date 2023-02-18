package view.screen.popup;

import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import utils.Configs;
import view.screen.BaseScreenHandler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 07/02/2023
 * @Time: 11:30
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class Popup extends BaseScreenHandler {
    private EventHandler<MouseEvent> onOK;
    private EventHandler<MouseEvent> onCancel;
    @FXML
    private Label message;
    @FXML
    private Button okeBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private ImageView icon;

    private boolean showOK;
    private boolean showCancel;
    private boolean autoClose;
    private float closeDelay;
    private Image image;

    private PopupType popupType;


    public Popup(String path, Stage stage) {
        super(path, stage);
        this.stage.initStyle(StageStyle.UNIFIED);
        this.stage.initModality(Modality.APPLICATION_MODAL);
    }

    public Popup(String message, boolean showOK, boolean showCancel, boolean autoClose, PopupType popupType) {
        this(Configs.CONFIRM_POPUP_PATH, new Stage());
        this.message.setText(message);
        this.showOK = showOK;
        this.showCancel = showCancel;
        this.autoClose = autoClose;
        this.popupType = popupType;
        if (autoClose) closeDelay = 1f;
    }

    public static Popup popup(String message, PopupType type) {
        Popup popup;
        switch (type) {
            case WARNING -> popup = new Popup(message, true, false, false, PopupType.WARNING);
            case SUCCESS -> popup = new Popup(message, false, false, true, PopupType.SUCCESS);
            case ERROR -> popup = new Popup(message, false, false, true, PopupType.ERROR);
            default -> popup = new Popup(message, true, true, false, PopupType.INFO);
        }
        return popup;
    }


    public void setOnOK(EventHandler<MouseEvent> onOK) {
        this.onOK = onOK;
        this.okeBtn.setOnMouseClicked(this.onOK);
    }

    public void setOnCancel(EventHandler<MouseEvent> onCancel) {
        this.onCancel = onCancel;
    }

    public void close() {
        PauseTransition delay = new PauseTransition(Duration.seconds(this.closeDelay));
        delay.setOnFinished(e -> {
            if (onOK != null) onOK.handle(null);
            this.stage.close();
        });
        delay.play();
    }

    public void renderIcon() {
        if (image == null) {
            String iconPath = "";
            switch (popupType) {
                case SUCCESS -> iconPath = Configs.SUCCESS_ICON_PATH;
                case WARNING -> iconPath = Configs.WARNING_ICON_PATH;
                case ERROR -> iconPath = Configs.ERROR_ICON_PATH;
                case INFO -> iconPath = Configs.INFO_ICON_PATH;
            }
            File file = new File(iconPath);
            image = new Image(file.toURI().toString());
        }
        icon.setImage(image);
    }

    @Override
    public void initProp() {
        super.initProp();
        renderIcon();
    }

    @Override
    public void initEvent() {
        super.initEvent();
        this.cancelBtn.setOnMouseClicked(e -> {
            if (onCancel != null) onCancel.handle(e);
            this.stage.close();
        });
        this.okeBtn.setOnMouseClicked(e -> {
            if (onOK != null) onOK.handle(e);
            this.stage.close();
        });

        this.stage.setOnCloseRequest(windowEvent -> {
            if (onCancel != null) onCancel.handle(null);
        });
        if (!(showOK && showCancel)) {
            (showOK ? okeBtn : cancelBtn).setLayoutX(200);
        }
        okeBtn.setVisible(showOK);
        cancelBtn.setVisible(showCancel);
        if (this.autoClose) this.close();
    }

    public enum PopupType {
        WARNING,
        INFO,
        ERROR,
        SUCCESS
    }
}

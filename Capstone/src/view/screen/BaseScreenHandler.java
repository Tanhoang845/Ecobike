package view.screen;

import controller.BaseController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 01:47
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class BaseScreenHandler extends FXMLScreenHandler {
    private Scene scene;
    protected final Stage stage;
    protected BaseScreenHandler prev;
    private BaseScreenHandler homeScreen;
    private BaseController controller;
    @FXML
    private ImageView home;
    @FXML
    private Pane forward;

    public BaseScreenHandler(String path) {
        super(path);
        this.stage = new Stage();
    }

    public BaseScreenHandler(String path, Stage stage) {
        super(path);
        this.stage = stage;
    }

    public BaseScreenHandler getPreviousScreen() {
        return prev;
    }

    public void setPreviousScreen(BaseScreenHandler prev) {
        this.prev = prev;
    }

    public BaseScreenHandler getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(BaseScreenHandler homeScreen) {
        this.homeScreen = homeScreen;
    }

    public BaseController getController() {
        return controller;
    }

    public void setController(BaseController controller) {
        this.controller = controller;
    }

    public void setTitle(String title) {
        this.stage.setTitle(title);
    }

    public void show() {
        initProp();
        initEvent();
        this.stage.show();
    }

    /**
     * Khởi tạo các thuộc tính của fxml
     */
    public void initProp() {
        this.scene = this.scene == null ? new Scene(this.getContent()) : this.scene;
        this.stage.setScene(this.scene);
    }

    public void initEvent() {
        if (forward != null)
            forward.setOnMouseClicked(this::forward);
        if (home != null)
            home.setOnMouseClicked(this::backHome);
    }

    private void backHome(MouseEvent mouseEvent) {
        this.getHomeScreen().show();
    }

    private void forward(MouseEvent mouseEvent) {
        this.getPreviousScreen().show();
    }
}

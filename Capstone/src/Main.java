import controller.BaseController;
import controller.HomeController;
import factory.SQLBDFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Configs;
import view.screen.home.HomeScreenHandler;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @Project: capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 14:46
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        BaseController.setDbFactory(new SQLBDFactory());
        HomeScreenHandler homeScreen = new HomeScreenHandler(Configs.HOME_SCREEN_PATH, stage);
        homeScreen.setController(new HomeController());
        homeScreen.show();
    }
}

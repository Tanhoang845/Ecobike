package view.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 06/02/2023
 * @Time: 02:10
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class FXMLScreenHandler {
    private final FXMLLoader loader;
    private AnchorPane content;


    public FXMLScreenHandler(String path) {
        this.loader = new FXMLLoader(this.getClass().getResource(path));
        this.loader.setController(this);
        try {
            this.content = this.loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public FXMLLoader getLoader() {
        return loader;
    }

    public AnchorPane getContent() {
        return content;
    }
}

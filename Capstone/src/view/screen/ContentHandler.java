package view.screen;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 09/02/2023
 * @Time: 00:02
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ContentHandler extends FXMLScreenHandler {
    protected EventHandler<MouseEvent> mouseClickEvent;

    public ContentHandler(String path) {
        super(path);
        this.getContent().setOnMouseClicked(e -> {
            if (mouseClickEvent != null) mouseClickEvent.handle(e);
        });
    }

    public EventHandler<MouseEvent> getMouseClickEvent() {
        return mouseClickEvent;
    }

    public void setMouseClickEvent(EventHandler<MouseEvent> mouseClickEvent) {
        this.mouseClickEvent = mouseClickEvent;
    }
}

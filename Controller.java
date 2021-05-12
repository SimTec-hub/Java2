package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {
    public TextArea chatArea;
    public ListView onlineUsers;
    public TextField inputField;
    public Button btnSendMessage;
    private Window primaryStage;

    public void mockAction(ActionEvent actionEvent) {
        System.out.println("MOCK!");
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }



    public void showHelp(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://docs.google.com/document/d/1wr0YEtIc5yZtKFu-KITqYnBtp8KC28v2FEYUANL0YAM/edit?usp=sharing"));
    }



    public void showAbout(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("  "));
    }

    public void sendMessage(ActionEvent actionEvent) {
        appendTextFromTF();
    }




    private void appendTextFromTF() {
        String msg = inputField.getText();
        if (msg.isEmpty()) return;
        chatArea.appendText("ME: " + msg + System.lineSeparator());
//        chatArea.set
        inputField.clear();
    }

    public void chatAction(ActionEvent actionEvent) {
        new ChatServer().start();
    }
}

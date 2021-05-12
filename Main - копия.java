package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ЧАТ");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public void start2(Stage primaryStage) throws Exception{
        //FXMLLoader loader = new FXMLLoader(StartGraphicsHere.class.getResource("sample2.fxml"));
        //AnchorPane page = (AnchorPane) loader.load();
        //Stage dialogStage = new Stage();
        //dialogStage.setTitle("Edit Profile");
        //dialogStage.initModality(Modality.WINDOW_MODAL);
        //dialogStage.initOwner(primaryStage);
        //Scene scene = new Scene(page);
        //dialogStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class StartGraphicsHere {

    }
}

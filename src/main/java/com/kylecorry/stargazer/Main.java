package com.kylecorry.stargazer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Kylec on 5/8/2017.
 */
public class Main extends Application {

    public static void main(String args[]) {
        try {
            OpenCVManager.getInstance().load(new SystemProperties());
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/homepage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setTitle("Stargazer");
        scene.getStylesheets().add("/styles/styles.css");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
        primaryStage.show();
    }
}


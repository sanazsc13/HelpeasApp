package app.helpeas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpeasApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(getClass().getResource("/app/View/helpeas-view.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(HelpeasApp.class.getResource("/app/View/helpeas-view.fxml"));
        System.out.println("FXMLLoader: " + fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        scene.getStylesheets().add(getClass().getResource("/app/styles.css").toExternalForm());
        stage.setTitle("HelpeasApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
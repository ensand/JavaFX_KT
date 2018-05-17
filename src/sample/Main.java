package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import static sample.Controller.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Goodbye World");
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        //primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        String key = event.getCode().toString();
                        switch (key) {
                            case "ENTER":
                                clear();
                                System.out.println("Deleting all.");
                                break;
                            case "RIGHT":
                                bigH();
                                bigW();
                                System.out.println("Making things bigger.");
                                break;
                            case "LEFT":
                                smallH();
                                smallW();
                                System.out.println("Making things smaller.");
                                break;
                        }
                    }
                }
        );
    }


    public static void main(String[] args) {
        launch(args);
    }
}

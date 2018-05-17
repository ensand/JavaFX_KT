package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import java.util.concurrent.ThreadLocalRandom;


public class Controller {

    @FXML
    Canvas canvas = new Canvas();

    @FXML
    ComboBox combo = new ComboBox();
    private ObservableList<String> colours = FXCollections.observableArrayList("Blue", "Red", "Black");

    @FXML
    CheckBox check = new CheckBox();

    static private GraphicsContext gc;
    static private String colour = "Blue";
    static private int w = 15, h = 15;
    static int x, y;


    public static void clear(){
        gc.clearRect(0,10, 500, 450);
    }

    public static int bigH(){
        return h = h + h;
    }
    public static int bigW(){
        return w = w + w;
    }

    public static int smallH(){
        h = h - 30;
        if (h <= 0){
            h = 10;
        }
        return h;
    }
    public static int smallW(){
        w = w - 30;
        if (w <= 0){
            w = 10;
        }
        return w;
    }



    public void drawShape(){
        x = ThreadLocalRandom.current().nextInt(10, 490 + 1);
        y = ThreadLocalRandom.current().nextInt(10, 490 + 1);

        colour = combo.getValue().toString();

        if (check.isSelected()){
            if (colour.equals("Blue")){
                gc.setFill(Color.LIGHTBLUE);
            } else if (colour.equals("Red")){
                gc.setFill(Color.RED);
            } else if (colour.equals("Black")){
                gc.setFill(Color.BLACK);
            }
        } else {
            gc.setFill(Color.WHITE);
        }

            gc.setStroke(Color.BLACK);
            gc.setLineWidth(3);
            gc.strokeOval(x, y, w, h);
            gc.fillOval(x, y, w, h);
    }


    public void initialize(){
        System.out.println("I am ready to fulfill your wishes, my master.");
        gc = canvas.getGraphicsContext2D();
        combo.setItems(colours);
        combo.setValue(colour);
    }

}

package sample;

import com.sun.xml.internal.messaging.saaj.util.SAAJUtil;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Mantvydas on 2016.10.17.
 */
public class MygtukuIvestisFloat {


    public static void ivestiesLangas(String s, String saugykla){
        Database db = new Database();

        //DIsplejus
        Stage window = new Stage();
        Label label1 = new Label(s);
        TextField textField = new TextField();
        textField.setPromptText("Iveskite skaiciu");
        Button button = new Button("Patvirtinti");
        button.setOnAction(event -> {
             boolean tikrinti = arFloat(textField.getText());
            if (tikrinti){
                saveToDb(textField, saugykla);
                window.close();
            }
            else {
                System.out.println("Čia ne skaičius");
            }
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, textField, button);
        Scene scene = new Scene(layout, 300,150);
        window.setScene(scene);
        window.showAndWait();
    }

    private static void saveToDb(TextField textField, String saugykla) {
        if ("alus".equals(saugykla)) {
            KiekiuSaugykla.alausKiekis = Double.parseDouble(textField.getText());
            System.out.println(KiekiuSaugykla.alausKiekis);
        }
        if ("viskis".equals(saugykla)) {
            KiekiuSaugykla.viskioKiekis = Double.parseDouble(textField.getText());

            System.out.println(KiekiuSaugykla.viskioKiekis);
        }

        if ("brendis".equals(saugykla)) {
            KiekiuSaugykla.brendzioKiekis = Float.parseFloat(textField.getText());
            System.out.println(KiekiuSaugykla.brendzioKiekis);
        }
        else return;
    }

    public static boolean arFloat (String message){

        try{
            double litrai = Double.parseDouble(message);
            return true;
        }catch (NumberFormatException e){
         return false;
        }
    }
}

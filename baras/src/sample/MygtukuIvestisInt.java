package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Mantvydas on 2016.10.17.
 */
public class MygtukuIvestisInt {

    public static void ivestiesLangas(String s, String saugykla){

        Database db = new Database();
        //DIsplejus
        Stage window = new Stage();
        Label label1 = new Label(s);
        TextField textField = new TextField();
        textField.setPromptText("Iveskite skaiciu");
        Button button = new Button("Patvirtinti");
        button.setOnAction(event -> {
             boolean tikrinti = arInt(textField.getText());
            if (tikrinti){
                saveToDb(textField, saugykla);
                db.updateAlus(KiekiuSaugykla.alausKiekis);
                db.updateViskis(KiekiuSaugykla.viskioKiekis);
                db.updateBrendis(KiekiuSaugykla.brendzioKiekis);
                db.updateCigaretes(KiekiuSaugykla.cigareciuKiekis);
                db.updateZetonus(KiekiuSaugykla.zetonuKiekis);
                db.updateKava(KiekiuSaugykla.kavoKiekis);
                window.close();
            }
            else {
                System.out.println("Čia ne skaičius, arba ne sveikasis skaičius");
            }
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, textField, button);
        Scene scene = new Scene(layout, 300,150);
        window.setScene(scene);
        window.showAndWait();
    }
    private static void saveToDb(TextField textField, String saugykla) {
        if ("cigaretes".equals(saugykla)) {
            KiekiuSaugykla.cigareciuKiekis = Integer.parseInt(textField.getText());
            System.out.println(KiekiuSaugykla.cigareciuKiekis);
        }
        if ("kava".equals(saugykla)) {
            KiekiuSaugykla.kavoKiekis = Integer.parseInt(textField.getText());
            System.out.println(KiekiuSaugykla.kavoKiekis);
        }

        if ("zetonai".equals(saugykla)) {
            KiekiuSaugykla.zetonuKiekis = Integer.parseInt(textField.getText());
            System.out.println(KiekiuSaugykla.zetonuKiekis);
        }

        else return;
    }
    public static boolean arInt (String message){

        try{
            Integer litrai = Integer.parseInt(message);
            return true;
        }catch (NumberFormatException e){
         return false;

        }
    }




}

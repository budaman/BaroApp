package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mantvydas on 2016.10.17.
 */
public class KiekiuSaugykla {

    //gauti kiekiai is ivesties
    static double alausKiekis;
    static double viskioKiekis;
    static double brendzioKiekis;
    static int cigareciuKiekis;
    static int kavoKiekis;
    static int zetonuKiekis;

    //kiekiai, kuomet buvo kazkas nuskanuota

    public static void turimosAtsargos() {
        Stage window = new Stage();
        window.setTitle("Turimos Atsargos");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setVgap(15);
        gridPane.setHgap(5);

        //suapvalinam double
        viskioKiekis = round(viskioKiekis, 3);
        alausKiekis = round(alausKiekis,3);
        brendzioKiekis = round(brendzioKiekis,3);

        //atsargu atvaizdavimas
        Label pavadinimas = new Label("Prekė");
        GridPane.setConstraints(pavadinimas,0,0);
        Label kiekis = new Label("Kiekis");
        GridPane.setConstraints(kiekis,1,0);
        Label alus = new Label("Alaus kiekis:");
        GridPane.setConstraints(alus,0,3);
        Label alusK = new Label(" " + alausKiekis + " l");
        GridPane.setConstraints(alusK,1,3);
        Label viskis = new Label("Viskio kiekis:");
        GridPane.setConstraints(viskis,0,4);
        Label viskisK = new Label(" " + viskioKiekis + " l");
        GridPane.setConstraints(viskisK,1,4);
        Label brendis = new Label("Brendžio kiekis:");
        GridPane.setConstraints(brendis,0,5);
        Label brendisK = new Label(" " + brendzioKiekis + " l");
        GridPane.setConstraints(brendisK,1,5);
        Label cigaretes = new Label("Cigareciu pakeliu kiekis:");
        GridPane.setConstraints(cigaretes,0,6);
        Label cigaretesK = new Label(" " + cigareciuKiekis + " pakeliu");
        GridPane.setConstraints(cigaretesK,1,6);
        Label kava = new Label("Kavos kiekis:");
        GridPane.setConstraints(kava,0,7);
        Label kavaK = new Label(" " + kavoKiekis + " pakeliu");
        GridPane.setConstraints(kavaK,1,7);
        Label zetonas = new Label("Zetonu kiekis:");
        GridPane.setConstraints(zetonas,0,8);
        Label zetonasK = new Label(" " + zetonuKiekis + " vienetai");
        GridPane.setConstraints(zetonasK,1,8);

        Button iseiti = new Button("Išeiti");
        iseiti.setOnAction(event -> window.close());
        GridPane.setConstraints(iseiti, 0, 10);

        gridPane.getChildren().addAll(pavadinimas,kiekis,alus,alusK,viskis,viskisK,brendis,brendisK,cigaretes,cigaretesK,kava,kavaK,
                zetonas,zetonasK,iseiti);
        Scene scene = new Scene(gridPane, 250, 300);
        window.setScene(scene);
        window.showAndWait();
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

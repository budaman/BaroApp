package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Mantvydas on 2016.10.17.
 */
public class SandelisScene {
    public static void display (){

        Stage window = new Stage();
        window.setTitle("TopSportBaras");

        //apsirasau grid panelio duomenis
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setVgap(15);
        gridPane.setHgap(5);

        Label label = new Label("SANDELYS");
        GridPane.setConstraints(label,0,0);

        Label label2 = new Label("Papildymas");
        GridPane.setConstraints(label2,0,2);

        //Button section
        Button alus = new Button("Alus        ");
        GridPane.setConstraints(alus,0,3);
        alus.setOnAction(event -> MygtukuIvestisFloat.ivestiesLangas("Įveskite alaus kiekį litrais", "alus"));

        Button viskis = new Button("Viskis ");
        GridPane.setConstraints(viskis,1,3);
        viskis.setOnAction(event -> MygtukuIvestisFloat.ivestiesLangas("Įveskite viskio kiekį litrais", "viskis"));

        Button brendis = new Button("Brendis");
        GridPane.setConstraints(brendis,2,3);
        brendis.setOnAction(event -> MygtukuIvestisFloat.ivestiesLangas("Įveskite brendžio kiekį litrais", "brendis"));

        Button cigaretes = new Button("Cigaretes");
        GridPane.setConstraints(cigaretes,0,4);
        cigaretes.setOnAction(event -> MygtukuIvestisInt.ivestiesLangas("Įveskite kiek pakelių cigarečių", "cigaretes"));

        Button kava = new Button("Kava  ");
        GridPane.setConstraints(kava,1,4);
        kava.setOnAction(event -> MygtukuIvestisInt.ivestiesLangas("Įveskite, kiek kavos yra likę", "kava"));

        Button zetonai = new Button("Zetonai");
        GridPane.setConstraints(zetonai,2,4);
        zetonai.setOnAction(event -> MygtukuIvestisInt.ivestiesLangas("Įveskite, zetonu kieki", "zetonai"));

        Button grizti = new Button("Baigti");
        grizti.getStyleClass().add("raudonas");

        GridPane.setConstraints(grizti,0,8);
        grizti.setOnAction(event -> window.close());
        gridPane.getChildren().addAll(label,label2,alus,viskis,brendis,cigaretes,kava,zetonai,grizti);
        Scene scene = new Scene(gridPane,300, 400);
        scene.getStylesheets().add("sample/Style.css");
        window.setScene(scene);
        window.showAndWait();
    }

}

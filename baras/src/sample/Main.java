package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean tikrinti;

        //importuojam reiksmes
      Database db = new Database();
        db.selecViskis();
        db.selecAlus();
        db.selecBrendis();
        db.selecCigaretes();
        db.selecKava();
        db.selecZetonus();

        Stage window = primaryStage;
        window.setTitle("Pradzios langas");
        Button ivesti = new Button("Įrašyti į sandėlį");
        ivesti.setOnAction(e -> SandelisScene.display());
        ivesti.getStyleClass().add("raudonas");

        //KiekiusAugykla, kaupiasi atsargos
        Button turimosAtsargos = new Button("Salndelio Atsargos");
        turimosAtsargos.setOnAction(event -> KiekiuSaugykla.turimosAtsargos());
        //iskvieciamas sandelio langas

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(15);
        gridPane.setHgap(5);


        //Button section
        Label nuskanuoti = new Label("NUSKANUOTI: ");
        GridPane.setConstraints(nuskanuoti, 0, 2);
        Button alus = new Button("Alus 0.5                ");
        GridPane.setConstraints(alus, 0, 3);
        alus.setOnAction(event -> {
            if (nuskaiciuojamBool("Alaus nuskanavimas", "Ar tikrai norite nurasyti 0.5l alaus?")) {
                KiekiuSaugykla.alausKiekis = KiekiuSaugykla.alausKiekis - 0.5f;
                db.updateAlus(KiekiuSaugykla.alausKiekis);
                System.out.println((KiekiuSaugykla.alausKiekis));
            }

        });


        Button viskis = new Button("Viskis 40ml");
        GridPane.setConstraints(viskis, 1, 3);
        viskis.setOnAction(event -> {
            if (nuskaiciuojamBool("Viskio nuskanavimas", "Ar tikrai norite nurasyti 40ml viskio?")) {
                KiekiuSaugykla.viskioKiekis = KiekiuSaugykla.viskioKiekis - 0.04;
                db.updateViskis(KiekiuSaugykla.viskioKiekis);
                System.out.println(KiekiuSaugykla.viskioKiekis);
            }
        });
        Button brendis = new Button("Brendis 40ml");
        brendis.setOnAction(event -> {
            if (nuskaiciuojamBool("Brendzio nuskanavimas", "Ar tikrai norite nurasyti 40ml brendzio?")) {
                KiekiuSaugykla.brendzioKiekis = KiekiuSaugykla.brendzioKiekis - 0.04;
                db.updateBrendis(KiekiuSaugykla.brendzioKiekis);
                System.out.println(KiekiuSaugykla.brendzioKiekis);
            }
        });
        GridPane.setConstraints(brendis, 2, 3);
        Button cigaretes = new Button("Cigaretes 1 pak.   ");
        cigaretes.setOnAction(event -> {
            if (nuskaiciuojamBool("Cigareciu nuskanavimas", "Ar tikrai norite nurasyti 1 pakeli cigareciu?")) {
                KiekiuSaugykla.cigareciuKiekis = KiekiuSaugykla.cigareciuKiekis - 1;
                db.updateCigaretes(KiekiuSaugykla.cigareciuKiekis);
                System.out.println(KiekiuSaugykla.cigareciuKiekis);
            }
        });
        GridPane.setConstraints(cigaretes, 0, 4);
        Button kava = new Button("Kava 1vnt. ");
        kava.setOnAction(event -> {
            if (nuskaiciuojamBool("Kavos nuskanavimas", "Ar tikrai norite nurasyti 1 pakeli kavos?")) {
                KiekiuSaugykla.kavoKiekis = KiekiuSaugykla.kavoKiekis - 1;
                db.updateKava(KiekiuSaugykla.kavoKiekis);
                System.out.println(KiekiuSaugykla.kavoKiekis);
            }
        });
        GridPane.setConstraints(kava, 1, 4);
        Button zetonai = new Button("Zetonas 1vnt.");
        zetonai.setOnAction(event -> {
            if (nuskaiciuojamBool("Zetonu nuskanavimas", "Ar tikrai norite nurasyti 1 zetona?")) {
                KiekiuSaugykla.zetonuKiekis = KiekiuSaugykla.zetonuKiekis - 1;
                db.updateZetonus(KiekiuSaugykla.zetonuKiekis);
                System.out.println(KiekiuSaugykla.zetonuKiekis);
            }
        });
        GridPane.setConstraints(zetonai, 2, 4);
        GridPane.setConstraints(ivesti, 0, 7);

        gridPane.getChildren().addAll(nuskanuoti, alus, viskis, brendis, cigaretes, kava, zetonai, ivesti);
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(turimosAtsargos);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 450, 500);
        scene.getStylesheets().add("sample/Style.css");
        window.setScene(scene);
        window.show();


    }

    public static boolean answer;

    public static boolean nuskaiciuojamBool(String title, String message) {


        Stage windowAlert = new Stage();
        windowAlert.setTitle(title);
        windowAlert.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label(message);
        Button buttonYes = new Button("Taip");
        Button buttonNo = new Button("Ne");
        HBox horizontalus = new HBox();
        horizontalus.getChildren().addAll(label, buttonYes, buttonNo);
        horizontalus.setPadding(new Insets(15,10,10,10));
        horizontalus.setSpacing(15);
        Scene scene1 = new Scene(horizontalus,350,50);
        windowAlert.setScene(scene1);



        buttonYes.setOnAction(event -> {
            answer = true;
            windowAlert.close();
        });
        buttonNo.setOnAction(event -> {
            answer = false;
            windowAlert.close();
        });


        windowAlert.showAndWait();
        return answer;

    }
}
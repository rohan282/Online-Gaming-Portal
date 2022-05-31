
package com.example.crewmgmt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       /* Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Crew Management");//setting title
        primaryStage.setScene(new Scene(root, 800, 600));//setting size
        primaryStage.show();*/
        Hero hero = new Hero("apple","a",1,1,1);
        ArrayList<Hero> list = new ArrayList<>();
        list.add(hero);
        new ArmyPane(list);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
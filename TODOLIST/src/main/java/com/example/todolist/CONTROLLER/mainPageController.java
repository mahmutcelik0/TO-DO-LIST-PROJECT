package com.example.todolist.CONTROLLER;

import com.example.todolist.MODEL.Motivation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class mainPageController  implements Initializable {

    @FXML
    private Label personLabel;

    @FXML
    private Label sentenceLabel;

    @FXML
    private Pane paneForFXML;


    private Motivation motivation = new Motivation();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        motivation.setPane(new Random().nextInt(motivation.lengthOfMap()));
        personLabel.textProperty().bind(motivation.personProperty());
        sentenceLabel.textProperty().bind(motivation.sentenceProperty());
    }

    @FXML
    private void buttonClicked(MouseEvent event){
        Button clickedButton = (Button) event.getSource();

        if(clickedButton.getId().equals("remainingPart")){
            paneFxmlLoader(clickedButton.getId());

        }else if(clickedButton.getId().equals("refreshButton")){


        }else if(clickedButton.getId().equals("setTask")){
            paneFxmlLoader(clickedButton.getId());

        }else {
            System.err.println("ERROR IN BUTTONCLICKED");
            System.exit(0);
        }


    }

    private void paneFxmlLoader(String fxmlIdToLoad){
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/example/todolist/VIEW/"+fxmlIdToLoad+".fxml"));
            AnchorPane pane = fxml.load();
            paneForFXML.getChildren().addAll(pane);

        }catch (IOException e){
            System.err.println("PANE FXML LOADER EXCEPTION");
            e.printStackTrace();
        }


    }

}
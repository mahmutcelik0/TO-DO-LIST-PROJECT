package com.example.todolist.CONTROLLER;

import com.example.todolist.DTO.DatabaseConnection;
import com.example.todolist.MODEL.Task;
import com.example.todolist.VERIFICATION.InputVerification;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class RemainingPartController implements Initializable {


    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Task,Integer> taskID;
    @FXML
    private TableColumn<Task,String> task,addTime,deadline;
    @FXML
    private Label warningMessage;

    @FXML
    private DatePicker inputAddTime,inputDeadline;
    @FXML
    private TextField inputTask,inputTaskID;


    private DatabaseConnection databaseConnection = new DatabaseConnection();

    private InputVerification inputVerification = new InputVerification();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Task> listFromDatabase = databaseConnection.getDataFromTable();

        taskID.setCellValueFactory(new PropertyValueFactory<>("taskIDs"));
        task.setCellValueFactory(new PropertyValueFactory<>("taskForTable"));
        addTime.setCellValueFactory(new PropertyValueFactory<>("addTimeField"));
        deadline.setCellValueFactory(new PropertyValueFactory<>("deadLineField"));

        tableView.getItems().addAll(listFromDatabase); //to use these part we have to add module info -> exports com.example.todolist.MODEL;

        warningMessage.textProperty().bind(inputVerification.warningMessageBindedTextProperty());
    }


    @FXML
    private void addOrDeleteClicked(ActionEvent m){
        try {
            boolean resultOfVerification = inputVerification.taskProcessChecker(inputTaskID.getText(),inputTask.getText(),inputAddTime.getValue().toString(),inputDeadline.getValue().toString());
            //COMPLETE INPUT VERIFICATION
            if(!resultOfVerification) return;

            boolean resultOfDatabaseVerification = databaseConnection.taskDefinedChecker(inputTaskID.getText(),inputTask.getText(),inputAddTime.getValue().toString(),inputDeadline.getValue().toString());

            if(!resultOfDatabaseVerification) return;

            databaseConnection.addNewTask(inputTaskID.getText(),inputTask.getText(),inputAddTime.getValue().toString(),inputDeadline.getValue().toString());


        }catch (NullPointerException e){
            inputVerification.setWarningMessageBindedText("FILL DATE FIELDS");
            return;
        }

    }
}

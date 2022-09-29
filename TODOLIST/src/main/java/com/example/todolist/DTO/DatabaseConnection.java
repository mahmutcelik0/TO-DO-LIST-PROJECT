package com.example.todolist.DTO;

import com.example.todolist.MODEL.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Driver;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private final String URL = "jdbc:mysql://localhost:3306/todolist";
    private final String USERNAME = "MAHMUT";
    private final String PASSWORD = "M.celik2001";


    public DatabaseConnection(){
        try {
            Class.forName("java.sql.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            System.out.println("CONNECTED");
        }catch (SQLException e){
            System.err.println("DATABASE CONNECTION EXCEPTION");
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.err.println("DRIVER EXCEPTION");
            e.printStackTrace();
        }
    }

    public ObservableList<Task> getDataFromTable(){
        String queryToSend = "SELECT * FROM task";

        ObservableList<Task> tasksFromDatabase = FXCollections.observableArrayList();

        try {
            preparedStatement = connection.prepareStatement(queryToSend);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                boolean remaningValue = resultSet.getString(5).equals("TRUE");
                tasksFromDatabase.add(new Task(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),remaningValue));
            }

        }catch (SQLException e){
            System.err.println("GET DATA FROM TABLE EXCEPTION");
            e.printStackTrace();
        }

        return tasksFromDatabase;
    }






}

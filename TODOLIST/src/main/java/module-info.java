module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.todolist.START;
    opens com.example.todolist.START to javafx.fxml;
    exports com.example.todolist.CONTROLLER;
    opens com.example.todolist.CONTROLLER to javafx.fxml;



    exports com.example.todolist.MODEL;
    exports com.example.todolist.DTO;

}
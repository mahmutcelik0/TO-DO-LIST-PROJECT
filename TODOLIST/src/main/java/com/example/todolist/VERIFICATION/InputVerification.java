package com.example.todolist.VERIFICATION;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;

public class InputVerification {

    private SimpleStringProperty warningMessageBindedText = new SimpleStringProperty(" ");


    public boolean taskProcessChecker(String taskID,String task,String addTime, String deadline){
        if(taskID.trim().isEmpty() || task.trim().isEmpty() || addTime.trim().isEmpty() || deadline.trim().isEmpty()) {
            warningMessageBindedText.setValue("FILL ALL BLANKS");
            return false;
        }


        return true;

    }

    public String getWarningMessageBindedText() {
        return warningMessageBindedText.get();
    }

    public SimpleStringProperty warningMessageBindedTextProperty() {
        return warningMessageBindedText;
    }

    public void setWarningMessageBindedText(String warningMessageBindedText) {
        this.warningMessageBindedText.set(warningMessageBindedText);
    }
}

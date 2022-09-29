package com.example.todolist.MODEL;

public class Task {
    private Integer taskIDs;
    private String taskForTable;
    private String addTimeField;
    private String deadLineField;
    private boolean inRemaining;

    public Task(Integer taskID, String taskForTable, String addTime, String deadLine, boolean inRemaining) {
        this.taskIDs = taskID;
        this.taskForTable = taskForTable;
        this.addTimeField = addTime;
        this.deadLineField = deadLine;
        this.inRemaining = inRemaining;
    }


    public Integer getTaskIDs() {
        return taskIDs;
    }

    public String getTaskForTable() {
        return taskForTable;
    }

    public String getAddTimeField() {
        return addTimeField;
    }

    public String getDeadLineField() {
        return deadLineField;
    }

    public boolean isInRemaining() {
        return inRemaining;
    }
}

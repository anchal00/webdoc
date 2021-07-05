package com.example.webdoc.model;

public class Status {

    private String taskName;
    private Integer timeElapsed;
    private boolean isUp;

    public Status() {
    }

    public Status(String taskName, Integer timeElapsed, boolean isUp) {
        this.taskName = taskName;
        this.timeElapsed = timeElapsed;
        this.isUp = isUp;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Integer timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean isUp) {
        this.isUp = isUp;
    }

}

package com.example.webdoc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Task {

    private String taskName;
    private String website;
    private Integer frequency;

    @JsonIgnore
    Status status;

    public Task() {
    }

    public Task(String taskName, String website, Integer frequency, Status status) {
        this.taskName = taskName;
        this.website = website;
        this.frequency = frequency;
        this.status = status;
    }

    public Task(String taskName, String website, Integer frequency) {
        this.taskName = taskName;
        this.website = website;
        this.frequency = frequency;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

}
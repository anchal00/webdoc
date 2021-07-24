package com.example.webdoc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Task {

    @NotBlank(message = "task name cannot be empty")
    private String taskName;

    @NotBlank(message = "website cannot be empty")
    private String website;

    private Integer frequency;

    @NotNull
    private Boolean inHours;

    public Boolean getInHours() {
        return inHours;
    }

    public void setInHours(Boolean inHours) {
        this.inHours = inHours;
    }

    @JsonIgnore
    private Status status;

    public Task(@NotBlank(message = "task name cannot be empty") String taskName,
            @NotBlank(message = "website cannot be empty") String website, @NotNull Integer frequency,
            @NotNull Boolean inHours, Status status) {
        this.taskName = taskName;
        this.website = website;
        this.frequency = frequency;
        this.inHours = inHours;
        this.status = status;
    }

    public Task() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
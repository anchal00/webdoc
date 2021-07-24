package com.example.webdoc.service;

import com.example.webdoc.model.Summary;
import com.example.webdoc.model.Task;

public interface TaskService {

    boolean createTaskForUser(Task task);

    Summary getTaskSummary(String taskName);
}

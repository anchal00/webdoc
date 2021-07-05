package com.example.webdoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.webdoc.model.Status;
import com.example.webdoc.model.Task;
import com.example.webdoc.util.ScheduledTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    Map<Task, Status> taskStore = new HashMap<>();

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Override
    public boolean createTaskForUser(Task task) {
        Status status = new Status();
        status.setTaskName(task.getTaskName());
        status.setUp(false);
        status.setTimeElapsed(1);

        task.setStatus(status);
        taskStore.put(task, status);

        int frequency = task.getFrequency();

        scheduler.scheduleWithFixedDelay(new ScheduledTask(task), frequency);
        return true;
    }

    @Override
    public String getStatusForTask(String taskName) {
        // TODO Auto-generated method stub
        return null;
    }

}

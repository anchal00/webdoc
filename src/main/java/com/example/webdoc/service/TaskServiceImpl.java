package com.example.webdoc.service;

import java.util.HashMap;
import java.util.Map;

import com.example.webdoc.model.Status;
import com.example.webdoc.model.Summary;
import com.example.webdoc.model.Task;
import com.example.webdoc.scheduler.ScheduledTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private Map<Task, Status> taskStore = new HashMap<>();

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Override
    public boolean createTaskForUser(Task task) {
        updateTask(task);

        Integer frequency = task.getFrequency();

        int frequencyInMillisec = getFreqInMilliSeconds(frequency, task.getInHours());

        scheduler.scheduleWithFixedDelay(new ScheduledTask(task), frequencyInMillisec);

        return true;
    }

    private void updateTask(Task task) {
        Status status = new Status();

        status.setTaskName(task.getTaskName());
        status.setUp(false);
        status.setTimeElapsed(0);

        task.setStatus(status);

        taskStore.put(task, status);
    }

    private int getFreqInMilliSeconds(Integer frequency, Boolean isInHours) {

        if (isInHours) {
            return frequency * 60 * 60 * 1000;
        }
        return frequency * 60 * 1000;
    }

    @Override
    public Summary getTaskSummary(String taskName) {
        Task task = null;
        for (Map.Entry<Task, Status> entry : taskStore.entrySet()) {
            if (entry.getKey().getTaskName().equals(taskName)) {
                task = entry.getKey();
            }
        }

        if (task == null) {
            return null;

        }
        Summary preparedSummaryForTask = prepareSummary(task);
        return preparedSummaryForTask;
    }

    private Summary prepareSummary(Task task) {
        String taskSummary = "Task ," + task.getTaskName() + " for website " + task.getWebsite();

        if (task.getStatus().isUp()) {
            taskSummary += " has been Up for ";
        } else {
            taskSummary += " has been Down for ";
        }
        int timeElapsed = task.getStatus().getTimeElapsed();

        taskSummary += (timeElapsed) + "";

        if (task.getInHours()) {
            taskSummary += " hour(s)";
        } else {
            taskSummary += " minute(s)";
        }
        return new Summary(taskSummary);
    }

}

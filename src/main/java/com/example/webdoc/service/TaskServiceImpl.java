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

    private Map<Task, Status> taskStore = new HashMap<>();

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @Override
    public boolean createTaskForUser(Task task) {
        Status status = new Status();

        status.setTaskName(task.getTaskName());
        status.setUp(false);
        status.setTimeElapsed(0);

        task.setStatus(status);

        taskStore.put(task, status);

        Integer frequency = task.getFrequency();

        int frequencyInMillisec = getFreqInMilliSeconds(frequency, task.getInHours());
        scheduler.scheduleWithFixedDelay(new ScheduledTask(task), frequencyInMillisec);

        return true;
    }

    private int getFreqInMilliSeconds(Integer frequency, Boolean isInHours) {

        if (isInHours) {
            return frequency * 60 * 60 * 1000;
        }
        return frequency * 60 * 1000;
    }

    @Override
    public String getStatusForTask(String taskName) {
        Task task = null;
        for (Map.Entry<Task, Status> entry : taskStore.entrySet()) {
            if (entry.getKey().getTaskName().equals(taskName)) {
                task = entry.getKey();
            }
        }
        String statSummary = "Task , " + taskName + " for website " + task.getWebsite() + "\n " + "Status ==== ";

        if (task.getStatus().isUp()) {
            statSummary += "Has been Up for ";
        } else {
            statSummary += "Has been Down for ";
        }
        int timeElapsed = task.getStatus().getTimeElapsed();

        statSummary += (timeElapsed) + "";

        if (task.getInHours()) {
            statSummary += " hours";
        } else {
            statSummary += " minutes";
        }
        return statSummary;
    }

}

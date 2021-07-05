package com.example.webdoc.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.webdoc.model.Status;
import com.example.webdoc.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{


    @Autowired
    private ThreadPoolTaskScheduler scheduler;
    
    @Override
    public boolean createTaskForUser(Task task) {
        return false;
    }

    @Override
    public String getStatusForTask(String taskName) {
        // TODO Auto-generated method stub
        return null;
    }

}

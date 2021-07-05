package com.example.webdoc.controller;

import java.util.Map;
import com.example.webdoc.model.Task;
import com.example.webdoc.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/user/{userId}")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        taskService.createTaskForUser(task);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<String> getTaskInfo(@RequestParam("taskName") String taskName){
        
        String p = taskService.getStatusForTask(taskName);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}

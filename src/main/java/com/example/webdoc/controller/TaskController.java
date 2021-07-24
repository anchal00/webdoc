package com.example.webdoc.controller;

import java.util.Map;

import javax.validation.Valid;

import com.example.webdoc.model.Summary;
import com.example.webdoc.model.Task;
import com.example.webdoc.service.TaskService;
import com.example.webdoc.service.TaskServiceImpl;

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
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        taskService.createTaskForUser(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<Summary> getTaskInfo(@RequestParam("taskName") String taskName){
        
        Summary taskSummary = taskService.getTaskSummary(taskName);
        if (taskSummary == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskSummary, HttpStatus.OK);
    }
}

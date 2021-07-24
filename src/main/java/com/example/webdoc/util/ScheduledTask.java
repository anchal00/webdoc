package com.example.webdoc.util;

import java.net.http.HttpClient;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

import com.example.webdoc.model.Task;

public class ScheduledTask implements Runnable {

    private Task task;

    public ScheduledTask(Task task ){
        this.task = task;

    }

    @Override
    public void run() {
       
        boolean isUp = isWebsiteUp();        
        System.out.println("task "+ task.getTaskName() +" ran at - "+ LocalDateTime.now());

        if (task.getStatus().isUp() == isUp) {
            int i = task.getStatus().getTimeElapsed();

            i+= (task.getFrequency());

            task.getStatus().setTimeElapsed(i);
        } else {
            task.getStatus().setUp(isUp);
            task.getStatus().setTimeElapsed(1);
        }
    }


    private boolean isWebsiteUp(){
        int p = (int)(Math.random() * 100);
        System.out.println("Random ==== "+ p);
        return (p % 2 == 0)?true: false;
    }
    
}

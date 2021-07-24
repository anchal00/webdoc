package com.example.webdoc.scheduler;

import com.example.webdoc.model.Task;
import com.example.webdoc.pingUtils.WebsiteAvailabilityChecker;

public class ScheduledTask implements Runnable {

    private Task task;

    public ScheduledTask(Task task) {
        this.task = task;

    }

    @Override
    public void run() {

        boolean isUp = WebsiteAvailabilityChecker.isWebsiteUp(task.getWebsite());
        /**
         * Checks if the website's task's status is same as before or not
         * 
         * If yes , then time elapsed is increased (For down time or UpTime)
         * 
         * else ,
         * if status has changed now , the time elapsed is reset to 0
         */
        if (task.getStatus().isUp() == isUp) {

            updateTimeElapsedForTask();

        } else {
            task.getStatus().setUp(isUp);
            task.getStatus().setTimeElapsed(0);
        }
    }

    private void updateTimeElapsedForTask() {
        int timeElapsedTillNow = task.getStatus().getTimeElapsed();

        timeElapsedTillNow += (task.getFrequency());

        task.getStatus().setTimeElapsed(timeElapsedTillNow);
    }

}

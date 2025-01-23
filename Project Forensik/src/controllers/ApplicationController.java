package controllers;

import models.ActivityLog;

public class ApplicationController {
    private ActivityLog activityLog;

    public ApplicationController() {
        activityLog = new ActivityLog();
    }

    public void logActivity(String message) {
        activityLog.addLog(message);
    }

    public ActivityLog getActivityLog() {
        return activityLog;
    }
}
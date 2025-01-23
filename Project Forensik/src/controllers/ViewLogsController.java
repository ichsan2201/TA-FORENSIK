package controllers;

import models.ActivityLog;
import views.ViewLogsView;

public class ViewLogsController {
    private ViewLogsView view;
    private ActivityLog activityLog;

    public ViewLogsController(ViewLogsView view, ActivityLog activityLog) {
        this.view = view;
        this.activityLog = activityLog;

        this.view.addBackButtonListener(e -> view.dispose());
        displayLogs();
    }

    private void displayLogs() {
        view.displayLogs(activityLog.getLogs());
    }
}
package controllers;

import models.CaseManager;
import models.ActivityLog;
import views.ReportsAndStatsView;

public class ReportsAndStatsController {
    public ReportsAndStatsController(ReportsAndStatsView view, ActivityLog activityLog, CaseManager caseManager) {
        String caseStats = caseManager.getStatisticsByType().toString();
        String activityLogs = String.join("\n", activityLog.getLogs());

        view.displayReportAndStats("Case Statistics", caseStats);
        view.displayReportAndStats("Activity Logs", activityLogs);
    }
}
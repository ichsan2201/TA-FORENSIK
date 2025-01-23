package controllers;

import javax.swing.JOptionPane;
import models.ActivityLog;
import models.CaseManager;
import models.UserManager;
import views.AdminView;
import views.ManageUsersView;
import views.ReportsAndStatsView;
import views.ViewLogsView;

public class AdminController {

    private AdminView view;
    private UserManager userManager;
    private ActivityLog activityLog;
    private CaseManager caseManager;

    public AdminController(AdminView view, UserManager userManager, ActivityLog activityLog, CaseManager caseManager) {
        this.view = view;
        this.userManager = userManager;
        this.activityLog = activityLog;
        this.caseManager = caseManager;

        this.view.addManageUsersListener(e -> openManageUsers());
        this.view.addViewLogsListener(e -> openViewLogs());
        this.view.addViewReportsAndStatsListener(e -> openReportsAndStatistics());
        this.view.addBackupDataListener(e -> backupData());
        this.view.addLogoutListener(e -> logout());
    }

    public AdminView getView() {
        return view;
    }

    private void openManageUsers() {
        ManageUsersView manageUsersView = new ManageUsersView();
        new ManageUsersController(manageUsersView, userManager);
        activityLog.addLog("Admin accessed Manage Users");
        manageUsersView.setVisible(true);
    }

    private void openViewLogs() {
        ViewLogsView viewLogsView = new ViewLogsView();
        new ViewLogsController(viewLogsView, activityLog);
        activityLog.addLog("Admin accessed Activity Logs");
        viewLogsView.setVisible(true);
    }

    private void openReportsAndStatistics() {
        ReportsAndStatsView reportsView = new ReportsAndStatsView(); // Buat tampilan
        new ReportsAndStatsController(reportsView, activityLog, caseManager); // Controller untuk laporan
        activityLog.addLog("Admin accessed Reports and Statistics");
        reportsView.setVisible(true);
    }

    private void backupData() {
        try {
            caseManager.backupCases("backup_cases.txt");
            activityLog.backupLogs("backup_logs.txt");
            JOptionPane.showMessageDialog(view, "Data backup completed successfully!");
            activityLog.addLog("Admin performed data backup");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error during data backup: " + e.getMessage());
        }
    }

    private void logout() {
        activityLog.addLog("Admin logged out");
        view.dispose();
    }
}
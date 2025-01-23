package controllers;

import javax.swing.JOptionPane;
import models.ActivityLog;
import models.CaseManager;
import views.AssignInvestigatorView;
import views.CreateCaseView;
import views.KepalaPenyidikView;
import views.SearchCaseView;
import views.StatisticsView;
import views.ValidateReportView;

public class KepalaPenyidikController {

    private KepalaPenyidikView view;
    private ActivityLog activityLog;
    private CaseManager caseManager;

    public KepalaPenyidikController(KepalaPenyidikView view, ActivityLog activityLog, CaseManager caseManager) {
        this.view = view;
        this.activityLog = activityLog;
        this.caseManager = caseManager;

        this.view.addCreateCaseListener(e -> createNewCase());
        this.view.addAssignInvestigatorListener(e -> assignInvestigator());
        // this.view.addUpdateCaseStatusListener(e -> updateCaseStatus());
        this.view.addValidateReportListener(e -> validateReport());
        this.view.addViewStatisticsListener(e -> viewStatistics());
        this.view.addSearchCaseListener(e -> searchCase());
        this.view.addLogoutListener(e -> logout());
    }

    public KepalaPenyidikView getView() {
        return view;
    }

    private void createNewCase() {
        activityLog.addLog("Kepala Penyidik accessed Create New Case");
        CreateCaseView createCaseView = new CreateCaseView();
        new CreateCaseController(createCaseView, caseManager, activityLog);
        createCaseView.setVisible(true);
    }

    private void assignInvestigator() {
        activityLog.addLog("Kepala Penyidik accessed Assign Investigator");
        AssignInvestigatorView assignInvestigatorView = new AssignInvestigatorView(caseManager);
        new AssignInvestigatorController(assignInvestigatorView, caseManager, activityLog);
        assignInvestigatorView.setVisible(true);
    }

    // private void updateCaseStatus() {
    //     activityLog.addLog("Kepala Penyidik accessed Update Case Status");
    //     // Logic for updating case status
    // }

    private void validateReport() {
        String caseNumber = JOptionPane.showInputDialog(view, "Enter Case Number to validate:");
        if (caseNumber == null || caseNumber.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Case Number is required.");
            return;
        }

        String reportContent = caseManager.getCaseReport(caseNumber);
        ValidateReportView validateView = new ValidateReportView(reportContent);
        new ValidateReportController(validateView, caseManager, caseNumber);
        validateView.setVisible(true);
    }

    private void viewStatistics() {
        StatisticsView statisticsView = new StatisticsView();
        new StatisticsController(statisticsView, caseManager);
        statisticsView.setVisible(true);
    }

    private void searchCase() {
        SearchCaseView searchView = new SearchCaseView();
        new SearchCaseController(searchView, caseManager);
        searchView.setVisible(true);
    }

    private void logout() {
        activityLog.addLog("Kepala Penyidik logged out");
        view.dispose();
    }
}
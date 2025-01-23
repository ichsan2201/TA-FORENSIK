package controllers;

import javax.swing.JOptionPane;
import models.Case;
import models.CaseManager;
import views.CaseHistoryView;
import views.CreateCaseDetailsView;
import views.InvestigatorMenuView;
import views.SearchAssignedCasesView;
import views.UpdateCaseStatusView;

public class InvestigatorController {

    private InvestigatorMenuView view;
    private CaseManager caseManager;
    private String investigatorName;

    public InvestigatorController(InvestigatorMenuView view, CaseManager caseManager, String investigatorName) {
        this.view = view;
        this.caseManager = caseManager;
        this.investigatorName = investigatorName;

        view.addSearchAssignedCasesListener(e -> openSearchAssignedCases());
        view.addManageCaseDetailsListener(e -> openManageCaseDetails());
        view.addUpdateCaseListener(e -> openUpdateCase());
        view.addViewCaseHistoryListener(e -> openCaseHistory());
        view.addLogoutListener(e -> logout());
    }

    public InvestigatorMenuView getView() {
        return view;
    }

    private void openSearchAssignedCases() {
        SearchAssignedCasesView searchView = new SearchAssignedCasesView();
        new SearchAssignedCasesController(searchView, caseManager, investigatorName);
        searchView.setVisible(true);
    }

    private void openManageCaseDetails() {
        // Pastikan investigator hanya dapat melihat dan mengelola kasus yang ditugaskan
        String[] assignedCases = caseManager.getCases().stream()
                .filter(c -> investigatorName.equals(c.getAssignedInvestigator()))
                .map(c -> c.getCaseNumber())
                .toArray(String[]::new);

        if (assignedCases.length == 0) {
            JOptionPane.showMessageDialog(view, "No assigned cases available for management.");
            return;
        }

        String selectedCase = (String) JOptionPane.showInputDialog(
                view,
                "Select a case to manage details:",
                "Manage Case Details",
                JOptionPane.QUESTION_MESSAGE,
                null,
                assignedCases,
                assignedCases[0]
        );

        if (selectedCase != null) {
            CreateCaseDetailsView detailsView = new CreateCaseDetailsView();
            new CreateCaseDetailsController(detailsView, caseManager, selectedCase);
            detailsView.setVisible(true);
        }
    }

    private void openUpdateCase() {
        String[] assignedCases = caseManager.getCases().stream()
                .filter(c -> investigatorName.equals(c.getAssignedInvestigator()))
                .map(Case::getCaseNumber)
                .toArray(String[]::new);

        if (assignedCases.length == 0) {
            JOptionPane.showMessageDialog(view, "No assigned cases available for updating.");
            return;
        }

        UpdateCaseStatusView updateView = new UpdateCaseStatusView(assignedCases);
        new UpdateCaseStatusController(updateView, caseManager, investigatorName);
        updateView.setVisible(true);
    }

    private void openCaseHistory() {
        String investigatorName = this.investigatorName;
        Object[][] caseData = caseManager.getClosedCasesByInvestigator(investigatorName);

        if (caseData.length == 0) {
            JOptionPane.showMessageDialog(view, "No closed cases found.");
            return;
        }

        CaseHistoryView historyView = new CaseHistoryView(caseData, new String[]{"Case Number", "Crime Type", "Location", "Date", "Status"});
        new CaseHistoryController(historyView, caseManager, investigatorName);
    }

    private void logout() {
        view.dispose();
        // Logic to return to login view
    }
}
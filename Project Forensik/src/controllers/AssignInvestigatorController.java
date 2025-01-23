package controllers;

import models.ActivityLog;
import models.CaseManager;
import views.AssignInvestigatorView;

import javax.swing.*;

public class AssignInvestigatorController {
    private AssignInvestigatorView view;
    private CaseManager caseManager;
    private ActivityLog activityLog;

    public AssignInvestigatorController(AssignInvestigatorView view, CaseManager caseManager, ActivityLog activityLog) {
        this.view = view;
        this.caseManager = caseManager;
        this.activityLog = activityLog;

        this.view.addAssignButtonListener(e -> assignInvestigator());
        this.view.addBackButtonListener(e -> backToMenu());
    }

    private void assignInvestigator() {
        String selectedCase = view.getSelectedCase();
        String selectedInvestigator = view.getSelectedInvestigator();

        if (selectedCase == null || selectedInvestigator == null) {
            JOptionPane.showMessageDialog(view, "Please select both a case and an investigator.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        caseManager.assignInvestigatorToCase(selectedCase, selectedInvestigator);
        activityLog.addLog("Investigator " + selectedInvestigator + " assigned to case " + selectedCase);
        JOptionPane.showMessageDialog(view, "Investigator assigned successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void backToMenu() {
        view.dispose();
    }
}
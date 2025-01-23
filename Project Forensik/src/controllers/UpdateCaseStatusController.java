package controllers;

import models.CaseManager;
import views.UpdateCaseStatusView;

import javax.swing.*;

public class UpdateCaseStatusController {
    private UpdateCaseStatusView view;
    private CaseManager caseManager;
    private String investigatorName;

    public UpdateCaseStatusController(UpdateCaseStatusView view, CaseManager caseManager, String investigatorName) {
        this.view = view;
        this.caseManager = caseManager;
        this.investigatorName = investigatorName;

        view.addUpdateListener(e -> updateCaseStatus());
        view.addBackListener(e -> view.dispose());
    }

    private void updateCaseStatus() {
        String caseNumber = view.getSelectedCase();
        String newStatus = view.getSelectedStatus();

        boolean success = caseManager.updateCaseStatus(caseNumber, investigatorName, newStatus);

        if (success) {
            JOptionPane.showMessageDialog(view, "Case status updated successfully!");
        } else {
            JOptionPane.showMessageDialog(view, "Failed to update status. Ensure you have access to the selected case.");
        }
    }
}
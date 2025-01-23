package controllers;

import models.CaseManager;
import views.ValidateReportView;

import javax.swing.*;

public class ValidateReportController {
    private ValidateReportView view;
    private CaseManager caseManager;
    private String caseNumber;

    public ValidateReportController(ValidateReportView view, CaseManager caseManager, String caseNumber) {
        this.view = view;
        this.caseManager = caseManager;
        this.caseNumber = caseNumber;

        view.addApproveListener(e -> approveReport());
        view.addRejectListener(e -> rejectReport());
        view.addBackListener(e -> view.dispose());
    }

    private void approveReport() {
        int confirmation = JOptionPane.showConfirmDialog(view, "Approve this report and close the case?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            caseManager.updateCaseStatus(caseNumber, "CLOSED");
            JOptionPane.showMessageDialog(view, "Case status updated to CLOSED.");
            view.dispose();
        }
    }

    private void rejectReport() {
        JOptionPane.showMessageDialog(view, "Report rejected. The case will remain open.");
        view.dispose();
    }
}
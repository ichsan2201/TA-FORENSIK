package controllers;

import javax.swing.JOptionPane;
import models.CaseManager;
import views.CreateCaseDetailsView;

public class CreateCaseDetailsController {
    private CreateCaseDetailsView view;
    private CaseManager caseManager;
    private String caseNumber;

    public CreateCaseDetailsController(CreateCaseDetailsView view, CaseManager caseManager, String caseNumber) {
        this.view = view;
        this.caseManager = caseManager;
        this.caseNumber = caseNumber;

        view.addSaveButtonListener(e -> saveDetails());
        view.addBackButtonListener(e -> back());
    }

    private void saveDetails() {
        String suspectInfo = view.getSuspectInfo();
        String witnessInfo = view.getWitnessInfo();
        String findings = view.getFindings();
        String report = view.getReport();

        caseManager.saveCaseDetails(caseNumber, suspectInfo, witnessInfo, findings, report);
        JOptionPane.showMessageDialog(view, "Details saved successfully!");
        view.clearFields();
    }

    private void back() {
        view.dispose();
    }
}
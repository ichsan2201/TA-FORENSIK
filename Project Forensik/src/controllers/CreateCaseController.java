package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import models.ActivityLog;
import models.Case;
import models.CaseManager;
import views.CreateCaseView;

public class CreateCaseController {
    private CreateCaseView view;
    private CaseManager caseManager;
    private ActivityLog activityLog;

    public CreateCaseController(CreateCaseView view, CaseManager caseManager, ActivityLog activityLog) {
        this.view = view;
        this.caseManager = caseManager;
        this.activityLog = activityLog;

        this.view.addCreateButtonListener(e -> createCase());
        this.view.addBackButtonListener(e -> view.dispose());
    }

    private void createCase() {
        String caseNumber = view.getCaseNumber();
        String crimeType = view.getCrimeType();
        String location = view.getCrimeLocation();
        String dateString = view.getDate();
        String status = view.getStatus();

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String dateStringFormatted = new SimpleDateFormat("yyyy-MM-dd").format(date);
            Case newCase = new Case(caseNumber, crimeType, location, dateStringFormatted, status);
            caseManager.addCase(newCase);
            activityLog.addLog("Kepala Penyidik created new case: " + caseNumber);
            JOptionPane.showMessageDialog(view, "Case created successfully!");
            view.dispose();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(view, "Invalid date format. Please use yyyy-MM-dd.");
        }
    }
}
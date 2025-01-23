package controllers;

import models.CaseManager;
import views.CaseHistoryView;

public class CaseHistoryController {
    private CaseHistoryView view;

    public CaseHistoryController(CaseHistoryView view, CaseManager caseManager, String investigatorName) {
        this.view = view;

        Object[][] caseData = caseManager.getClosedCasesByInvestigator(investigatorName);
        String[] columnNames = {"Case Number", "Crime Type", "Location", "Date", "Status"};

        CaseHistoryView historyView = new CaseHistoryView(caseData, columnNames);
        historyView.addBackListener(e -> historyView.dispose());
        historyView.setVisible(true);
    }
}
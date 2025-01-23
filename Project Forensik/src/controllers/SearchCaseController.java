package controllers;

import models.Case;
import models.CaseManager;
import views.SearchCaseView;

import java.awt.event.ActionEvent;
import java.util.List;

public class SearchCaseController {
    private SearchCaseView view;
    private CaseManager caseManager;

    public SearchCaseController(SearchCaseView view, CaseManager caseManager) {
        this.view = view;
        this.caseManager = caseManager;

        // Event Listener untuk tombol Search
        view.getSearchButton().addActionListener(this::handleSearch);

        // Event Listener untuk tombol Back
        view.getBackButton().addActionListener(e -> view.dispose());
    }

    private void handleSearch(ActionEvent e) {
        String caseNumber = view.getCaseNumberField().getText().trim();
        String date = view.getDateField().getText().trim();
        String crimeType = view.getCrimeTypeField().getText().trim();

        List<Case> results = caseManager.searchCases(caseNumber, date, crimeType);

        if (results.isEmpty()) {
            view.getResultArea().setText("No cases found for the given filters.");
        } else {
            StringBuilder resultText = new StringBuilder();
            for (Case c : results) {
                resultText.append(String.format(
                        "Case Number: %s\nCrime Type: %s\nLocation: %s\nDate: %s\nStatus: %s\nInvestigator: %s\n\n",
                        c.getCaseNumber(),
                        c.getCrimeType(),
                        c.getCrimeLocation(),
                        c.getDate(),
                        c.getStatus(),
                        c.getAssignedInvestigator() == null ? "Unassigned" : c.getAssignedInvestigator()
                ));
            }
            view.getResultArea().setText(resultText.toString());
        }
    }
}
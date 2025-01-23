package controllers;

import models.Case;
import models.CaseManager;
import views.SearchAssignedCasesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class SearchAssignedCasesController {
    private SearchAssignedCasesView view;
    private CaseManager caseManager;
    private String investigatorName;

    public SearchAssignedCasesController(SearchAssignedCasesView view, CaseManager caseManager, String investigatorName) {
        this.view = view;
        this.caseManager = caseManager;
        this.investigatorName = investigatorName;

        loadAssignedCases();

        view.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose(); // Close the current window
            }
        });
    }

    private void loadAssignedCases() {
        List<Case> assignedCases = caseManager.getCases().stream()
                .filter(c -> investigatorName.equals(c.getAssignedInvestigator()))
                .collect(Collectors.toList());

        String[][] data = new String[assignedCases.size()][5];
        for (int i = 0; i < assignedCases.size(); i++) {
            Case c = assignedCases.get(i);
            data[i][0] = c.getCaseNumber();
            data[i][1] = c.getCrimeType();
            data[i][2] = c.getCrimeLocation();
            data[i][3] = c.getDate();
            data[i][4] = c.getStatus();
        }

        String[] columnNames = {"Nomor Kasus", "Jenis Kejahatan", "Lokasi", "Tanggal", "Status"};
        view.setTableData(data, columnNames);
    }
}
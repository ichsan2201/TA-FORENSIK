package controllers;

import java.awt.event.ActionEvent;
import java.util.Map;
import models.CaseManager;
import views.StatisticsView;

public class StatisticsController {
    private StatisticsView view;
    private CaseManager caseManager;

    public StatisticsController(StatisticsView view, CaseManager caseManager) {
        this.view = view;
        this.caseManager = caseManager;

        // Combine all statistics into a single string
        String statistics = generateStatistics();
        view.displayStatistics("Case Statistics", statistics);

        view.getBackButton().addActionListener((ActionEvent e) -> view.dispose());
    }

    private String generateStatistics() {
        StringBuilder sb = new StringBuilder();

        // Add statistics by crime type
        sb.append("Statistics by Crime Type:\n");
        Map<String, Integer> byType = caseManager.getStatisticsByType();
        for (Map.Entry<String, Integer> entry : byType.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("\n");

        // Add statistics by location
        sb.append("Statistics by Location:\n");
        Map<String, Integer> byLocation = caseManager.getStatisticsByLocation();
        for (Map.Entry<String, Integer> entry : byLocation.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }
}
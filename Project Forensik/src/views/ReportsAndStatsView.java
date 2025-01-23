package views;

import java.awt.*;
import javax.swing.*;

public class ReportsAndStatsView extends JFrame {
    private JTextArea reportArea;

    public ReportsAndStatsView() {
        setTitle("Reports and Statistics");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);
    }

    public void displayReportAndStats(String title, String content) {
        reportArea.append("=== " + title + " ===\n");
        reportArea.append(content + "\n\n");
    }
}
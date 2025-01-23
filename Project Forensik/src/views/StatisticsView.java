package views;

import java.awt.*;
import javax.swing.*;

public class StatisticsView extends JFrame {
    private JTextArea statisticsArea;
    private JButton backButton;

    public StatisticsView() {
        setTitle("Case Statistics");
        setSize(400, 400);
        setLayout(new BorderLayout());

        statisticsArea = new JTextArea();
        statisticsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statisticsArea);

        backButton = new JButton("Back");

        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Perbarui metode ini untuk menerima String langsung
    public void displayStatistics(String title, String statistics) {
        setTitle(title);
        statisticsArea.setText(statistics);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
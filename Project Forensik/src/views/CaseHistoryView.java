package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CaseHistoryView extends JFrame {
    private JTable historyTable;
    private JButton backButton;

    public CaseHistoryView(Object[][] caseData, String[] columnNames) {
        setTitle("Case History");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        historyTable = new JTable(caseData, columnNames);
        JScrollPane scrollPane = new JScrollPane(historyTable);

        backButton = new JButton("Back");

        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
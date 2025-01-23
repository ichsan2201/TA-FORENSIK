package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ValidateReportView extends JFrame {
    private JTextArea reportArea;
    private JButton approveButton, rejectButton, backButton;

    public ValidateReportView(String reportContent) {
        setTitle("Validate Case Report");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        reportArea = new JTextArea(reportContent);
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);

        approveButton = new JButton("Approve");
        rejectButton = new JButton("Reject");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addApproveListener(ActionListener listener) {
        approveButton.addActionListener(listener);
    }

    public void addRejectListener(ActionListener listener) {
        rejectButton.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
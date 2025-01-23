package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateCaseDetailsView extends JFrame {
    private JTextField suspectField, witnessField;
    private JTextArea findingsArea, reportArea;
    private JButton saveButton, backButton;

    public CreateCaseDetailsView() {
        setTitle("Manage Case Details");
        setSize(600, 500);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Informasi tersangka:"));
        suspectField = new JTextField();
        inputPanel.add(suspectField);

        inputPanel.add(new JLabel("Informasi saksi:"));
        witnessField = new JTextField();
        inputPanel.add(witnessField);

        inputPanel.add(new JLabel("Temuan:"));
        findingsArea = new JTextArea(5, 20);
        inputPanel.add(new JScrollPane(findingsArea));

        inputPanel.add(new JLabel("Report:"));
        reportArea = new JTextArea(5, 20);
        inputPanel.add(new JScrollPane(reportArea));

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save Details");
        backButton = new JButton("Back");
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public String getSuspectInfo() {
        return suspectField.getText();
    }

    public String getWitnessInfo() {
        return witnessField.getText();
    }

    public String getFindings() {
        return findingsArea.getText();
    }

    public String getReport() {
        return reportArea.getText();
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void clearFields() {
        suspectField.setText("");
        witnessField.setText("");
        findingsArea.setText("");
        reportArea.setText("");
    }
}
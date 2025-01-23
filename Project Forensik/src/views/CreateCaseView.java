package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreateCaseView extends JFrame {
    private JTextField caseNumberField;
    private JTextField crimeTypeField;
    private JTextField locationField;
    private JTextField dateField;
    private JComboBox<String> statusComboBox;
    private JButton createButton;
    private JButton backButton;

    public CreateCaseView() {
        setTitle("Create New Case");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        caseNumberField = new JTextField();
        crimeTypeField = new JTextField();
        locationField = new JTextField();
        dateField = new JTextField("yyyy-MM-dd");

        String[] statuses = {"OPEN", "IN PROGRESS", "CLOSED"};
        statusComboBox = new JComboBox<>(statuses);

        createButton = new JButton("Create Case");
        backButton = new JButton("Back");

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Case Number:"));
        add(caseNumberField);
        add(new JLabel("Crime Type:"));
        add(crimeTypeField);
        add(new JLabel("Location:"));
        add(locationField);
        add(new JLabel("Date (yyyy-MM-dd):"));
        add(dateField);
        add(new JLabel("Status:"));
        add(statusComboBox);
        add(createButton);
        add(backButton);
    }

    public String getCaseNumber() {
        return caseNumberField.getText();
    }

    public String getCrimeType() {
        return crimeTypeField.getText();
    }

    public String getCrimeLocation() {
        return locationField.getText();
    }

    public String getDate() {
        return dateField.getText();
    }

    public String getStatus() {
        return (String) statusComboBox.getSelectedItem();
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
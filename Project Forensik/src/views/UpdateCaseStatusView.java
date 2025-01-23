package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateCaseStatusView extends JFrame {
    private JComboBox<String> caseDropdown;
    private JComboBox<String> statusDropdown;
    private JButton updateButton;
    private JButton backButton;

    public UpdateCaseStatusView(String[] assignedCases) {
        setTitle("Update Case Status");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        caseDropdown = new JComboBox<>(assignedCases);
        statusDropdown = new JComboBox<>(new String[]{"OPEN", "IP", "CLOSED"});

        updateButton = new JButton("Update Status");
        backButton = new JButton("Back");

        add(new JLabel("Select Case:"));
        add(caseDropdown);
        add(new JLabel("Select Status:"));
        add(statusDropdown);
        add(updateButton);
        add(backButton);
    }

    public String getSelectedCase() {
        return (String) caseDropdown.getSelectedItem();
    }

    public String getSelectedStatus() {
        return (String) statusDropdown.getSelectedItem();
    }

    public void addUpdateListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
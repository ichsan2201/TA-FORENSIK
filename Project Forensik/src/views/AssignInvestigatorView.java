package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import models.CaseManager;

public class AssignInvestigatorView extends JFrame {
    private JComboBox<String> caseDropdown;
    private JComboBox<String> investigatorDropdown;
    private JButton assignButton;
    private JButton backButton;

    public AssignInvestigatorView(CaseManager caseManager) {
        setTitle("Assign Investigator to Case");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        caseDropdown = new JComboBox<>(caseManager.getCaseNumbers());
        investigatorDropdown = new JComboBox<>(caseManager.getInvestigators());

        panel.add(new JLabel("Select Case:"));
        panel.add(caseDropdown);
        panel.add(new JLabel("Select Investigator:"));
        panel.add(investigatorDropdown);

        assignButton = new JButton("Assign");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(assignButton);
        buttonPanel.add(backButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getSelectedCase() {
        return (String) caseDropdown.getSelectedItem();
    }

    public String getSelectedInvestigator() {
        return (String) investigatorDropdown.getSelectedItem();
    }

    public void addAssignButtonListener(ActionListener listener) {
        assignButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
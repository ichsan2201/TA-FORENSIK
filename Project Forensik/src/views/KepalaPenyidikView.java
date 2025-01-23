package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KepalaPenyidikView extends JFrame {
    private JButton createCaseButton;
    private JButton assignInvestigatorButton;
    // private JButton updateCaseStatusButton;
    private JButton validateReportButton;
    private JButton viewStatisticsButton;
    private JButton searchCaseButton;
    private JButton logoutButton;

    public KepalaPenyidikView() {
        setTitle("Kepala Penyidik Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createCaseButton = new JButton("Create New Case");
        assignInvestigatorButton = new JButton("Assign Investigator");
        // updateCaseStatusButton = new JButton("Update Case Status");
        validateReportButton = new JButton("Validate Case Report");
        viewStatisticsButton = new JButton("View Statistics");
        searchCaseButton = new JButton("Search Case");
        logoutButton = new JButton("Logout");

        setLayout(new GridLayout(7, 1));
        add(createCaseButton);
        add(assignInvestigatorButton);
        // add(updateCaseStatusButton);
        add(validateReportButton);
        add(viewStatisticsButton);
        add(searchCaseButton);
        add(logoutButton);
    }

    public void addCreateCaseListener(ActionListener listener) {
        createCaseButton.addActionListener(listener);
    }

    public void addAssignInvestigatorListener(ActionListener listener) {
        assignInvestigatorButton.addActionListener(listener);
    }

    // public void addUpdateCaseStatusListener(ActionListener listener) {
    //     updateCaseStatusButton.addActionListener(listener);
    // }

    public void addValidateReportListener(ActionListener listener) {
        validateReportButton.addActionListener(listener);
    }

    public void addViewStatisticsListener(ActionListener listener) {
        viewStatisticsButton.addActionListener(listener);
    }

    public void addSearchCaseListener(ActionListener listener) {
        searchCaseButton.addActionListener(listener);
    }

    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
}
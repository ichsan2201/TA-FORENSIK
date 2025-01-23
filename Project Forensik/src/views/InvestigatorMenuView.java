package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InvestigatorMenuView extends JFrame {
    private JButton searchAssignedCasesButton;
    private JButton manageCaseDetailsButton;
    private JButton updateCaseButton;
    private JButton viewCaseHistoryButton;
    private JButton logoutButton;

    public InvestigatorMenuView() {
        setTitle("Menu Penyidik");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Initialize Buttons
        searchAssignedCasesButton = new JButton("Cari Kasus yang Ditugaskan");
        manageCaseDetailsButton = new JButton("Kelola Detail Kasus");
        updateCaseButton = new JButton("Update Kasus");
        viewCaseHistoryButton = new JButton("Lihat Riwayat Kasus");
        logoutButton = new JButton("Logout");

        // Add Buttons to Layout
        add(searchAssignedCasesButton);
        add(manageCaseDetailsButton);
        add(updateCaseButton);
        add(viewCaseHistoryButton);
        add(logoutButton);
    }

    public void addSearchAssignedCasesListener(ActionListener listener) {
        searchAssignedCasesButton.addActionListener(listener);
    }

    public void addManageCaseDetailsListener(ActionListener listener) {
        manageCaseDetailsButton.addActionListener(listener);
    }

    public void addUpdateCaseListener(ActionListener listener) {
        updateCaseButton.addActionListener(listener);
    }

    public void addViewCaseHistoryListener(ActionListener listener) {
        viewCaseHistoryButton.addActionListener(listener);
    }

    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
}
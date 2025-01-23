package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminView extends JFrame {
    private JButton manageUsersButton;
    private JButton viewLogsButton;
    private JButton viewReportsAndStatsButton; // Tombol baru
    private JButton backupDataButton; // Tombol untuk backup data
    private JButton logoutButton;

    public AdminView() {
        setTitle("Admin Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        manageUsersButton = new JButton("Manage Users");
        viewLogsButton = new JButton("View Logs");
        viewReportsAndStatsButton = new JButton("View Reports and Statistics"); // Tambahan
        backupDataButton = new JButton("Backup Data"); // Tambahan
        logoutButton = new JButton("Logout");

        add(manageUsersButton);
        add(viewLogsButton);
        add(viewReportsAndStatsButton);
        add(backupDataButton);
        add(logoutButton);
    }

    public void addManageUsersListener(ActionListener listener) {
        manageUsersButton.addActionListener(listener);
    }

    public void addViewLogsListener(ActionListener listener) {
        viewLogsButton.addActionListener(listener);
    }

    public void addViewReportsAndStatsListener(ActionListener listener) {
        viewReportsAndStatsButton.addActionListener(listener); // Listener baru
    }

    public void addBackupDataListener(ActionListener listener) {
        backupDataButton.addActionListener(listener); // Listener baru
    }

    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
}
package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewLogsView extends JFrame {
    private JTextArea logsTextArea;
    private JButton backButton;

    public ViewLogsView() {
        setTitle("View Activity Logs");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        logsTextArea = new JTextArea();
        logsTextArea.setEditable(false);

        backButton = new JButton("Back");

        setLayout(new BorderLayout());
        add(new JScrollPane(logsTextArea), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    public void displayLogs(java.util.List<String> logs) {
        logsTextArea.setText(String.join("\n", logs));
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
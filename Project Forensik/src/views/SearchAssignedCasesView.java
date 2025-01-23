package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchAssignedCasesView extends JFrame {
    private JTable casesTable;
    private JButton backButton;

    public SearchAssignedCasesView() {
        setTitle("Daftar Kasus yang Ditugaskan");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table
        casesTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(casesTable);
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        backButton = new JButton("Kembali");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setTableData(String[][] data, String[] columnNames) {
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        casesTable.setModel(tableModel);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
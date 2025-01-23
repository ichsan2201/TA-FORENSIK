package views;

import java.awt.*;
import javax.swing.*;

public class SearchCaseView extends JFrame {
    private JTextField caseNumberField;
    private JTextField dateField;
    private JTextField crimeTypeField;
    private JButton searchButton;
    private JTextArea resultArea;
    private JButton backButton;

    public SearchCaseView() {
        setTitle("Search Cases");
        setSize(500, 500);
        setLayout(new BorderLayout());

        // Panel input filter
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Filter Cases"));

        inputPanel.add(new JLabel("Case Number:"));
        caseNumberField = new JTextField();
        inputPanel.add(caseNumberField);

        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Crime Type:"));
        crimeTypeField = new JTextField();
        inputPanel.add(crimeTypeField);

        searchButton = new JButton("Search");
        inputPanel.add(new JLabel());
        inputPanel.add(searchButton);

        // Area hasil pencarian
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Tombol kembali
        backButton = new JButton("Back");

        // Tambahkan ke layout
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JTextField getCaseNumberField() {
        return caseNumberField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getCrimeTypeField() {
        return crimeTypeField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextArea getResultArea() {
        return resultArea;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
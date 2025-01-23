package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ManageUsersView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton addUserButton;
    private JButton removeUserButton;
    private JList<String> userList;
    private DefaultListModel<String> userListModel;

    public DefaultListModel<String> getUserListModel() {
        return userListModel;
    }

    public ManageUsersView() {
        setTitle("Manage Users");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("Role:"));
        roleComboBox = new JComboBox<>(new String[]{"KepalaPenyidik", "Penyidik"});
        inputPanel.add(roleComboBox);

        panel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 7, 7));
        addUserButton = new JButton("Add User");
        removeUserButton = new JButton("Remove User");
        buttonPanel.add(addUserButton);
        buttonPanel.add(removeUserButton);
        panel.add(buttonPanel, BorderLayout.CENTER);

        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        panel.add(new JScrollPane(userList), BorderLayout.SOUTH);

        add(panel);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getRole() {
        return (String) roleComboBox.getSelectedItem();
    }

    public void addUserToList(String user) {
        userListModel.addElement(user);
    }

    public String getSelectedUser() {
        return userList.getSelectedValue();
    }

    public void addAddUserListener(ActionListener listener) {
        addUserButton.addActionListener(listener);
    }

    public void addRemoveUserListener(ActionListener listener) {
        removeUserButton.addActionListener(listener);
    }
}
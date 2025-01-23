package controllers;

import javax.swing.*;
import models.ActivityLog;
import models.CaseManager;
import models.User;
import models.UserManager;
import views.InvestigatorMenuView;
import views.KepalaPenyidikView;
import views.LoginView;

public class LoginController {
    private LoginView loginView;
    private UserManager userManager;
    private ActivityLog activityLog;

    public LoginController(LoginView loginView, UserManager userManager, ActivityLog activityLog) {
        this.loginView = loginView;
        this.userManager = userManager;
        this.activityLog = activityLog;

        this.loginView.addLoginListener(e -> authenticate());
    }

    private void authenticate() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        User user = userManager.getUsers().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (user != null) {
            activityLog.addLog(user.getRole() + " " + username + " logged in.");
            navigateToRoleMenu(user);
        } else {
            loginView.setMessage("Invalid username or password.");
        }
    }

    private void navigateToRoleMenu(User user) {
        loginView.dispose();
        switch (user.getRole()) {
            case "Admin":
                new AdminController(new views.AdminView(), userManager, activityLog, new CaseManager(userManager)).getView().setVisible(true);
                break;
            case "KepalaPenyidik":
                new KepalaPenyidikController(new KepalaPenyidikView(), activityLog, new CaseManager(userManager)).getView().setVisible(true);
                break;
            case "Penyidik":
                new InvestigatorController(new InvestigatorMenuView(), new CaseManager(userManager), user.getUsername()).getView().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Role tidak didukung.");
        }
    }
}
package main;

import controllers.LoginController;
import models.ActivityLog;
import models.UserManager;
import views.LoginView;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        ActivityLog activityLog = new ActivityLog();

        userManager.addUser("admin", "admin123", "Admin");
        userManager.addUser("kepala", "kepala123", "KepalaPenyidik");
        userManager.addUser("penyidik1", "penyidik123", "Penyidik");
        userManager.addUser("penyidik2", "penyidik123", "Penyidik");

        LoginView loginView = new LoginView();
        new LoginController(loginView, userManager, activityLog);

        loginView.setVisible(true);
    }
}
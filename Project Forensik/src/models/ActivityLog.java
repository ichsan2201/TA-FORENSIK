package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityLog {
    private List<String> logs;
    private static final String LOG_FILE = "activity_log.txt";

    public ActivityLog() {
        this.logs = loadLogsFromFile();
    }

    public void addLog(String message) {
        logs.add(message);
        saveLogsToFile();
    }

    public List<String> getLogs() {
        return logs;
    }

    private List<String> loadLogsFromFile() {
        List<String> loadedLogs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedLogs.add(line);
            }
        } catch (IOException e) {
            System.out.println("No existing log file found. Starting fresh.");
        }
        return loadedLogs;
    }

    private void saveLogsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            for (String log : logs) {
                writer.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backupLogs(String backupFilePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(backupFilePath))) {
            for (String log : logs) {
                writer.println(log);
            }
        }
    }

}
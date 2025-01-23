package models;

import java.io.*;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List;
import java.util.Map;

public class CaseManager {

    private List<Case> cases;
    private UserManager userManager; // Referensi ke UserManager
    private static final String CASES_FILE = "cases.txt";

    public CaseManager(UserManager userManager) {
        this.userManager = userManager;
        this.cases = loadCasesFromFile();
    }

    public List<Case> getCases() {
        return cases;
    }

    public String[] getCaseNumbers() {
        return cases.stream().map(Case::getCaseNumber).toArray(String[]::new);
    }

    public void addCase(Case newCase) {
        cases.add(newCase);
        saveCasesToFile();
    }

    public void assignInvestigatorToCase(String caseNumber, String investigatorName) {
        for (Case c : cases) {
            if (c.getCaseNumber().equals(caseNumber)) {
                c.setAssignedInvestigator(investigatorName);
                saveCasesToFile();
                return;
            }
        }
    }

    public String[] getInvestigators() {
        // Ambil hanya pengguna dengan peran "Penyidik"
        return userManager.getUsersByRole("Penyidik")
                .stream()
                .map(User::getUsername)
                .toArray(String[]::new);
    }

    private List<Case> loadCasesFromFile() {
        List<Case> loadedCases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CASES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    Case c = new Case(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    if (parts.length == 6) {
                        c.setAssignedInvestigator(parts[5]);
                    }
                    loadedCases.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing case file found. Starting fresh.");
        }
        return loadedCases;
    }

    private void saveCasesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CASES_FILE))) {
            for (Case c : cases) {
                writer.printf("%s,%s,%s,%s,%s,%s%n",
                        c.getCaseNumber(),
                        c.getCrimeType(),
                        c.getCrimeLocation(),
                        c.getDate(),
                        c.getStatus(),
                        c.getAssignedInvestigator() == null ? "" : c.getAssignedInvestigator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CaseManager.java
    public void saveCaseDetails(String caseNumber, String suspectInfo, String witnessInfo, String findings, String report) {
        String fileName = "case_details_" + caseNumber + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Nomor kasus: " + caseNumber);
            writer.println("Informasi Tersangka: " + suspectInfo);
            writer.println("Informasi Saksi: " + witnessInfo);
            writer.println("Temuan: " + findings);
            writer.println("Report: " + report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadCaseDetails(String caseNumber) {
        String fileName = "case_details_" + caseNumber + ".txt";
        StringBuilder caseDetails = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                caseDetails.append(line).append("\n");
            }
        } catch (IOException e) {
            return "No details found for this case.";
        }
        return caseDetails.toString();
    }

    public boolean updateCaseStatus(String caseNumber, String investigatorName, String newStatus) {
        for (Case c : cases) {
            if (c.getCaseNumber().equals(caseNumber) && investigatorName.equals(c.getAssignedInvestigator())) {
                c.setStatus(newStatus);
                saveCasesToFile();
                return true;
            }
        }
        return false;
    }

    public Object[][] getClosedCasesByInvestigator(String investigatorName) {
        return cases.stream()
                .filter(c -> "CLOSED".equals(c.getStatus()) && investigatorName.equals(c.getAssignedInvestigator()))
                .map(c -> new Object[]{c.getCaseNumber(), c.getCrimeType(), c.getCrimeLocation(), c.getDate(), c.getStatus()})
                .toArray(Object[][]::new);
    }

    public String getCaseReport(String caseNumber) {
        String filePath = "case_details_" + caseNumber + ".txt";
        StringBuilder reportContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reportContent.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Report not found for Case Number: " + caseNumber;
        }

        return reportContent.toString();
    }

    public void updateCaseStatus(String caseNumber, String newStatus) {
        for (Case c : cases) {
            if (c.getCaseNumber().equals(caseNumber)) {
                c.setStatus(newStatus);
                saveCasesToFile();
                return;
            }
        }
    }

    public Map<String, Integer> getStatisticsByType() {
        Map<String, Integer> stats = new HashMap<>();
        for (Case c : cases) {
            stats.put(c.getCrimeType(), stats.getOrDefault(c.getCrimeType(), 0) + 1);
        }
        return stats;
    }

    public Map<String, Integer> getStatisticsByLocation() {
        Map<String, Integer> stats = new HashMap<>();
        for (Case c : cases) {
            stats.put(c.getCrimeLocation(), stats.getOrDefault(c.getCrimeLocation(), 0) + 1);
        }
        return stats;
    }

    public Map<String, Integer> getStatisticsByStatus() {
        Map<String, Integer> stats = new HashMap<>();
        for (Case c : cases) {
            stats.put(c.getStatus(), stats.getOrDefault(c.getStatus(), 0) + 1);
        }
        return stats;
    }

    public List<Case> searchCases(String caseNumber, String date, String crimeType) {
        return cases.stream()
                .filter(c -> (caseNumber.isEmpty() || c.getCaseNumber().equalsIgnoreCase(caseNumber)) &&
                        (date.isEmpty() || c.getDate().equalsIgnoreCase(date)) &&
                        (crimeType.isEmpty() || c.getCrimeType().equalsIgnoreCase(crimeType)))
                .toList();
    }

    public void backupCases(String backupFilePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(backupFilePath))) {
            for (Case c : cases) {
                writer.printf("%s,%s,%s,%s,%s,%s%n",
                        c.getCaseNumber(),
                        c.getCrimeType(),
                        c.getCrimeLocation(),
                        c.getDate(),
                        c.getStatus(),
                        c.getAssignedInvestigator() == null ? "" : c.getAssignedInvestigator());
            }
        }
    }
}
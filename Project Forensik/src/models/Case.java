package models;

public class Case {
    private String caseNumber;
    private String crimeType;
    private String location;
    private String date;
    private String status;
    private String assignedInvestigator;

    public Case(String caseNumber, String crimeType, String location, String date, String status) {
        this.caseNumber = caseNumber;
        this.crimeType = crimeType;
        this.location = location;
        this.date = date;
        this.status = status;
        this.assignedInvestigator = null;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getCrimeLocation() {
        return location;
    }

    public void setCrimeLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedInvestigator() {
        return assignedInvestigator;
    }

    public void setAssignedInvestigator(String assignedInvestigator) {
        this.assignedInvestigator = assignedInvestigator;
    }
}
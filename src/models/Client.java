package models;

import java.time.LocalDate;

public class Client {
    private int idClient;
    private int idDocumentType;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String phoneNumber;
    private int points;
    private LocalDate birthDate;

    public Client(){}
    public Client(int idClient, int idDocumentType, String firstName, String lastName, String documentNumber, String phoneNumber, int points, LocalDate birthDate) {
        this.idClient = idClient;
        this.idDocumentType = idDocumentType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.points = points;
        this.birthDate = birthDate;
    }

    // Getters
    public int getIdClient() {
        return idClient;
    }

    public int getIdDocumentType() {
        return idDocumentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPoints() {
        return points;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Setters
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdDocumentType(int idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

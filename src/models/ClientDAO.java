package models;

import models.Client;
import controllers.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ClientDAO {
    public void createClient(Client client) throws SQLException {
        String query = "INSERT INTO clients (idDocumentType, firstName, lastName, documentNumber, phoneNumber, points, birthDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getIdDocumentType());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getDocumentNumber());
            statement.setString(5, client.getPhoneNumber());
            statement.setInt(6, client.getPoints());
            statement.setDate(7, java.sql.Date.valueOf(client.getBirthDate()));

            statement.executeUpdate();
        }
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idClient");
                int idDocumentType = resultSet.getInt("idDocumentType");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String documentNumber = resultSet.getString("documentNumber");
                String phoneNumber = resultSet.getString("phoneNumber");
                int points = resultSet.getInt("points");
                LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();

                Client client = new Client(id, idDocumentType, firstName, lastName, documentNumber, phoneNumber, points, birthDate);
                clients.add(client);
            }
        }
        return clients;
    }

    public void updateClient(Client client) throws SQLException {
        String query = "UPDATE clients SET idDocumentType=?, firstName=?, lastName=?, documentNumber=?, phoneNumber=?, points=?, birthDate=? WHERE idClient=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getIdDocumentType());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getDocumentNumber());
            statement.setString(5, client.getPhoneNumber());
            statement.setInt(6, client.getPoints());
            statement.setDate(7, java.sql.Date.valueOf(client.getBirthDate()));
            statement.setInt(8, client.getIdClient());

            statement.executeUpdate();
        }
    }

    public void deleteClient(int clientId) throws SQLException {
        String query = "DELETE FROM clients WHERE idClient=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientId);

            statement.executeUpdate();
        }
    }

    public Client getClientById(int clientId) throws SQLException {
        String query = "SELECT * FROM clients WHERE idClient = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, clientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("idClient");
                    int idDocumentType = resultSet.getInt("idDocumentType");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String documentNumber = resultSet.getString("documentNumber");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    int points = resultSet.getInt("points");
                    LocalDate birthDate = resultSet.getDate("birthDate").toLocalDate();

                    return new Client(id, idDocumentType, firstName, lastName, documentNumber, phoneNumber, points, birthDate);
                }
            }
        }
        return null;
    }
}

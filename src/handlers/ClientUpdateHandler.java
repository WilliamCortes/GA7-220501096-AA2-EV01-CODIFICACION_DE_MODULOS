package handlers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import models.Client;
import models.ClientDAO;

public class ClientUpdateHandler {
    private  ClientDAO clientDAO;

    {
        clientDAO = new ClientDAO();
    }

    public void updateClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del cliente que desea actualizar:");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        try {
            Client existingClient = clientDAO.getClientById(clientId);
            if (existingClient == null) {
                System.out.println("No se encontró ningún cliente con el ID especificado.");
                return;
            }

            System.out.println("Ingrese el nuevo tipo de documento:");
            int idDocumentType = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nuevo nombre:");
            String firstName = scanner.nextLine();

            System.out.println("Ingrese el nuevo apellido:");
            String lastName = scanner.nextLine();

            System.out.println("Ingrese el nuevo número de documento:");
            String documentNumber = scanner.nextLine();

            System.out.println("Ingrese el nuevo número de teléfono:");
            String phoneNumber = scanner.nextLine();

            System.out.println("Ingrese los nuevos puntos:");
            int points = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD):");
            LocalDate birthDate = LocalDate.parse(scanner.next());


            Client updatedClient = new Client(clientId, idDocumentType, firstName, lastName, documentNumber, phoneNumber, points, birthDate);
            clientDAO = new ClientDAO();
            clientDAO.updateClient(updatedClient);

            System.out.println("Cliente actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }
}

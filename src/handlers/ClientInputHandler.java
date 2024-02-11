package handlers;

import models.Client;
import models.ClientDAO;

import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDate;

public class ClientInputHandler {
    public static void handleClientCreation() throws SQLException {
        ClientDAO clientDAO = new ClientDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de documento:");
        int idDocumentType = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre:");
        String firstName = scanner.nextLine();

        System.out.println("Ingrese el apellido:");
        String lastName = scanner.nextLine();

        System.out.println("Ingrese el número de documento:");
        String documentNumber = scanner.nextLine();

        System.out.println("Ingrese el número de teléfono:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Ingrese los puntos:");
        int points = scanner.nextInt();

        System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.next());

        Client client = new Client(0, idDocumentType, firstName, lastName, documentNumber, phoneNumber, points, birthDate);

        clientDAO.createClient(client);

        System.out.println("Cliente creado exitosamente.");
    }
}


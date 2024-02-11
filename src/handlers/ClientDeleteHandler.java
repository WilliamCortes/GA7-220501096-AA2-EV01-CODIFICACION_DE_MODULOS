package handlers;

import java.sql.SQLException;
import java.util.Scanner;
import models.ClientDAO;

public class ClientDeleteHandler {
    private  ClientDAO clientDAO = new ClientDAO();

    public void deleteClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del cliente que desea eliminar:");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        try {
            clientDAO.deleteClient(clientId);
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}

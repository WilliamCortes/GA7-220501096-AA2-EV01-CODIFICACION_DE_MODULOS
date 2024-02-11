package handlers;

import java.sql.SQLException;
import java.util.Scanner;
import models.ClientDAO;
public class MenuHandler {
    public void showMenu() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("*****************************");
            System.out.println("         MENÚ PRINCIPAL      ");
            System.out.println("*****************************");
            System.out.println("Opciones:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            System.out.println("*****************************");

            System.out.print("Ingrese una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    try {
                        ClientInputHandler.handleClientCreation();
                    } catch (SQLException e) {
                        System.out.println("Error al crear el cliente: " + e.getMessage());
                    }
                    break;
                case 2:
                    ListClientsHandler listClientsHandler = new ListClientsHandler(new ClientDAO());
                    listClientsHandler.listClients();
                    break;
                case 3:
                    ClientUpdateHandler clientUpdateHandler = new ClientUpdateHandler();
                    clientUpdateHandler.updateClient();
                    break;
                case 4:
                    ClientDeleteHandler clientDeleteHandler = new ClientDeleteHandler();
                    clientDeleteHandler.deleteClient();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }
}
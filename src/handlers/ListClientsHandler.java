package handlers;

import models.Client;
import models.ClientDAO;

import java.sql.SQLException;
import java.util.List;

public class ListClientsHandler {
    private final ClientDAO clientDAO;
    public ListClientsHandler(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void listClients() {
        try {
            List<Client> clients = clientDAO.getAllClients();
            if (clients.isEmpty()) {
                System.out.println("No hay clientes para mostrar.");
            } else {
                System.out.println("Clientes:");
                for (Client client : clients) {
                    System.out.println("Id: "+client.getIdClient()+" Documento: "+ client.getDocumentNumber() + " Nombre: "+ client.getFirstName()+" "+client.getLastName());
                    System.out.println("-----------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los clientes: " + e.getMessage());
        }
    }
}
/* try {
            controllers.DBConnection dbConnection = controllers.DBConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            //statement.executeUpdate("INSERT INTO clientes(Cli_RazonSocial) VALUES ('CLIENT_FROM_JAVA')");
            ResultSet rs = statement.executeQuery("SELECT * FROM clients");
            rs.next();
            do {
                System.out.println("Documento: "+rs.getInt("documentNumber") +" Nombre: "+ rs.getString("firstName"));
                System.out.println("********************************");
            } while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al listar los clientes: " + e.getMessage());
        }*/
import handlers.MenuHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.print("Hello and welcome!\n");
        MenuHandler menuHandler = new MenuHandler();
        menuHandler.showMenu();

    }
}
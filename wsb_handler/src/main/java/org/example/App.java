package org.example;

import main.java.org.example.DatabaseConnector;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connect();

        boolean quit = false;

        while (!quit) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj nowy obiekt Person");
            System.out.println("2. Odczytaj obiekt Person");
            System.out.println("3. Zaktualizuj obiekt Person");
            System.out.println("4. Usuń obiekt Person");
            System.out.println("5. Wyjście");
            System.out.print("> ");

            int option = scanner.nextInt();
            scanner.nextLine();  // konsumowanie nowego wiersza po wczytaniu int

            switch (option) {
                case 1:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username = scanner.nextLine();
                    System.out.print("Podaj adres email: ");
                    String email = scanner.nextLine();
                    System.out.print("Podaj hasło: ");
                    String pass = scanner.nextLine();
                    System.out.print("Podaj stan aktywności (true/false): ");
                    boolean enabled = scanner.nextBoolean();
                    scanner.nextLine();  // konsumowanie nowego wiersza po wczytaniu boolean
                    Person p = new Person(-1, username, email, pass, enabled);
                    p.create(dbc);
                    break;
                case 2:
                    System.out.print("Podaj nazwę użytkownika: ");
                    username = scanner.nextLine();
                    p = new Person(-1, username, "", "", false);
                    p.read(dbc);
                    break;
                case 3:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username2 = scanner.nextLine();
                    System.out.print("Podaj adres email: ");
                    String email2 = scanner.nextLine();
                    System.out.print("Podaj hasło: ");
                    String pass2 = scanner.nextLine();
                    System.out.print("Podaj stan aktywności (true/false): ");
                    boolean enabled2 = scanner.nextBoolean();
                    scanner.nextLine();  // konsumowanie nowego wiersza po wczytaniu boolean
                    Person p2 = new Person(-1, username2, email2, pass2, enabled2);
                    p2.update(dbc);
                    break;
                case 4:
                    System.out.print("Podaj nazwę użytkownika: ");
                    username = scanner.nextLine();
                    p = new Person(-1, username, "", "", false);
                    p.delete(dbc);
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }
    }
}

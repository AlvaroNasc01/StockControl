package app.stockcontrol;

import app.stockcontrol.controller.Menu;
import app.stockcontrol.controller.UserCreateAccount;
import app.stockcontrol.controller.UserLogin;
import app.stockcontrol.products.ProductController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws SQLException{

        Menu menu = new Menu();
        menu.startMenu();
        int option = input.nextInt();

        switch (option){
            case 1:
                Boolean condition = true;
                int cont = 1;

                while (condition){
                    System.out.println("\n---- USER LOGIN ----");
                    System.out.print("Enter your email: ");
                    String email = input.next();
                    System.out.print("Enter your password: ");
                    String password = input.next();
                    UserLogin userLogin = new UserLogin(email, password);

                    if(userLogin.login() != null){
                        System.out.println("\nLOGIN SUCCESSFULLY");
                        System.out.printf("WELCOME %s%n", userLogin.login());
                        menu.postLoginMenu();
                        ProductController pc = new ProductController();
                        pc.switchProduct();


                        condition = false;
                    } else {
                        System.out.println("\r\nInvalid email or password!\r\n");
                        cont++;

                        if (cont == 4){
                            System.out.println("3 attempts made - Quitting!");
                            System.exit(1);
                        }
                    }
                }
                break;
            case 2:
                System.out.println("\n---- CREATE ACCOUNT ----");
                System.out.print("Enter your name: ");
                String name = input.next();
                System.out.print("Enter your email: ");
                String email = input.next();
                System.out.print("Enter your password: ");
                String password = input.next();

                UserCreateAccount userCreateAccount = new UserCreateAccount(name, email, password);
                if (userCreateAccount.createAccount() > 0){
                    System.out.println("The Account was created successfully.");
                } else {
                    System.out.println("E-mail already registered! Try again with another email address.");
                }
                break;

                default:
                System.out.println("Exit!");
        }
        input.close();
    }
}
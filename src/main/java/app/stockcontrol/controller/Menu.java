package app.stockcontrol.controller;

public class Menu {

    public void startMenu(){
        System.out.println("------- SELECT YOUR OPTION -------");
        System.out.println("1 - Login");
        System.out.println("2 - Create new account");
        System.out.println("\nClick any other value to exit the program.");
    }

    public void postLoginMenu(){
        System.out.println("\n------- SELECT YOUR OPTION -------");
        System.out.println("1 - Add new product");
        System.out.println("2 - Remove product");
        System.out.println("3 - View products");
        System.out.println("4 - Check the total value in stock ($)");
        System.out.println("5 - View expired products");
        System.out.println("\nClick any other value to exit the program.");
    }

}

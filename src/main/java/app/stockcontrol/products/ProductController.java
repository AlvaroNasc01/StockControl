package app.stockcontrol.products;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import app.stockcontrol.controller.UserChangePassword;

import java.sql.Date;

public class ProductController {

    private int value;

    public void switchProduct() throws SQLException{

        Scanner input = new Scanner(System.in);
        this.value = input.nextInt();
        
        Products products = new Products();
        Boolean condition = true;

        switch (this.value){
            case 1:
            
            while (condition) {
                
                System.out.println("\n---- Add products ----\n");
                System.out.println("Enter product name: ");
                String product_name = input.next();
                System.out.println("Enter product category: ");
                String category = input.next();
                System.out.println("Enter product provider: ");
                String provider = input.next();
                System.out.println("Enter the quantity of products: ");
                int amount = input.nextInt();
                System.out.println("Enter the price of the product: ");
                Double price = input.nextDouble();
                System.out.println("FORMAT (YYYY-MM-DD) - Enter the expiration date: ");
                String expiration_date = input.next();
                Date date = Date.valueOf(expiration_date);
                products.addProduct(product_name, category, provider, amount, price, date);
                
                System.out.println("Do you want to add any more products? y/n:  ");
                String validate = input.next();

                if (Objects.equals(validate, "n") || Objects.equals(validate, "N")) {
                    condition = false;
                }
            }
                break;
            case 2:
                while (condition) {
                    
                    System.out.println("\n---- Remove products ----\n");
                    products.viewStock();

                    System.out.println("\nEnter product ID to remove: ");
                    int id = input.nextInt();
                    products.removeProduct(id);
                    System.out.println("Do you want to remove more products? y/n:  ");
                    String validate = input.next();

                    if (Objects.equals(validate, "n") || Objects.equals(validate, "N")) {
                        condition = false;
                }
                }
                break;
            case 3:
                System.out.println("\n---- View Stock ----\n");
                
                System.out.println("1 - View full stock");
                System.out.println("2 - View stock by filtering (product_name,category,provider) \n");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        products.viewStock();    
                        break;
                    case 2:
                        System.out.printf("Filter type: ");
                        String filtertype = input.next();
                        System.out.printf("Value: ");
                        String value = input.next();
                        products.viewStockWithFilter(filtertype, value);
                        break;
                    default:
                        System.out.println("Exit!");
                        break;
                }
                break;
            case 4:
                System.out.println("The total value in stock is: " + products.stockMoney());
                break;
            case 5:
                products.expiration_date();
                break;
            default:
                System.out.println("Exit!");
        }

        input.close();
    }

}

package app.stockcontrol.products;

import app.stockcontrol.database.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Products {

    Connect connection = new Connect();

    public void addProduct(String product_name, String category, String provider, int amount, double price, Date expiration_date) throws SQLException {
        String query = "INSERT INTO products (product_name, category, provider, amount, price, expiration_date) VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = connection.createConnection().prepareStatement(query);
        stmt.setString(1, product_name);
        stmt.setString(2, category);
        stmt.setString(3, provider);
        stmt.setInt(4, amount);
        stmt.setDouble(5, price);
        stmt.setDate(6, expiration_date);

        stmt.executeUpdate();
    }
    public void removeProduct(int id) throws SQLException{
        String query = "DELETE FROM products WHERE id=?";

        PreparedStatement stmt = connection.createConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
    public void viewStock() throws SQLException{
        String query = "SELECT id,product_name,category,provider,amount,price,expiration_date FROM products";

        ResultSet rs = connection.createConnection().createStatement().executeQuery(query);

        while (rs.next()) {
            System.out.printf("Id: %s \t| Product_name: %s | Category: %s | Provider: %s | Quantity: %s | Price: %s | Expiration_date: %s\n", rs.getInt("id"), rs.getString("product_name"), rs.getString("category"), rs.getString("provider"), rs.getInt("amount"), rs.getDouble("price"), rs.getDate("expiration_date"));
        }

    }

    public void viewStockWithFilter(String filterType, Object value) throws SQLException{

        String query = "SELECT id,product_name,category,provider,amount,price,expiration_date FROM products WHERE " + filterType + "=?";

        PreparedStatement stmt = connection.createConnection().prepareStatement(query);
        
        stmt.setObject(1, value);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
           System.out.printf("Id: %s \t| Product_name: %s | Category: %s | Provider: %s | Quantity: %s | Price: %s | Expiration_date: %s\n", rs.getInt("id"), rs.getString("product_name"), rs.getString("category"), rs.getString("provider"), rs.getInt("amount"), rs.getDouble("price"), rs.getDate("expiration_date")); 
        }
    }

    public double stockMoney() throws SQLException{
        String query = "SELECT amount,price FROM products";

        ResultSet rs = connection.createConnection().createStatement().executeQuery(query);

        double total = 0.0;

        while (rs.next()) {
            double amount = rs.getInt("amount");
            double price = rs.getDouble("price");
            double result = price * amount;

            total = total + result;
        }

        return total;
    }

    public void expiration_date() throws SQLException{
        String query = "SELECT id,product_name,amount,expiration_date FROM products";

        Date actualDate = new Date(System.currentTimeMillis());

        ResultSet rs = connection.createConnection().createStatement().executeQuery(query);

        while (rs.next()) {
           int id = rs.getInt("id");
           String product_name = rs.getString("product_name");
           int amount = rs.getInt("amount"); 
           Date date = rs.getDate("expiration_date");
           
           if (actualDate.after(date)) {
                System.out.printf("\n%s | Expired product -> %s | Quantity: %s\n", id,product_name,amount);
           }

        }
    }
}

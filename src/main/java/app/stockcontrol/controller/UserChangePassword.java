package app.stockcontrol.controller;

import app.stockcontrol.database.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserChangePassword extends User {

    private String name;
    private String newPassword;

    public UserChangePassword(String name, String email, String password, String newPassword) {
        super(email, password);
        this.name = name;
        this.newPassword = newPassword;
    }

    public String changePassword(String newPassword) throws SQLException {

        Connect connection = new Connect();
        EncryptMD5 hash = new EncryptMD5();

        String query = "UPDATE accounts SET password=? WHERE name=? and password=?";

        PreparedStatement stmt = connection.createConnection().prepareStatement(query);
        stmt.setString(1, hash.returnHash(newPassword));
        stmt.setString(2, this.name);
        stmt.setString(3, getPassword());

        if (stmt.executeUpdate() > 0){
            return  "Password updated!";
        } else {
            return "Error!";
        }
    }
}

package app.stockcontrol.controller;

import app.stockcontrol.database.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCreateAccount extends User{

    private String name;
    public UserCreateAccount(String name, String email, String password) {
        super(email, password);
        this.name = name;
    }

    public int createAccount() throws SQLException {

        Connect connection = new Connect();
        EncryptMD5 hash = new EncryptMD5();
        ValidateEmail validate = new ValidateEmail();

        String query = "INSERT INTO accounts(email, name, password) VALUES (?,?,?)";

        PreparedStatement stmt = connection.createConnection().prepareStatement(query);
        stmt.setString(1, getEmail());
        stmt.setString(2, this.name);
        stmt.setString(3, hash.returnHash(getPassword()));

        if (validate.validateEmail(getEmail())){
            return -1;
        } else {
            return stmt.executeUpdate();
        }
    }
}

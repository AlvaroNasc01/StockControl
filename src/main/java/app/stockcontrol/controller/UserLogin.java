package app.stockcontrol.controller;

import app.stockcontrol.database.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin extends User {

    public UserLogin(String email, String password) {
        super(email, password);
    }

    Connect connection = new Connect();

    public String login() throws SQLException{

        EncryptMD5 hash = new EncryptMD5();

        String query = "SELECT name FROM accounts WHERE email=? AND password=?";

        PreparedStatement stmt = connection.createConnection().prepareStatement(query);
        stmt.setString(1, getEmail());
        stmt.setString(2, hash.returnHash(getPassword()));
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            return rs.getString(1);
        }

        return null;
    }
}

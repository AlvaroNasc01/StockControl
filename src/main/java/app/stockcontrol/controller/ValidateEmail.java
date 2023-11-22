package app.stockcontrol.controller;

import app.stockcontrol.database.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;;

public class ValidateEmail{

    Connect connection = new Connect();
    Boolean existing = false;

    public boolean validateEmail(String email) throws SQLException {


        String query = "SELECT email from accounts";

        ResultSet rs = connection.createConnection().createStatement().executeQuery(query);

        while (rs.next()){
            String emailDB = rs.getString("email");
            if (email.equals(emailDB)){
                existing = true;
                break;
            }
        }

        return existing;
    }
}

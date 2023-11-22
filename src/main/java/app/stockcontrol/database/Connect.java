package app.stockcontrol.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private String jdbc_url = "jdbc:postgresql://localhost:5432/stockcontrol";
    private String jdbc_user = "postgres";
    private String jdbc_password = "admin";

    public Connection createConnection(){
        try {
            return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
        } catch (SQLException e){
            System.out.println(e);
        }

        return null;
    }

}

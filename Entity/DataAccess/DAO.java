package Main.Entity.DataAccess;

import java.sql.*;

public class DAO {
    private String connectURL = "jdbc:sqlserver://;" +
                                "serverName=localhost;" +
                                "databaseName=CNPM;" +
                                "encrypt=true;trustServerCertificate=true";
    private String DBuser = "sa";
    private String DBpass = "123456";

    private Connection connect;
    private Statement stmt;

    public ResultSet executeQuery(String sqlQuery){
        ResultSet result = null;
        try {
            connect = DriverManager.getConnection(connectURL,DBuser,DBpass);
            stmt= connect.createStatement();
            result = stmt.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}

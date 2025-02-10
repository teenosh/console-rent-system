package Scripts;

import java.sql.*;

public class PostgresDB implements IDB{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionURL, "postgres", "bekzhan123");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

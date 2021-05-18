package datos;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?ussSll=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";//asignar su contraseña

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(Connection cox) throws SQLException {
        cox.close();
    }

    public static void close(Statement stt) throws SQLException {
        stt.close();
    }

    public static void close(PreparedStatement stt) throws SQLException {
        stt.close();
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
}

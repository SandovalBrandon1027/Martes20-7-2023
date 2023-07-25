import java.sql.*;

public class sql_datos {

    static final String DB_URL = "jdbc:mysql://localhost/estudiantes";
    static final String USER = "root";
    static final String PASS = "root_bas3";
    static final String QUERY = "SELECT * FROM datos_estudiantes";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                System.out.println("-----------------------------------------------");
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("nombre: " + rs.getString("nombre"));
                System.out.println("Edad: "+rs.getString("Edad"));
                System.out.println("Ciudad: "+rs.getString("Ciudad"));
                System.out.println("Cedula: "+rs.getInt("Cedula"));
                System.out.println("Password: "+rs.getString("Password"));
                System.out.println("------------------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

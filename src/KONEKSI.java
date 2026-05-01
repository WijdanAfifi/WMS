/**
 * @author Wijdan Afifi
 */
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class KONEKSI {
    private static Connection conn;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                
                Dotenv dotenv = Dotenv.load();

                String name = dotenv.get("DB_NAME");
                String user = dotenv.get("DB_USER");
                String pass = dotenv.get("DB_PASS");
                
                //CHECK DATA 
//                System.out.println(name);
//                System.out.println(user);
//                System.out.println(pass);
                
                String url = "jdbc:mysql://localhost:3306/" + name;
                
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("\n-> Koneksi mysql Berhasil !");
            } catch (SQLException e) {
                System.out.println("\nKoneksi mysql Gagal : " + e.getMessage());
            }
            catch (ClassNotFoundException e) {
                System.out.println("\nDriver MySQL tidak ditemukan!");
            }
        }
        
        return conn;
    }
}

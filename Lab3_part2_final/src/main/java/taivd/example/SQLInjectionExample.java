package taivd.example;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLInjectionExample {

    private static final Logger logger = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR '1'='1";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "pass")) {
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userInput);

                logger.info("Đang thực thi truy vấn an toàn...");

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        logger.info("Tìm thấy user: " + rs.getString("username"));
                    }
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi truy vấn SQL", e);
        }
    }
}

package taivd.example;

import java.util.logging.Logger;

public class InsecureLogin {

    private static final Logger logger = Logger.getLogger(InsecureLogin.class.getName());

    public static void login(String username, String password) {
        String realPassword = System.getenv("ADMIN_PASSWORD");
        if (username.equals("admin") && password.equals(realPassword)) {
            logger.info("Login successful");
        } else {
            logger.warning("Login failed");
        }
    }

    public void printUserInfo(String user) {
        if (user != null && !user.trim().isEmpty()) {
            logger.info("User: " + user);
        }
    }
}

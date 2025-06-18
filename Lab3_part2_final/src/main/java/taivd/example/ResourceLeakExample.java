package taivd.example;

import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ResourceLeakExample {
    private static final Logger logger = Logger.getLogger(ResourceLeakExample.class.getName());
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Đã xảy ra lỗi khi đọc file", e);
        }
    }
}

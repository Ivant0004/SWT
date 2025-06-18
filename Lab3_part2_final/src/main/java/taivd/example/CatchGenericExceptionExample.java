package taivd.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchGenericExceptionExample {

    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            String s = (Math.random() > 0.5) ? "hello" : null;
            if (s != null) {
                logger.info(String.format("Length: %d", s.length()));
            } else {
                logger.warning("String s is null");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Something went wrong", e);
        }
    }
}

package taivd.example;

import java.util.logging.Logger;

interface Drawables {
    void draw();
}

class Circles implements Drawables {
    private static final Logger logger = Logger.getLogger(Circles.class.getName());

    @Override
    public void draw() {
        logger.info("Drawing a circle");
    }
}

package ru.nsu.karabut.logoworld;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Startup...");
        try {
            String program = null;

            if (args.length >= 1) {
                program = args[0];
            }

            LogoWorld logoWorld = new LogoWorld(program);
            logoWorld.run();
        }
        catch (Exception e) {
            logger.error("Exception: " + e.getLocalizedMessage() + "!");
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        logger.debug("Finishing...");
    }
}

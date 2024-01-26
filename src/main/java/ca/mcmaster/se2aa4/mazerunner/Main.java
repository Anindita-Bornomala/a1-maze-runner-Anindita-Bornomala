package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            new MazeRunner(args);
        } catch (Exception e) {
            logger.error("Error");
        }
    }
}
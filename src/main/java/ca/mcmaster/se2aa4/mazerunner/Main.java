package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import org.apache.commons.cli.*; // EDIT 1
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        // Edit 2
        Options options = new Options();
        options.addOption("i", "input", true, "Input file path");
        
        CommandLineParser parser = new DefaultParser();
        // end of edit 2

        try {
            // edit 3
            
            CommandLine cmd = parser.parse(options, args);

            String inputFilePath;
            if (cmd.hasOption("i")) {
                inputFilePath = cmd.getOptionValue("i");
            } else {
                logger.error("Input file path is required");
                return;
            }
            // end of edit 3
            
            logger.info("**** Reading the maze from file " + inputFilePath); // edit 4, from "-i" to inputFilePath
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath)); // edit 5
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.trace("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.trace("PASS ");
                    }
                }
                logger.trace(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

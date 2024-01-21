package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess");
        
        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String inputFilePath = cmd.getOptionValue("i");
            // String inputPathGuess = cmd.getOptionValue("p");
            // System.out.println(inputFilePath) just equals the name of the .txt, example: "./examples/straight.maz.txt"
           
            logger.info("**** Reading the maze from file " + inputFilePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            
            String[][] mazeData; // edit

            // change "i" back to "idx" eventually
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(i) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

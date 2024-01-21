package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws FileNotFoundException, Exception { // exception thrown here for config methods
        logger.info("** Starting Maze Runner");

        Configuration config = configure(args);
        // System.out.println(config);

        logger.info("**** Reading the maze from file " + config.inputFile);
        BufferedReader reader = new BufferedReader(new FileReader(config.inputFile));

        // change "i" back to "idx" eventually
        String line;
        while ((line = reader.readLine()) != null) { // while the String line is not empty,
            for (int i = 0; i < line.length(); i++) { // for each element in a line
                if (line.charAt(i) == '#') {
                    System.out.print("WALL ");
                } else if (line.charAt(i) == ' ') {
                    System.out.print("PASS ");
                }
            }
            System.out.print(System.lineSeparator());
        }

        logger.info("**** Computing path");
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");

        MazeData maze = new MazeData();
        char[][] maze1 = maze.storeMazeData(config.inputFile);
        maze.printMazeData(maze1);
    }

    private static Configuration configure(String[] cmdArgs) throws Exception, FileNotFoundException {
        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, cmdArgs);
        String inputFilePath = cmd.getOptionValue("i");

        return new Configuration(inputFilePath);
    }

    private record Configuration(String inputFile) {
        Configuration {
            if (inputFile == null) {
                throw new IllegalArgumentException("Maze text file is empty!");
            } 
        }
    }

}

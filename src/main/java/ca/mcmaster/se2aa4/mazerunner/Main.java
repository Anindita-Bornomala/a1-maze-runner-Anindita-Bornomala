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
            
            //-----------------------------------------------------------------------------------------------------------------
            // edits: create empty mazeData
            int sumRows = 0;
            int sumCols = 0;

            String line2;
            while ((line2 = reader.readLine()) != null) {
                sumRows++;
                if (sumCols == 0) {
                    sumCols = line2.length();
                }
            }

            char[][] mazeData = new char[sumRows][sumCols];


            // edits: Fill mazeData with proper data
            String line3;
            int row = 0;
            while ((line3 = reader.readLine()) != null) {
                char[] mazeRow = line3.toCharArray();
                for (int column = 0; column < sumCols; column++) {
                    mazeData[row][column] = mazeRow[column];
                }
                row++;
            }
            // edits end

            for (char[] mazeRow : mazeData) {
                for (char element : mazeRow) {
                    System.out.println(element);
                }
                System.out.println();
            }

            //-----------------------------------------------------------------------------------------------------------------


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
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}

package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeData {

    /*
    Include this in Main.java to access:
    MazeData maze = new MazeData();
    char[][] maze1 = maze.storeMazeData(config.inputFile);
    maze.printMazeData(maze1);
    */

    public char[][] storeMazeData(String filePath) throws IOException, FileNotFoundException{
        
        // initialize an empty matrix with correct rows and columns
        int sumRows = 0;
        int sumCols = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line2;
        while ((line2 = reader.readLine()) != null) {
            sumRows++;
            if (sumCols == 0) {
                sumCols = line2.length();
            }
        }

        char[][] mazeData = new char[sumRows][sumCols];


        // Fill mazeData with proper data
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath));
        String line3;
        int row = 0;
        while ((line3 = reader2.readLine()) != null) {
            for (int column = 0; column < line3.length(); column++) {
                mazeData[row][column] = line3.charAt(column);
            }
            row++;
        }
        return mazeData;
    }

    public void printMazeData(char[][] mazeData) {
        for (char[] mazeRow : mazeData) {
            for (char element : mazeRow) {
                if (element == '#') {
                    System.out.print("WALL ");
                } else if (element == ' ') {
                    System.out.print("PASS ");
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
    
}

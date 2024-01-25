package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeData {

    public char[][] storeMazeData(String filePath) throws IOException, FileNotFoundException{
        int sumRows = 0;
        int sumCols = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            sumRows++;
            if (sumCols == 0) {
                sumCols = line.length();
            }
        }
        reader.close();

        char[][] mazeData = new char[sumRows][sumCols];

        BufferedReader reader2 = new BufferedReader(new FileReader(filePath));
        String line2;
        int row = 0;
        while ((line2 = reader2.readLine()) != null) {
            for (int column = 0; column < line2.length(); column++) {
                mazeData[row][column] = line2.charAt(column);
            }
            row++;
        }
        reader2.close();
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

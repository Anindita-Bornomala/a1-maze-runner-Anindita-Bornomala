package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeData {

    public static char[][] storeMazeData(String filePath) throws IOException, FileNotFoundException{
        
        // initialize an empty matrix with correct rows and columns
        int sumRows = 0;
        int sumCols = 0;

        BufferedReader reader2 = new BufferedReader(new FileReader(filePath));
        String line2;
        while ((line2 = reader2.readLine()) != null) {
            sumRows++;
            if (sumCols == 0) {
                sumCols = line2.length();
            }
        }

        char[][] mazeData = new char[sumRows][sumCols];


        // Fill mazeData with proper data
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line3;
        int row = 0;
        while ((line3 = reader.readLine()) != null) {
            for (int i = 0; i < line3.length(); i++) {
                if (line3.charAt(i) == '#') {
                    mazeData[row][i] = 'W';
                } else if (line3.charAt(i) == ' ') {
                    mazeData[row][i] = 'P';
                }
            }
            row++;
        }
        return mazeData;
    }

    public void printMazeData(char[][] mazeData) {
        for (char[] mazeRow : mazeData) {
            for (char element : mazeRow) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
    
}

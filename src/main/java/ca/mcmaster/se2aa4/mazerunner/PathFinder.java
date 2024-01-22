package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {

    public Integer[] pathStart(char[][] mazeData) {
        Integer[] startCoord = {0, 0};
        for (int row = 0; row < mazeData.length-1; row++) {
            if (mazeData[row].length > 0 && mazeData[row][0] != '#') {
                startCoord[0] = row;
                break;
            }
        }
        System.out.println("Start condition: row " + startCoord[0] + ", column " + startCoord[1]);
        return startCoord;
    }

    public Integer[] pathEnd(char[][] mazeData) {
        Integer[] endCoord = {0, mazeData.length-1};
        for (int row = 0; row < mazeData.length-1; row++) {
            if (mazeData[row].length > 0 && mazeData[row][mazeData.length-1] != '#') {
                endCoord[0] = row;
                break;
            }
        }
        System.out.println("End condition: row " + endCoord[0] + ", column " + endCoord[1]);
        return endCoord;
    }

    public Integer[] moveForward(Integer[] currentStep, Integer[] nextPosition) {
        currentStep = nextStep;
        System.out.println("Current position: row " + currentStep[0] + ", column " + currentStep[1]);
        return currentStep;
    }

    public Integer[] nextStep(Integer[] currentStep, char direction) {
        Integer[] nextPosition = currentStep;
        if (direction == 'E') {
            nextPosition[1]++;  
        } else if (direction == 'S') {
            nextPosition[0]++;
        } else if (direction == 'W') {
            nextPosition[1]--;
        } else {
            nextPosition[0]--;
        }
        System.out.println("Moving to: row " + nextPosition[0] + ", column " + nextPosition[1] + ", direction: " + direction);
        return nextPosition;
    }    
}

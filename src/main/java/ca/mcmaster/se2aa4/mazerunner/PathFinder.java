package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {

    // given maze data, return start condition
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

    // given maze data, return end condition
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

    public void checkCurrentStep(Integer[] currentSteps) {
        System.out.println("Current position: row " + currentSteps[0] + ", column " + currentSteps[1]);
    }

    public void checkCurrentDirection(char direction) {
        System.out.println("Current position: " + direction);
    }

    public Integer[] moveForward(Integer[] currentStep, Integer[] nextStep) {
        currentStep = nextStep;
        checkCurrentStep(currentStep);
        // System.out.println("Current position: row " + currentStep[0] + ", column " + currentStep[1]);
        return currentStep;
    }

    public char turnRight(char oldDirection) {
        char newDirection = 'E';
        if (oldDirection == 'E') {
            newDirection = 'S';
        } else if (oldDirection == 'S') {
            newDirection = 'W';
        } else if (oldDirection == 'W') {
            newDirection = 'N';
        } else if (oldDirection == 'N') {
            newDirection = 'E';
        }
        checkCurrentDirection(newDirection);
        return newDirection;
    }

    public char turnLeft(char oldDirection) {
        char newDirection = 'E';
        if (oldDirection == 'E') {
            newDirection = 'N';
        } else if (oldDirection == 'S') {
            newDirection = 'E';
        } else if (oldDirection == 'W') {
            newDirection = 'S';
        } else if (oldDirection == 'N') {
            newDirection = 'W';
        }
        checkCurrentDirection(newDirection);
        return newDirection;
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
        System.out.println("Next step: row " + nextPosition[0] + ", column " + nextPosition[1] + ", direction: " + direction);
        return nextPosition;
    }

    public boolean checkFront(char[][] mazeData, Integer[] currentSteps, char direction) { // THIS WORKS FINE! :^D
        Integer row = currentSteps[0];
        Integer col = currentSteps[1];
        if (direction == 'E') {
            col++;
        } else if (direction == 'S') {
            row++;
        } else if (direction == 'W') {
            col--;
        } else {
            row--;
        }
        if (mazeData[row][col] != '#') {
            System.out.println("True");
            return true;
        } else {
            System.out.println("False");
            return false;
        }
    }

    public boolean checkRight(char[][] mazeData, Integer[] currentSteps, char direction) {
        System.out.println("ENACT CHECKRIGHT FUNCTION:");

        char directChange = turnRight(direction); // now 'S'
        boolean pass = checkFront(mazeData, currentSteps, directChange);
        directChange = turnLeft(directChange);
        return pass; 
    }

    //pathfinding algorithm
    // DOESNT WORK, FIX THIS
    public String rightHandRule(char[][] mazeData) {
        Integer[] startCond = pathStart(mazeData);
        Integer[] endCond = pathEnd(mazeData);
        Integer[] pointer = startCond;
        String sequence = "";
        System.out.println();

        char direction = 'E';
        Integer[] nextPosition = nextStep(pointer, direction);
        
        while (pointer[1] < endCond[1]) {
            if (checkRight(mazeData, pointer, direction) == false) {
                if (checkFront(mazeData, pointer, direction) == true) {
                    pointer = moveForward(pointer, nextPosition);
                    sequence.concat("F");
                } else {
                    nextPosition = nextStep(pointer, turnRight(direction));
                    sequence.concat("R");
                }
            } else {
                nextPosition = nextStep(pointer, turnRight(direction));
                sequence.concat("R");
                pointer = moveForward(pointer, nextPosition);
                sequence.concat("F");
            }
        }
        System.out.println("Final position: row " + pointer[0] + ", column " + pointer[1]);
        return sequence;
    }


    
}

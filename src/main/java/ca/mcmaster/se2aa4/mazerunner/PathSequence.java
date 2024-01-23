package ca.mcmaster.se2aa4.mazerunner;

public class PathSequence {

    public static String FILEPATH = "i";
    public static String PATHCHECK = "p";

    public String rightHandRule(char[][] mazeData) { // RightHandRule: use to get a canonical path string
        PathFinder pathFind = new PathFinder();

        Integer[] startCond = pathFind.pathStart(mazeData);
        System.out.println("Start position: row " + startCond[0] + ", column " + startCond[1]);
        Integer[] endCond = pathFind.pathEnd(mazeData);
        System.out.println("End position: row " + endCond[0] + ", column " + endCond[1]);

        Integer[] pointer = startCond; // THIS IS THE PLAYER
        char direction = 'E';
        String sequence = "";
        Integer[] nextPosition;
        System.out.println();        
        
        while (pointer[1] < endCond[1]) {
            if (pathFind.checkRight(mazeData, pointer, direction) == false) { // CHECK IF WALL TO RIGHT
                if (pathFind.checkFront(mazeData, pointer, direction) == true) { // CHECK IF WALL IN FRONT
                    nextPosition = pathFind.nextStep(pointer, direction);
                    pointer = pathFind.moveForward(pointer, nextPosition); // MOVE FORWARD
                    sequence = sequence + "F";
                } else {
                    direction = pathFind.turnLeft(direction); // TURN LEFT
                    sequence = sequence + "L";
                }
            } else {
                direction = pathFind.turnRight(direction); // TURN RIGHT
                sequence = sequence + "R";
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition); // MOVE FORWARD
                sequence = sequence + "F";
            }
            pathFind.checkCurrentStep(pointer);
        }
        System.out.println();
        System.out.println("Final position: row " + pointer[0] + ", column " + pointer[1]);
        return sequence;
        }

    public String factorize(String canonical) {
        String result = "";
        int count = 1;

        for (int i = 1; i <= canonical.length(); i++) {
            if(i == canonical.length() || canonical.charAt(i) != canonical.charAt(i-1)) {
                result = result + count + canonical.charAt(i-1) + " ";
                count = 1;
            } else {
                count++;
            }
        }
        return result;
    }

    // Path guess checker
    public String pathCheck(char[][] mazeData, String pathGuess) {
        PathFinder pathFind = new PathFinder();

        Integer[] startCond = pathFind.pathStart(mazeData);
        Integer[] endCond = pathFind.pathEnd(mazeData);
        Integer[] pointer = startCond; // THIS IS THE PLAYER
        char direction = 'E';
        Integer[] nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition);
            } else if (element == 'R') {
                direction = pathFind.turnRight(direction); // TURN RIGHT
            } else if (element == 'L') {
                direction = pathFind.turnLeft(direction); // TURN LEFT
            }
        }
        if (pointer[1] == endCond[1]) {
            return "Correct path!";
        } else {
            return "Incorrect path!";
        }
    }
}

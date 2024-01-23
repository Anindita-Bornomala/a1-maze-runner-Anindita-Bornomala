package ca.mcmaster.se2aa4.mazerunner;

public class PathSequence {

    public static String FILEPATH = "i";
    public static String PATHCHECK = "p";

    public String findPath(char[][] mazeData) {
        PathFinder pathFind = new PathFinder();

        Integer[] startCond = pathFind.pathStart(mazeData);
        Integer[] endCond = pathFind.pathEnd(mazeData);
        Integer[] pointer = startCond; // THIS IS THE PLAYER
        char direction = 'E';
        String sequence = "";
        Integer[] nextPosition;
        System.out.println();        
        
        while (pointer[1] < endCond[1]) { // when current is at [2,3]
            if (pathFind.checkRight(mazeData, pointer, direction) == false) { // CHECK IF WALL TO RIGHT
                if (pathFind.checkFront(mazeData, pointer, direction) == true) { // CHECK IF WALL IN FRONT
                    nextPosition = pathFind.nextStep(pointer, direction);
                    pointer = pathFind.moveForward(pointer, nextPosition); // MOVE FORWARD
                    // sequence.concat("F");
                    sequence = sequence + "F";
                } else {
                    direction = pathFind.turnRight(direction); // TURN RIGHT
                    sequence = sequence + "R";
                    // sequence.concat("R");
                }
            } else {
                direction = pathFind.turnRight(direction); // TURN RIGHT
                //sequence.concat("R");
                sequence = sequence + "R";
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition); // MOVE FORWARD
                // sequence.concat("F");
                sequence = sequence + "F";
            }
        }
        System.out.println("Final position: row " + pointer[0] + ", column " + pointer[1]);
        return sequence;

        // RightHandRule pathFind = new RightHandRule();
        // use to get a canonical path string
        }

    public String factorize(String canonical) { return "False"; }

    // Path guess checker
    public String pathCheck() {
        return "Incorrect path!";
    }

}

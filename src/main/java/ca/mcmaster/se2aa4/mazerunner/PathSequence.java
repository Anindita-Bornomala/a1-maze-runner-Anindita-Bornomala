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
        Integer[] nextPosition = pathFind.nextStep(pointer, direction);
        System.out.println();        
        
        while (pointer[1] < endCond[1]) {
            if (pathFind.checkRight(mazeData, pointer, direction) == false) {
                if (pathFind.checkFront(mazeData, pointer, direction) == true) {
                    pointer = pathFind.moveForward(pointer, nextPosition);
                    sequence.concat("F");
                } else {
                    nextPosition = pathFind.nextStep(pointer, pathFind.turnRight(direction));
                    sequence.concat("R");
                }
            } else {
                nextPosition = pathFind.nextStep(pointer, pathFind.turnRight(direction));
                sequence.concat("R");
                pointer = pathFind.moveForward(pointer, nextPosition);
                sequence.concat("F");
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

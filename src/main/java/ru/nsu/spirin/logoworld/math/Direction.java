package ru.nsu.spirin.logoworld.math;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    UNKNOWN;

    /**
     * Converts given direction to delta vector
     * @param dir direction to be converted
     * @return pair
     */
    public static Pair convertDirectionToDelta(Direction dir) {
        int dx = 0, dy = 0;
//        if (dir != null) {
//            if(dir == UP){
//                dy = -1;
//            }
//            if(dir == DOWN){
//                dy = 1;
//            }
//            if(dir == LEFT){
//                dx = -1;
//            }
//            if(dir == RIGHT){
//                dx = 1;
//            }
                switch (dir) {
                case UP -> dy = -1;
                case DOWN -> dy = 1;
                case LEFT -> dx = -1;
                case RIGHT -> dx = 1;
            }

//            switch (dir){
//                case UP:
//                    dy = -1;
//                    break;
//                case DOWN:
//                    dy = 1;
//                    break;
//                case LEFT:
//                    dx = -1;
//                    break;
//                case RIGHT:
//                    dx = 1;
//                    break;
//        }
        return new Pair(dx, dy);
    }

    /**
     * Converts character to direction
     * @param ch character
     * @return direction
     */
    public static Direction convertCharacterToDirection(char ch) {

//        if(ch == 'U'){
//            return UP;
//        }
//        if(ch == 'D'){
//            return DOWN;
//        }
//        if(ch == 'L'){
//            return LEFT;
//        }
//        if(ch == 'R'){
//            return RIGHT;
//        }
//
//        return UNKNOWN;



        return switch(ch) {
            case 'U' -> UP;
            case 'D' -> DOWN;
            case 'L' -> LEFT;
            case 'R' -> RIGHT;
            default -> UNKNOWN;
        };


    }
}

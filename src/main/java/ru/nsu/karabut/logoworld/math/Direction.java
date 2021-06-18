package ru.nsu.karabut.logoworld.math;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UNKNOWN(0, 0);

    public int dx;
    public int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Converts character to direction
     * @param ch character
     * @return direction
     */
    public static Direction fromSymbol(char ch) {
        return switch(ch) {
            case 'U' -> UP;
            case 'D' -> DOWN;
            case 'L' -> LEFT;
            case 'R' -> RIGHT;
            default -> UNKNOWN;
        };
    }
}

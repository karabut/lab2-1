package ru.nsu.karabut.logoworld.logic;

import ru.nsu.karabut.logoworld.math.Direction;
import ru.nsu.karabut.logoworld.math.Pair;

public class Mover {
    private int x;
    private int y;
    private boolean isDrawing;

    /**
     * Create turtle
     */
    public Mover() {
        this.isDrawing = false;
    }

    /**
     * Check if turtle is currently drawing
     *
     * @return true if turtle is drawing
     */
    public boolean getIsDrawing() {
        return isDrawing;
    }

    /**
     * Set drawing state of turtle
     *
     * @param isDrawing new drawing state
     */
    public void setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

    /**
     * Set turtle position
     *
     * @param x x-position
     * @param y y-position
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move turtle in direction
     *
     * @param dir direction
     */
    public void move(Direction dir) {
        this.x += dir.dx;
        this.y += dir.dy;
    }

    /**
     * Get turtle position
     *
     * @return (x, y) - turtle position
     */
    public Pair getPosition() {
        return new Pair(x, y);
    }
}

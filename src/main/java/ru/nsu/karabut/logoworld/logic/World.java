package ru.nsu.karabut.logoworld.logic;

import org.apache.log4j.Logger;
import ru.nsu.karabut.logoworld.math.Direction;
import ru.nsu.karabut.logoworld.math.Pair;

public class World {
    private static final Logger logger = Logger.getLogger(World.class);

    private final Mover mover;
    private final Field field;

    /**
     * Create world, which contains field and turtle
     */
    public World() {
        logger.debug("World initialization.");
        this.field = new Field();
        this.mover = new Mover();
    }

    /**
     * Init world parameters.
     *
     * @param width  Field width
     * @param height Field height
     * @param x      Turtle x-position
     * @param y      Turtle y-position
     */
    public void initWorld(int width, int height, int x, int y) {
        logger.debug("Initializing world parameters: " + width + " " + height + " " + x + " " + y);
        field.setSize(width, height);
        mover.setPosition(x, y);
    }

    /**
     * Check if turtle is currently drawing
     *
     * @return true if turtle is drawing
     * @see World#setIsTurtleDrawing(boolean)
     */
    public boolean getIsTurtleDrawing() {
        return mover.getIsDrawing();
    }

    /**
     * Set turtle drawing state
     *
     * @param isDrawing whether turtle should draw or not
     * @see World#getIsTurtleDrawing() (boolean)
     */
    public void setIsTurtleDrawing(boolean isDrawing) {
        logger.debug("Switch turtle drawing mode");
        mover.setIsDrawing(isDrawing);
        update();
    }

    /**
     * Set new position of turtle
     *
     * @param x x-position
     * @param y y-position
     */
    public void setTurtlePosition(int x, int y) {
        logger.debug("Set turtle position: " + x + " " + y);
        mover.setPosition(x, y);
        update();
    }

    /**
     * Move turtle in direction
     *
     * @param dir direction
     */
    public void moveTurtle(Direction dir) {
        logger.debug("Move turtle in direction " + dir.toString());
        mover.move(dir);
        update();
    }

    /**
     * Check if world is valid
     *
     * @return true if turtle and field have been initialized
     */
    public boolean isValid() {
        Pair size = field.getSize();
        return (size.getFirst() != 0 && size.getSecond() != 0);
    }

    /**
     * Get turtle position
     *
     * @return (x, y) - turtle position
     */
    public Pair getTurtlePosition() {
        return mover.getPosition();
    }

    /**
     * Get field size
     *
     * @return (width, height) - field size
     */
    public Pair getFieldSize() {
        return field.getSize();
    }

    /**
     * Check if cell with given coordinates is drawn by turtle
     *
     * @param x x-position
     * @param y y-position
     * @return true if cell is drawn
     */
    public boolean isCellDrawn(int x, int y) {
        return field.isDrawn(x, y);
    }

    private void update() {
        Pair pos = mover.getPosition();
        Pair size = field.getSize();
        int x = pos.getFirst(), y = pos.getSecond();

        while (y < 0) y += size.getSecond();
        while (y >= size.getSecond()) y -= size.getSecond();

        while (x < 0) x += size.getFirst();
        while (x >= size.getFirst()) x -= size.getFirst();

        mover.setPosition(x, y);

        if (mover.getIsDrawing()) {
            field.setDrawn(x, y, true);
        }
    }
}

package ru.nsu.karabut.logoworld.commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.karabut.logoworld.logic.World;

class DrawTest {

    @Test
    void validateArgs() {
        Draw draw;

        World world1 = new World();
        world1.initWorld(10, 10, 2, 2);
        draw = new Draw(null, world1);
        assertTrue(draw.checkArgs(new String[]{}));
        assertFalse(draw.checkArgs(new String[]{"Arg0"}));

        World world2 = new World();
        draw = new Draw(null, world2);
        assertFalse(draw.checkArgs(new String[]{}));
        assertFalse(draw.checkArgs(new String[]{"Arg0"}));
    }
}
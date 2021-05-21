package ru.nsu.karabut.logoworld.commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.karabut.logoworld.logic.World;

class MoveTest {

    @Test
    void validateArgs() {
        Move move;

        World world1 = new World();
        world1.initWorld(10, 10, 2, 2);
        move = new Move(null, world1);
        assertFalse(move.checkArgs(new String[]{}));
        assertFalse(move.checkArgs(new String[]{"U"}));
        assertTrue(move.checkArgs(new String[]{"U", "10"}));
        assertFalse(move.checkArgs(new String[]{"Z", "10"}));
        assertFalse(move.checkArgs(new String[]{"R", "-1"}));
        assertFalse(move.checkArgs(new String[]{"D", "0"}));

        World world2 = new World();
        move = new Move(null, world2);
        assertFalse(move.checkArgs(new String[]{"U", "10"}));
    }
}
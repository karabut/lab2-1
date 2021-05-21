package ru.nsu.karabut.logoworld.commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.karabut.logoworld.logic.World;

class JumpTest {

    @Test
    void validateArgs() {
        Jump jump;

        World world1 = new World();
        world1.initWorld(10, 10, 2, 2);
        jump = new Jump(null, world1);
        assertFalse(jump.checkArgs(new String[]{}));
        assertTrue(jump.checkArgs(new String[]{"(POS_X <= 2 and POS_Y >= 2 and not IS_DRAWING)", "1"}));
        assertFalse(jump.checkArgs(new String[]{"(POSX <= 2 and POSY >= 2 and not ISDRAWING)", "1"}));
        assertTrue(jump.checkArgs(new String[]{"(FIELD_WIDTH <= 2 and FIELD_HEIGHT >= 2 and IS_DRAWING)", "1"}));
    }
}
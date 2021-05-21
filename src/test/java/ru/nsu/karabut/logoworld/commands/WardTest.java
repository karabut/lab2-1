package ru.nsu.karabut.logoworld.commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.karabut.logoworld.logic.World;

class WardTest {

    @Test
    void validateArgs() {
        Ward ward;

        World world1 = new World();
        world1.initWorld(10, 10, 2, 2);
        ward = new Ward(null, world1);
        assertTrue(ward.checkArgs(new String[]{}));
        assertFalse(ward.checkArgs(new String[]{"Arg0"}));

        World world2 = new World();
        ward = new Ward(null, world2);
        assertFalse(ward.checkArgs(new String[]{}));
        assertFalse(ward.checkArgs(new String[]{"Arg0"}));
    }
}
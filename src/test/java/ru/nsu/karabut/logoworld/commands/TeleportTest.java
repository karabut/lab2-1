package ru.nsu.karabut.logoworld.commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.karabut.logoworld.logic.World;

class TeleportTest {

    @Test
    void validateArgs() {
        Teleport tpCommand;

        World world1 = new World();
        world1.initWorld(10, 10, 2, 2);
        tpCommand = new Teleport(null, world1);
        assertFalse(tpCommand.checkArgs(new String[]{}));
        assertFalse(tpCommand.checkArgs(new String[]{"5"}));
        assertTrue(tpCommand.checkArgs(new String[]{"5", "5"}));
        assertFalse(tpCommand.checkArgs(new String[]{"11", "11"}));
        assertFalse(tpCommand.checkArgs(new String[]{"5", "5", "5"}));
        assertFalse(tpCommand.checkArgs(new String[]{"sdf", "fsdg"}));

        World world2 = new World();
        tpCommand = new Teleport(null, world2);
        assertFalse(tpCommand.checkArgs(new String[]{"5", "5"}));
    }
}
package ru.nsu.karabut.logoworld.commands;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.nsu.karabut.logoworld.logic.World;

class CommandInitializerTest {

    @Test
    void validateArgs() {
        CommandInitializer commandInitializer;

        World world = new World();
        commandInitializer = new CommandInitializer(null, world);
        assertTrue(commandInitializer.checkArgs(new String[]{"10", "10", "2", "2"}));
        assertFalse(commandInitializer.checkArgs(new String[]{}));
        assertFalse(commandInitializer.checkArgs(new String[]{"10", "10"}));
        assertFalse(commandInitializer.checkArgs(new String[]{"10", "10", "-1", "-1"}));
        assertFalse(commandInitializer.checkArgs(new String[]{"-1", "-1", "0", "0"}));
        assertFalse(commandInitializer.checkArgs(new String[]{"10", "10", "11", "11"}));
    }
}
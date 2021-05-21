package ru.nsu.karabut.logoworld.commands;

import ru.nsu.karabut.logoworld.input.Input;
import ru.nsu.karabut.logoworld.logic.World;

public class Ward implements Command {
    private final World world;
    private final Input input;

    public Ward(Input input, World world) {
        this.input = input;
        this.world = world;
    }

    @Override
    public boolean checkArgs(String[] args) {
        if (args.length != 0) {
            CommandError.setError("Use WARD without any arguments.");
            return false;
        }
        if (!world.isValid()) {
            CommandError.setError("You have to use {INIT <width> <height> <x> <y>} first!");
            return false;
        }
        return true;
    }

    @Override
    public boolean run(String[] args) {
        if (!world.getIsTurtleDrawing() || !world.isValid()) {
            if (input.allowJump()) {
                input.setNextCommand(null);
            }
            return false;
        }
        world.setIsTurtleDrawing(false);
        return true;
    }
}

package ru.nsu.karabut.logoworld.commands;

public interface Command {
    /**
     * Validates arguments of command
     *
     * @param args arguments of command
     * @return true if arguments are valid
     */
    boolean checkArgs(String[] args);

    /**
     * Executes command
     *
     * @param args arguments of command
     * @return true if command was executed successfully
     */
    boolean run(String[] args);
}

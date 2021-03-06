package ru.nsu.karabut.logoworld.logic;

import ru.nsu.karabut.logoworld.commands.Command;
import ru.nsu.karabut.logoworld.commands.CommandFactory;
import ru.nsu.karabut.logoworld.exceptions.CommandFactoryException;
import ru.nsu.karabut.logoworld.exceptions.InvalidInputException;
import ru.nsu.karabut.logoworld.input.Console;
import ru.nsu.karabut.logoworld.input.Input;
import ru.nsu.karabut.logoworld.input.Program;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interp {
    private static final Logger logger = Logger.getLogger(Interp.class);

    private String curCmd = "";
    private String[] curArgs = null;
    private final Input input;
    private final CommandFactory commandFactory;

    /**
     * Creates commands interpreter
     *
     * @throws IOException if commands-properties file or program file are not found or invalid
     */
    public Interp(String programFileName, World world) throws IOException {
        logger.debug("Interpreter initialization.");

        if (programFileName == null) {
            this.input = new Console();
        }
        else {
            this.input = new Program(programFileName);
        }
        this.commandFactory = new CommandFactory(input, world);
    }

    /**
     * Parses next command and its arguments.
     *
     * @return true if command is parsed successfully and is valid.
     * @throws CommandFactoryException if command factory fails
     * @see Interp#step()
     */
    public boolean parseNextCommand() throws CommandFactoryException, InvalidInputException {
        String command = input.nextCommand();
        logger.debug("Interpreter parsing command: " + command);
        String[] cmd = command == null ? null : tokenizeCommand(command);
        boolean validArgs;

        if (cmd == null || cmd.length == 0 || command.equals("") || command.equals("EXIT")) {
            curArgs = null;
            curCmd = "";
            validArgs = true;
        }
        else {
            curCmd = cmd[0];
            curArgs = Arrays.copyOfRange(cmd, 1, cmd.length);
            Command instance = commandFactory.getCommand(curCmd);
            if (instance != null) {
                validArgs = instance.checkArgs(curArgs);
            }
            else {
                validArgs = false;
            }
        }
        logger.debug("Result of parsing: " + validArgs);
        return validArgs;
    }

    /**
     * Steps through the command execution.
     * Needs to parse command first
     *
     * @return true if stepped successfully
     * @throws CommandFactoryException if commands factory fails
     * @see Interp#parseNextCommand()
     */
    public boolean step() throws CommandFactoryException {
        if (curCmd.equals("")) {
            logger.debug("Empty command. Skipping...");
            if (input.allowJump()) input.setNextCommand(null);
            return false;
        }

        logger.debug("Stepping through command...");
        Command instance = commandFactory.getCommand(curCmd);
        if (instance != null) {
            return instance.run(curArgs);
        }
        else return false;
    }

    /**
     * Check if interpreter finished running program
     *
     * @return true if finished
     */
    public boolean isFinished() {
        return input.isFinished();
    }

    /**
     * If you run program and encounter invalid command, you will be prompted to stop running.
     *
     * @return true if you are running program
     */
    public boolean shouldAskForContinuation() {
        return input instanceof Program;
    }

    private String[] tokenizeCommand(String command) {
        List<String> list = new ArrayList<>();

        char[] characters = command.toCharArray();
        int bracketBalance = 0;
        StringBuilder curToken = new StringBuilder();

        for (char ch : characters) {
            if (ch == ' ') {
                if (bracketBalance == 0) {
                    if (curToken.length() != 0) {
                        list.add(curToken.toString());
                    }
                    curToken.setLength(0);
                    continue;
                }
            }
            if (ch == '(') bracketBalance++;
            else if (ch == ')') bracketBalance--;
            curToken.append(ch);
        }

        if (curToken.length() != 0) {
            list.add(curToken.toString());
        }
        curToken.setLength(0);

        return list.toArray(new String[0]);
    }
}

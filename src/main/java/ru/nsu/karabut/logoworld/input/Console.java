package ru.nsu.karabut.logoworld.input;

import org.apache.log4j.Logger;
import ru.nsu.karabut.logoworld.exceptions.InvalidInputException;

import java.util.Scanner;

public class Console implements Input {
    private static final Logger logger = Logger.getLogger(Console.class);

    private final Scanner scanner;
    private String prevCommand;

    /**
     * Initialize input from console
     */
    public Console() {
        logger.debug("Console Input initialized.");
        scanner = new Scanner(System.in);
        prevCommand = "";
    }

    @Override
    public boolean isFinished() {
        return prevCommand != null && prevCommand.equals("EXIT");
    }

    @Override
    public boolean allowJump() {
        return false;
    }

    @Override
    public String nextCommand() throws InvalidInputException {
        if (prevCommand.equals("EXIT")) {
            throw new InvalidInputException("");
        }
        prevCommand = scanner.nextLine().trim();
        return prevCommand;
    }

    @Override
    public void setNextCommand(Integer nextCommand) {
    }
}

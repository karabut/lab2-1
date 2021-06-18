package ru.nsu.karabut.logoworld;

import org.apache.log4j.Logger;
import ru.nsu.karabut.logoworld.commands.CommandError;
import ru.nsu.karabut.logoworld.drawing.ConsoleView;
import ru.nsu.karabut.logoworld.exceptions.CommandFactoryException;
import ru.nsu.karabut.logoworld.exceptions.InvalidInputException;
import ru.nsu.karabut.logoworld.exceptions.RenderException;
import ru.nsu.karabut.logoworld.logic.Interp;
import ru.nsu.karabut.logoworld.logic.World;

import java.io.IOException;

public class LogoWorld {

    private static final Logger logger = Logger.getLogger(LogoWorld.class);

    private final World world;
    private final ConsoleView graphicsView;
    private final Interp interp;

    /**
     * Create Logo World instance.
     *
     * @param programFileName Program to run. Use <b>null</b> if you want to type commands manually.
     * @throws IOException     If program file, commands-properties file are missing
     * @throws RenderException If console uses wrong sizes of textures
     */
    public LogoWorld(String programFileName) throws IOException, RenderException {
        logger.debug("Logo World initialization...");

        world = new World();
        interp = new Interp(programFileName, world);
        graphicsView = new ConsoleView();
    }

    /**
     * Run Logo World
     *
     * @throws CommandFactoryException If command factory fails
     * @throws RenderException         If rendering fails
     * @throws RuntimeException        Other related issues
     */
    public void run() throws CommandFactoryException, RenderException, RuntimeException {
        try {
            while (!interp.isFinished()) {
                if (interp.parseNextCommand()) {
                    while (interp.step()) {
                        graphicsView.render(world);
                        try {
                            Thread.sleep(300);
                        }
                        catch (Exception e) {
                            throw new RuntimeException(e.getLocalizedMessage());
                        }
                    }
                }
                else {
                    String error = CommandError.getError();
                    logger.debug(error);
                    graphicsView.writeInformation(error);
                    if (interp.shouldAskForContinuation() && !graphicsView.getContinuationSignal()) {
                        break;
                    }
                }
            }
        }
        catch (InvalidInputException e) {
            logger.debug("Invalid input. Shutting down...");
            graphicsView.writeInformation("Invalid input. Shutting down...");
        }
    }
}
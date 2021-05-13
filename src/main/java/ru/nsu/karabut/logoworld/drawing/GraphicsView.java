package ru.nsu.karabut.logoworld.drawing;

import ru.nsu.karabut.logoworld.exceptions.RenderException;
import ru.nsu.karabut.logoworld.logic.World;

public interface GraphicsView {
    void writeInformation(String info);
    boolean getContinuationSignal();

    void render(World world) throws RenderException;
}

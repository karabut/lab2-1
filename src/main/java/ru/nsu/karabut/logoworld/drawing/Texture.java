package ru.nsu.karabut.logoworld.drawing;

import ru.nsu.karabut.logoworld.exceptions.RenderException;

public class Texture {
    private final int size;
    private final String texture;

    /**
     * Creates texture with given {@code String} representation.
     * @param texture string representation of texture
     * @throws RenderException if texture string length was not a square of integer number
     */
    public Texture(String texture) throws RenderException {
        this.texture = texture;
        this.size = (int) Math.sqrt(texture.length());
        if (this.size * this.size != texture.length()) {
            throw new RenderException("Texture size was not a square of integer number");
        }
    }

    /**
     * Gets pixel as char
     * @param x x-position of texture
     * @param y y-position of texture
     * @return String representation of pixel with color
     */
    public String getPixel(int x, int y) {
        return this.texture.charAt(y * size + x) + "";
    }

    /**
     * Gets size of texture, a square root of string length
     * @return size of texture
     */
    public int getSize() {
        return size;
    }
}

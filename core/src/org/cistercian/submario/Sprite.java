package org.cistercian.submario;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Sprite {
    protected Rectangle rect;
    protected Texture texture;

    public Sprite(Texture spriteImage) {
        this(spriteImage, 0, 0);
    }

    public Sprite(Texture spriteImage, float x, float y) {
        rect = new Rectangle();
        texture = spriteImage;
        rect.x = x;
        rect.y = y;
        rect.width = texture.getWidth();
        rect.height = texture.getHeight();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rect.x, rect.y);
    }

    public void setCenter(float centerX, float centerY) {
        rect.setCenter(centerX, centerY);
    }

    public void setLeft(float left) {
        rect.x = left;
    }

    public float getLeft() {
        return rect.x;
    }

    public void setRight(float right) {
        rect.x = right - rect.width;
    }

    public float getRight() {
        return rect.x + rect.width;
    }

    public void setTop(float top) {
        rect.y = top - rect.height;
    }

    public float getTop() {
        return rect.y + rect.height;
    }

    public void setBottom(float bottom) {
        rect.y = bottom;
    }

    public float getBottom() {
        return rect.y;
    }

    public boolean checkCollision(Sprite other) {
        return rect.overlaps(other.rect);
    }
}

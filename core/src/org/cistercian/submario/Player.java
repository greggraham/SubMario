package org.cistercian.submario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private final float speed = 100; // pixels per second
    private float deltaX, deltaY;
    private Rectangle rect;
    private Texture texture;

    public Player(Texture playerImage) {
        texture = playerImage;
        rect = new Rectangle();
        rect.x = 0;
        rect.y = 0;
        rect.width = texture.getWidth();
        rect.height = texture.getHeight();
        stopMotion();
    }

    public InputProcessor getInputAdapter() {
        return (new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Input.Keys.LEFT:
                        deltaX = -speed;
                        break;
                    case Input.Keys.RIGHT:
                        deltaX = speed;
                        break;
                    case Input.Keys.UP:
                        deltaY = speed;
                        break;
                    case Input.Keys.DOWN:
                        deltaY = -speed;
                        break;
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                switch (keycode) {
                    case Input.Keys.LEFT:
                    case Input.Keys.RIGHT:
                        deltaX = 0;
                        break;
                    case Input.Keys.UP:
                    case Input.Keys.DOWN:
                        deltaY = 0;
                        break;
                }
                return true;
            }
        });
    }

    public void move() {
        rect.x += deltaX * Gdx.graphics.getDeltaTime();
        rect.y += deltaY * Gdx.graphics.getDeltaTime();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rect.x, rect.y);
    }

    private void stopMotion() {
        deltaX = 0;
        deltaY = 0;
    }
}

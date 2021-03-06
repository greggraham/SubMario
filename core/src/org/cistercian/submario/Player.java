package org.cistercian.submario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Player extends Sprite {
    private final static float MOVE_SPEED = 150; // pixels per second
    private final static float JUMP_SPEED = 580; // pixels per second
    private final static float GRAVITY = 1000; // pixels per second per second
    private float deltaX, deltaY;
    private Map gameMap;

    public Player(Texture playerImage, Map gameMap) {
        this(playerImage, gameMap, 0, 0);
    }

    public Player(Texture playerImage, Map gameMap, float x, float y) {
        super(playerImage, x, y);
        this.gameMap = gameMap;
        stopMotion();
    }

    public InputProcessor getInputAdapter() {
        return (new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Input.Keys.LEFT:
                        deltaX = -MOVE_SPEED;
                        break;
                    case Input.Keys.RIGHT:
                        deltaX = MOVE_SPEED;
                        break;
                    case Input.Keys.UP:
                        System.out.println("up");
                        if (isOnPlatform()) {
                            System.out.println("jump");
                            deltaY = JUMP_SPEED;
                        }
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
                }
                return true;
            }
        });
    }

    public void move() {
        // Vertical motion
        deltaY -= GRAVITY * Gdx.graphics.getDeltaTime();
        rect.y += deltaY * Gdx.graphics.getDeltaTime();
        List<Sprite> collisions = gameMap.checkPlatformCollision(this);
        if (collisions.size() > 0) {
            Sprite p = collisions.get(0);
            if (deltaY < 0) {  // going down
                setBottom(p.getTop());
            } else { // going up
                setTop(p.getBottom());
            }
            deltaY = 0;
        }

        // Horizontal motion
        rect.x += deltaX * Gdx.graphics.getDeltaTime();
        collisions = gameMap.checkPlatformCollision(this);
        if (collisions.size() > 0) {
            Sprite p = collisions.get(0);
            if (deltaX < 0) {  // going left
                setLeft(p.getRight());
            } else { // going right
                setRight(p.getLeft());
            }
        }
    }

    private void stopMotion() {
        deltaX = 0;
        deltaY = 0;
    }

    private boolean isOnPlatform() {
        rect.y -= 5;
        List<Sprite> collisions = gameMap.checkPlatformCollision(this);
        rect.y += 5;
        return collisions.size() > 0;
    }
}

package org.cistercian.submario;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class Player {

    public InputProcessor getInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {

                }
                return true;
            }

        };
    }
}

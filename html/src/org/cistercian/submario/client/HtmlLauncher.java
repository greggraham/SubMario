package org.cistercian.submario.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import org.cistercian.submario.SubMarioGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                // Resizable application, uses available space in browser
                // return new GwtApplicationConfiguration(true);
                // Fixed size application:
                return new GwtApplicationConfiguration(SubMarioGame.WIDTH, SubMarioGame.HEIGHT);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new SubMarioGame();
        }
}
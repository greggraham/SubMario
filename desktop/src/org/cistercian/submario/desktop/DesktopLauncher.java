package org.cistercian.submario.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.cistercian.submario.SubMarioGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SubMario";
		config.width = SubMarioGame.WIDTH;
		config.height = SubMarioGame.HEIGHT;
		new LwjglApplication(new SubMarioGame(), config);
	}
}

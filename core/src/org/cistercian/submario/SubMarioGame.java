package org.cistercian.submario;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SubMarioGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture crateImg;
	Texture playerImg;

	@Override
	public void create () {
		// load images

		batch = new SpriteBatch();
		crateImg = new Texture("crate.png");
		playerImg = new Texture("player.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(playerImg, 0, 0);
		batch.draw(crateImg, 100, 100);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		crateImg.dispose();
		playerImg.dispose();
	}
}

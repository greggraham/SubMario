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
	Player player;

	@Override
	public void create () {
		batch = new SpriteBatch();

		// load images
		crateImg = new Texture("crate.png");
		playerImg = new Texture("player.png");

		// create player
		player = new Player(playerImg);
		Gdx.input.setInputProcessor(player.getInputAdapter());
	}

	@Override
	public void render () {
		player.move();
		Gdx.gl.glClearColor(0.1f, 0.3f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(crateImg, 300, 0);
		player.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		crateImg.dispose();
		playerImg.dispose();
	}
}

package org.cistercian.submario;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SubMarioGame extends ApplicationAdapter {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	SpriteBatch batch;
	Texture crateImg;
	Texture snowImg;
	Texture redBrickImg;
	Texture brownBrickImg;
	Texture playerImg;
	Player player;
	Map gameMap = new Map();

	@Override
	public void create () {
		batch = new SpriteBatch();

		// load images
		crateImg = new Texture("crate.png");
		snowImg = new Texture("snow.png");
		redBrickImg = new Texture("red_brick.png");
		brownBrickImg = new Texture("brown_brick.png");
		playerImg = new Texture("player.png");

		// load map
		gameMap.load("map.csv", new Texture[]{redBrickImg, snowImg, brownBrickImg, crateImg});

		// create player
		player = new Player(playerImg, gameMap, 200, 50);
		Gdx.input.setInputProcessor(player.getInputAdapter());
	}

	@Override
	public void render () {
		// Moving
		player.move();

		// Drawing
		Gdx.gl.glClearColor(0.1f, 0.3f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		player.draw(batch);
		gameMap.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		crateImg.dispose();
		playerImg.dispose();
	}
}

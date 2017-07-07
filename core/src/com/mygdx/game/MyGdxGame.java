package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	final static int SCREEN_H = 720;
	final static int SCREEN_W = 1280;
	SpriteBatch batch;
	Texture img;
	Ship hero;
	Asteroid asteroid;
	Asteroid asteroid2;

	@Override
	public void create () {
		batch = new SpriteBatch();
		hero = new Ship(new Texture("hero.png"),new Vector2(0f,0f),new Vector2(0,0));
		asteroid = new Asteroid(new Texture("asteroid.png"),new Vector2(0f,0f),new Vector2(0,0));
		asteroid2 = new Asteroid(new Texture("bullet.png"),new Vector2(0f,0f),new Vector2(0,0));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();
		batch.begin();
		asteroid.render(batch);
		hero.render(batch);
		asteroid2.render(batch);
		batch.end();
	}

	public void update(){
		asteroid.update(Gdx.graphics.getDeltaTime());
		hero.update(Gdx.graphics.getDeltaTime());
	}


	@Override
	public void dispose () {
		batch.dispose();
	}
}

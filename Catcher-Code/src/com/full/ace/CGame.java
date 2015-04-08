package com.full.ace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CGame extends Game {
	private static final String TITLE = "Catcher";
	private static final float VERSION = 0.2f;
	private static final int VERSION_NUMBER = 2;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera=new OrthographicCamera();
		this.setScreen(new Splash(this));
	}

	@Override
	public void render () {
		super.render();
		
	}
}
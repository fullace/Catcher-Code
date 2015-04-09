package com.full.ace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Catcher extends Game {
	private static final String TITLE = "Catcher";
	private static final float VERSION = 0.5f;
	private static final int VERSION_NUMBER = 5;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public static float SCREEN_WIDTH;
	public static float SCREEN_HEIGHT;
	public Texture Ball;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera=new OrthographicCamera();
		SCREEN_WIDTH=Gdx.graphics.getWidth() / 800;
		SCREEN_HEIGHT=Gdx.graphics.getHeight() / 480;
		Preferences ball = Gdx.app.getPreferences("ball");
		Ball=new Texture(Gdx.files.internal(ball.getString("player","silver.png")));
		this.setScreen(new Splash(this));
	}

	@Override
	public void render () {
		super.render();
		
	}
	
	public boolean InBounds(int x,int y,float up,float down,float left,float right){
		if(y > up && y < down && x > left && x < right){
			return true;
		}
		else{
			return false;
		}
	}
}

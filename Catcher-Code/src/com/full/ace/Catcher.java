package com.full.ace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Catcher extends Game {
	private static final String TITLE = "Catcher";
	private static final float VERSION = 0.9f;
	private static final int VERSION_NUMBER = 11;
	public SpriteBatch batch;
	public BitmapFont writer;
	public OrthographicCamera camera;
	public static float SCREEN_WIDTH;
	public static float SCREEN_HEIGHT;
	public Texture Ball;
	public int scoreNormal;
	public int scoreSurvival;
	public int scoreRandom;
	public boolean blue,green,red,orange,cyan,pink,black,white,yellow;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		writer  = new BitmapFont(Gdx.files.internal("catcher.fnt"));
		camera=new OrthographicCamera();
		SCREEN_WIDTH=Gdx.graphics.getWidth() / 800;
		SCREEN_HEIGHT=Gdx.graphics.getHeight() / 480;
		//Preferences
		Preferences ball = Gdx.app.getPreferences("ball");
		//prefs high scores
		Preferences HighScore = Gdx.app.getPreferences("highscore");
		//prefs balls
		Preferences balls = Gdx.app.getPreferences("balls");
		//prefs for Texture
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

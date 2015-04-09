package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class Loader implements Screen {
	final Catcher game;
	//menus
	public static Texture MainMenu,HighScore,Shop,ShopLock;
	//Ingame Textures
	public static Texture GameBackground;
	//different coloured balls
	public static Texture Silver,Cyan;
	
	public Loader(final Catcher game){
		this.game=game;
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		MainMenu  = new Texture(Gdx.files.internal("MainMenu.png"));
		HighScore = new Texture(Gdx.files.internal("HighScore.png"));
		Shop      = new Texture(Gdx.files.internal("Shop.png"));
		ShopLock  = new Texture(Gdx.files.internal("ShopLock.png"));
		
		GameBackground = new Texture(Gdx.files.internal("GameBackground.png"));
		
		Silver = new Texture(Gdx.files.internal("silver.png"));
		Cyan   = new Texture(Gdx.files.internal("cyan.png"));
		
		game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

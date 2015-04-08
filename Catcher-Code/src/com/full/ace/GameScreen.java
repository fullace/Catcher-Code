package com.full.ace;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	
	final CGame game;
	
	public GameScreen(final CGame game){
		this.game=game;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
	game.batch.begin();
	game.batch.draw(Loader.GameBackground,0,0);
	game.batch.end();
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

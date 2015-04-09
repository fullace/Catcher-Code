package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputProcessorMainMenu implements InputProcessor {
	
	final Catcher game;
	private float SCREEN_HEIGHT=Gdx.graphics.getHeight() / 480;
	private float SCREEN_WIDTH=Gdx.graphics.getWidth() / 800;

	public InputProcessorMainMenu(final Catcher game){
		this.game=game;
		game.camera.setToOrtho(false,800,480);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(game.InBounds(screenX, screenY,170 * SCREEN_HEIGHT, 290 * SCREEN_HEIGHT,670 * SCREEN_WIDTH, 790 * SCREEN_WIDTH )){
			game.setScreen(new HighScoreScreen(game) );
		}
		if(game.InBounds(screenX, screenY,25 * SCREEN_HEIGHT, 145 * SCREEN_HEIGHT,625 * SCREEN_WIDTH, 750 * SCREEN_WIDTH)){
			
			game.setScreen(new ShopScreen(game));
		}
		if(game.InBounds(screenX, screenY, 30 * SCREEN_HEIGHT, 155 * SCREEN_HEIGHT, 25 * SCREEN_WIDTH, 450 * SCREEN_WIDTH)){
			game.setScreen(new GameScreen(game,1));
		}
		if(game.InBounds(screenX, screenY, 180 * SCREEN_HEIGHT, 310 * SCREEN_HEIGHT, 100 * SCREEN_WIDTH, 525 * SCREEN_WIDTH)){
			game.setScreen(new GameScreen(game,2));
		}
		if(game.InBounds(screenX, screenY, 340 * SCREEN_HEIGHT, 460 * SCREEN_HEIGHT, 170 * SCREEN_WIDTH, 600 * SCREEN_WIDTH)){
			game.setScreen(new GameScreen(game,3));
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}

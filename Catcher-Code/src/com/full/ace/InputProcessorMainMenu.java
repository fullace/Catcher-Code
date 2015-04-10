package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;

public class InputProcessorMainMenu implements InputProcessor {
	
	final Catcher game;

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
		if(game.InBounds(screenX, screenY,170 * game.h, 290 * game.h,670 * game.w, 790 * game.w )){
			game.setScreen(new HighScoreScreen(game) );
		}
		if(game.InBounds(screenX, screenY,25 * game.h, 145 * game.h,625 * game.h, 750 * game.h)){
			
			game.setScreen(new ShopScreen(game));
		}
		if(game.InBounds(screenX, screenY, 30 * game.h, 155 * game.h, 25 * game.w, 450 * game.w)){
			game.setScreen(new GameScreen(game,1));
		}
		if(game.InBounds(screenX, screenY, 180 * game.h, 310 * game.h, 100 * game.w, 525 * game.w)){
			game.setScreen(new GameScreen(game,2));
		}
		if(game.InBounds(screenX, screenY, 340 * game.h, 460 * game.h, 170 * game.w, 600 * game.w)){
			game.setScreen(new GameScreen(game,3));
		}
		if(game.InBounds(screenX, screenY, 320*game.h, 440*game.h, 625*game.w,745*game.w )){
			Gdx.app.exit();
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

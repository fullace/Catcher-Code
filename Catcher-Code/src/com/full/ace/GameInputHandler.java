package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.full.ace.GameWorld.GameState;

public class GameInputHandler implements InputProcessor{
	
	final Catcher game;
	private GameWorld world;
	private float w;
	private float h;
	private float screenh;
	private float screenw;
	
	public GameInputHandler(final Catcher game,GameWorld world){
		this.game=game;
		this.world=world;
		game.camera.setToOrtho(false,800,480);
		screenh=Gdx.graphics.getHeight();
		screenw=Gdx.graphics.getWidth();
		w=screenw/800;
		h=screenh/480;
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
		if(world.state==GameState.Ready){
			world.player.setTravelling();
		}
		if(world.state==world.state.Running){
    		int x=screenX;
    		int y=screenY;
    		if(game.InBounds(x, y, 0, 100 * h, 0, 100 * w)){    
    			world.player.moveToUpperLeft();
    		}
    		else if(game.InBounds(x,y,0,100 * h,700 * w,800 * w)){
    			world.player.moveToUpperRight();
    		}
    		else if(game.InBounds(x,y,380 * h,480 * h,0,100 * w)){
    			world.player.moveToBottomLeft();
    		}
    		else if(game.InBounds(x,y,380 * h,480 * h,700 * w,800 * w)){
    			world.player.moveToBottomRight();
    		}
    		else world.player.stopMoving(); 
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

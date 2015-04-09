package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;

public class InputHandlerShop implements InputProcessor {
	
	final Catcher game;
	Preferences ball;
	Preferences balls;
	
	public InputHandlerShop(final Catcher game){
		this.game=game;
	    ball = Gdx.app.getPreferences("ball");
	    balls = Gdx.app.getPreferences("balls");
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
		if(game.InBounds(screenX, screenY, 150 * game.SCREEN_HEIGHT, 230 * game.SCREEN_HEIGHT, 250 * game.SCREEN_WIDTH,330 * game.SCREEN_WIDTH)){
			game.Ball=Loader.Silver;
			ball.putString("player","silver.png");
		}
		if(game.InBounds(screenX, screenY, 150 * game.SCREEN_HEIGHT, 230 * game.SCREEN_HEIGHT, 355 * game.SCREEN_WIDTH, 435 * game.SCREEN_WIDTH)){
			boolean blue = balls.getBoolean("blue",false);
			if(blue==true){
				game.Ball=Loader.Blue;
				ball.putString("player","blue.png");
			}
		}
		if(game.InBounds(screenX, screenY, 150 * game.SCREEN_HEIGHT,230 * game.SCREEN_HEIGHT, 455 * game.SCREEN_WIDTH, 535 * game.SCREEN_WIDTH )){
			boolean green = balls.getBoolean("green",false);
			if(green==true){
				game.Ball=Loader.Green;
				ball.putString("player", "green.png");
			}
		}
		if(game.InBounds(screenX, screenY, 150 * game.SCREEN_HEIGHT,230 * game.SCREEN_HEIGHT,560 * game.SCREEN_WIDTH, 640 * game.SCREEN_WIDTH)){
			boolean red = balls.getBoolean("red",false);
			if(red==true){
				game.Ball=Loader.Red;
				ball.putString("player", "red.png");
			}
		}
		if(game.InBounds(screenX, screenY, 150 * game.SCREEN_HEIGHT,230 * game.SCREEN_HEIGHT,690 * game.SCREEN_WIDTH,770 * game.SCREEN_WIDTH )){
			boolean orange = balls.getBoolean("orange",false);
			if(orange==true){
				game.Ball=Loader.Orange;
				ball.putString("player", "orange.png");
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.SCREEN_HEIGHT, 380 * game.SCREEN_HEIGHT, 250 * game.SCREEN_WIDTH, 330 * game.SCREEN_WIDTH)){
			boolean cyan = balls.getBoolean("cyan",false);
			if(cyan==true){
				game.Ball=Loader.Cyan;
				ball.putString("player", "cyan.png");
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.SCREEN_HEIGHT,380 * game.SCREEN_HEIGHT, 355 * game.SCREEN_WIDTH,435 * game.SCREEN_WIDTH)){
			boolean pink = balls.getBoolean("pink",false);
			if(pink==true){
				game.Ball=Loader.Pink;
				ball.putString("player", "pink.png");
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.SCREEN_HEIGHT,380 * game.SCREEN_HEIGHT,455 * game.SCREEN_WIDTH,535 * game.SCREEN_WIDTH)){
			boolean black = balls.getBoolean("black",false);
			if(black==true){
				game.Ball=Loader.Black;
				ball.putString("player", "black.png");
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.SCREEN_HEIGHT, 380 * game.SCREEN_HEIGHT, 560 * game.SCREEN_WIDTH,640 * game.SCREEN_WIDTH)){
			boolean white = balls.getBoolean("white",false);
			if(white==true){
				game.Ball=Loader.White;
				ball.putString("player", "white.png");
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.SCREEN_HEIGHT, 380 * game.SCREEN_HEIGHT, 690 * game.SCREEN_WIDTH, 770 * game.SCREEN_WIDTH)){
			boolean yellow = balls.getBoolean("yellow",false);
			if(yellow==true){
				game.Ball=Loader.Yellow;
				ball.putString("player","yellow.png");
			}
		}
		if(game.InBounds(screenX, screenY, 5 * game.SCREEN_HEIGHT,125 * game.SCREEN_HEIGHT,675 * game.SCREEN_WIDTH,795 * game.SCREEN_WIDTH)){
			game.setScreen(new MainMenuScreen(game));
		}
		ball.flush();
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

package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;

public class InputHandlerShop implements InputProcessor {
	
	final Catcher game;
	Preferences ball;
	Preferences balls;
	private ShopScreen shop;
	
	public InputHandlerShop(final Catcher game,ShopScreen shop){
		this.game=game;
	    ball = Gdx.app.getPreferences("ball");
	    balls = Gdx.app.getPreferences("balls");
	    this.shop = shop;
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
		if(game.InBounds(screenX, screenY, 150 * game.h, 230 * game.h, 250 * game.w,330 * game.w)){
			game.Ball=Loader.Silver;
			ball.putString("player","silver.png");
		}
		if(game.InBounds(screenX, screenY, 150 * game.h, 230 * game.h, 355 * game.w, 435 * game.w)){
			boolean blue = balls.getBoolean("blue",false);
			if(blue==true){
				game.Ball=Loader.Blue;
				ball.putString("player","blue.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=1;
			}
		}
		if(game.InBounds(screenX, screenY, 150 * game.h,230 * game.h, 455 * game.h, 535 * game.h )){
			boolean green = balls.getBoolean("green",false);
			if(green==true){
				game.Ball=Loader.Green;
				ball.putString("player", "green.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=2;
			}
		}
		if(game.InBounds(screenX, screenY, 150 * game.h,230 * game.h,560 * game.h, 640 * game.w)){
			boolean red = balls.getBoolean("red",false);
			if(red==true){
				game.Ball=Loader.Red;
				ball.putString("player", "red.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=3;
			}
		}
		if(game.InBounds(screenX, screenY, 150 * game.h,230 * game.h,690 * game.w,770 * game.w )){
			boolean orange = balls.getBoolean("orange",false);
			if(orange==true){
				game.Ball=Loader.Orange;
				ball.putString("player", "orange.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=4;
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.h, 380 * game.h, 250 * game.w, 330 * game.w)){
			boolean cyan = balls.getBoolean("cyan",false);
			if(cyan==true){
				game.Ball=Loader.Cyan;
				ball.putString("player", "cyan.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=5;
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.h,380 * game.h, 355 * game.w,435 * game.w)){
			boolean pink = balls.getBoolean("pink",false);
			if(pink==true){
				game.Ball=Loader.Pink;
				ball.putString("player", "pink.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=6;
				}
		}
		if(game.InBounds(screenX, screenY, 300 * game.h,380 * game.h,455 * game.w,535 * game.w)){
			boolean black = balls.getBoolean("black",false);
			if(black==true){
				game.Ball=Loader.Black;
				ball.putString("player", "black.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=7;
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.h, 380 * game.h, 560 * game.w,640 * game.w)){
			boolean white = balls.getBoolean("white",false);
			if(white==true){
				game.Ball=Loader.White;
				ball.putString("player", "white.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=8;
			}
		}
		if(game.InBounds(screenX, screenY, 300 * game.h, 380 * game.h, 690 * game.w, 770 * game.w)){
			boolean yellow = balls.getBoolean("yellow",false);
			if(yellow==true){
				game.Ball=Loader.Yellow;
				ball.putString("player","yellow.png");
			}
			else{
				game.showWindowMedium=true;
				shop.showAchievements=9;
			}
		}
		if(game.InBounds(screenX, screenY, 5 * game.h,125 * game.h,675 * game.w,795 * game.w)){
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

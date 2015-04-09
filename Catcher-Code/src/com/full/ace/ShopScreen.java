package com.full.ace;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;

public class ShopScreen implements Screen {
	
	final Catcher game;
	private boolean blue,green,red,orange,cyan,pink,black,white,yellow;
	 Preferences balls;
	
	public ShopScreen(final Catcher game){
		this.game=game;
		Gdx.input.setInputProcessor(new InputHandlerShop(game));
		balls = Gdx.app.getPreferences("balls");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		blue=balls.getBoolean("blue",false);
		green=balls.getBoolean("green",false);
		red=balls.getBoolean("red",false);
		orange=balls.getBoolean("orange",false);
		cyan=balls.getBoolean("cyan",false);
		pink=balls.getBoolean("pink",false);
		black=balls.getBoolean("black",false);
		white=balls.getBoolean("white",false);
		yellow=balls.getBoolean("yellow",false);
		game.batch.begin();
		game.batch.draw(Loader.Shop, 0,0);
		game.batch.draw(game.Ball,105,130);
		if(blue==false) game.batch.draw(Loader.ShopLock, 380,250);
		if(green==false)game.batch.draw(Loader.ShopLock,480,250);
		if(red==false)game.batch.draw(Loader.ShopLock,585,250);
		if(orange==false)game.batch.draw(Loader.ShopLock,690,250);
		if(cyan==false)game.batch.draw(Loader.ShopLock,270,100);
		if(pink==false)game.batch.draw(Loader.ShopLock,375,100);
		if(black==false)game.batch.draw(Loader.ShopLock,480,100);
		if(white==false)game.batch.draw(Loader.ShopLock,585,100);
		if(yellow==false)game.batch.draw(Loader.ShopLock,690,100);
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

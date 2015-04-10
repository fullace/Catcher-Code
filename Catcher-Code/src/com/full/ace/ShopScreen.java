package com.full.ace;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ShopScreen implements Screen {
	
	final Catcher game;
	private boolean blue,green,red,orange,cyan,pink,black,white,yellow;
	 Preferences balls;
	 public int showAchievements;
	 private BitmapFont font;
	 private int wait;
	
	public ShopScreen(final Catcher game){
		this.game=game;
		Gdx.input.setInputProcessor(new InputHandlerShop(game,this));
		balls = Gdx.app.getPreferences("balls");
		showAchievements = 0;
		game.camera.setToOrtho(false,800,480);
		font =new BitmapFont(Gdx.files.internal("catcherM.fnt"));
		//font.setScale(Gdx.graphics.getDensity());
		Gdx.app.log("density",String.valueOf(Gdx.graphics.getDensity()));
		wait=0;
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
		game.camera.update();
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
		if(game.showWindowMedium==true){
			wait++;
			game.batch.draw(Loader.windowM,200,100);
			if(Gdx.input.isTouched() && wait > 10){
				if(game.InBounds(Gdx.input.getX(), Gdx.input.getY(),70*game.h,370*game.h,200*game.w,600*game.w )){
					game.showWindowMedium=false;
					showAchievements=0;
					wait=0;
				}
			}
			switch(showAchievements){
			case 0:
				//
				break;
			case 1:
				font.drawMultiLine(game.batch,"Blue Ball needs \na score of 10 \nin normal mode \nto unlock",220,380);
				break;
			case 2:
				font.drawMultiLine(game.batch,"Green Ball \nneeds a score \nof 10 in survival\nmode to unlock",220,380);
				break;
			case 3:
				font.drawMultiLine(game.batch,"Red Ball needs \na score of 20 \nin normal mode \nto unlock",220,380);
				break;
			case 4:
				font.drawMultiLine(game.batch,"Orange Ball \nneeds a score \nof 10 in random\nmode to unlock ",220,380);
				break;
			case 5:
				font.drawMultiLine(game.batch,"Cyan Ball needs \na score of 20\nin random \nmode to unlock",220,380);
				break;
			case 6:
				font.drawMultiLine(game.batch,"Pink Ball needs \na score of 20 in\nsurvival mode\nto unlock",220,380);
				break;
			case 7:
				font.drawMultiLine(game.batch,"Black Ball \nneeds a score of\n30 in normal \nmode to unlock",220,380);
				break;
			case 8:
				font.drawMultiLine(game.batch,"White Ball \nneeds a score of\n30 in random \nmode to unlock",220,380);
				break;
			case 9:
				font.drawMultiLine(game.batch,"Golden Ball \nneeds a score of\n50 in survival \nmode to unlock",220,380);
				break;
			}
		}
		
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

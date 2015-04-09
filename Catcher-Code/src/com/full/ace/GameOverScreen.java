package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameOverScreen implements Screen {
	
	final Catcher game;
	private int score;
	private int gamemode;
	private BitmapFont scores;
	private float w= Gdx.graphics.getWidth() / 800;
	private float h= Gdx.graphics.getHeight()/ 480;
	
	public GameOverScreen(final Catcher game,int score,int gamemode){
		this.game=game;
		this.score=score;
		this.gamemode=gamemode;
		scores = new BitmapFont(Gdx.files.internal("catcherM.fnt"));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Loader.GameBackground,0,0);
		game.batch.draw(Loader.Overlay,0,0);
		game.batch.draw(Loader.GameOver,200,65);
		if(gamemode!=2){
			scores.draw(game.batch, String.valueOf(score), 375, 300);
		}
		else if(gamemode==2){
			scores.draw(game.batch, String.valueOf(score/10), 375, 300);
		}
		game.batch.end();
		
		if(Gdx.input.isTouched()){
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			if(x > 260*w && x < 390*w && y > 255*h && y < 385*h){
				game.setScreen(new MainMenuScreen(game));
			}
		}
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

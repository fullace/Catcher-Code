package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class HighScoreScreen implements Screen {
	
	final Catcher game;
	Preferences score;
	private BitmapFont scores;
	Preferences timesPlayed;
	private int tpn;
	private int tps;
	private int tpr;
	
	public HighScoreScreen(final Catcher game){
		this.game=game;
		score=Gdx.app.getPreferences("highscore");
		scores=new BitmapFont(Gdx.files.internal("catcherB.fnt"));
		//scores.setScale(Gdx.graphics.getDensity());
		timesPlayed = Gdx.app.getPreferences("timesPlayed");
		tpn = timesPlayed.getInteger("normal",0);
		tps = timesPlayed.getInteger("survival",0);
		tpr = timesPlayed.getInteger("random",0);
		game.camera.setToOrtho(false,800,480);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Loader.HighScore,0,0);
		scores.draw(game.batch,String.valueOf(score.getInteger("scorenormal",0)),400,330);
		scores.draw(game.batch,String.valueOf(score.getInteger("scoresurvival",0)/10),400,215);
		scores.draw(game.batch,String.valueOf(score.getInteger("scorerandom",0)),400,100);
		game.writer.draw(game.batch, String.valueOf(tpn), 630, 320);
		game.writer.draw(game.batch, String.valueOf(tps), 630, 205);
		game.writer.draw(game.batch, String.valueOf(tpr), 630, 90);
		game.batch.end();
		if(Gdx.input.isTouched()){
			float x = Gdx.input.getX();
			float y = Gdx.input.getY();
			if(game.InBounds(x, y, 5*game.h, 125*game.h, 675*game.w, 795*game.w)){
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

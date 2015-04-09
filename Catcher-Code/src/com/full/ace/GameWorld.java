package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameWorld {
	
	final Catcher game;
	public Player player;
	public enum GameState {
		Ready,Running,Paused,GameOver
	}
	GameState state;
	public int gamemode ;
	public static final int MODE_NORMAL=1;
	public static final int MODE_SURVIVAL=2;
	public static final int MODE_RANDOM=3;
	public int score;
	Preferences balls;
	public Normal normal;
	public Survival survival;
	public RandomR random;
	Preferences timesPlayed;
	
	public GameWorld(final Catcher game,int gamemode){
		this.game=game;
		state=GameState.Ready;
		this.gamemode=gamemode;
		player=new Player(400-40/2,480);
		player.setWaiting();
		timesPlayed = Gdx.app.getPreferences("timesPlayed");
		score=0;
		balls = Gdx.app.getPreferences("balls");
		switch(gamemode){
		case MODE_NORMAL:
			normal = new Normal(player,game,this);
			int tp = timesPlayed.getInteger("normal",0);
			timesPlayed.putInteger("normal",tp+1);
			break;
		case MODE_SURVIVAL:
			survival = new Survival(player,game,this);
			int tps = timesPlayed.getInteger("survival",0);
			timesPlayed.putInteger("survival", tps+1);
			break;
		case MODE_RANDOM:
			random = new RandomR(player,game,this);
			int tpr = timesPlayed.getInteger("random",0);
			timesPlayed.putInteger("random", tpr+1);
			break;
		}
		timesPlayed.flush();
	}
	
	public void update(float delta){
		if(state!=GameState.GameOver){
			player.update(Gdx.graphics.getDeltaTime());
		}
		if(player.alive==false){
			state=GameState.GameOver;
		}
		if(player.getPosition().y<240 && state==GameState.Ready){
			player.setWaiting();
			state=GameState.Running;
		}
		if(gamemode==MODE_NORMAL && state==GameState.Running){
			normal.update(delta);
		}
		if(gamemode == MODE_SURVIVAL && state == GameState.Running){
			survival.update(delta);
		}
		if(gamemode == MODE_RANDOM && state == GameState.Running){
			random.update(delta);
		}
		if(state==GameState.GameOver && gamemode == MODE_NORMAL){
			if(score > normal.HighScore){
				normal.score.putInteger("scorenormal", score);
				normal.score.flush();
				if(score>1){
					balls.putBoolean("blue", true);
					balls.flush();
				}
			}
			game.setScreen(new GameOverScreen(game,score,1));
		}
		if(state==GameState.GameOver && gamemode == MODE_SURVIVAL){
			if(score > survival.HighScore){
				survival.score.putInteger("scoresurvival", score);
				survival.score.flush();
				if(score>5){
					balls.putBoolean("green", true);
					balls.flush();
				}
			}
			game.setScreen(new GameOverScreen(game,score,2));
		}
		if(state==GameState.GameOver && gamemode == MODE_RANDOM){
			if(score > random.HighScore){
				random.score.putInteger("scorerandom", score);
				random.score.flush();
				if(score>2){
					balls.putBoolean("red",true);
					balls.flush();
				}
			}
			Gdx.app.log("score", String.valueOf(score));
			game.setScreen(new GameOverScreen(game,score,3));
		}
	}
}

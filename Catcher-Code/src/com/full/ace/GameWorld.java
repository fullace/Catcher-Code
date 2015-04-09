package com.full.ace;

import com.badlogic.gdx.Gdx;

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
	
	public GameWorld(final Catcher game,int gamemode){
		this.game=game;
		state=GameState.Ready;
		this.gamemode=gamemode;
		player=new Player(400-40/2,480);
		player.setWaiting();
		score=0;
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
	}
}

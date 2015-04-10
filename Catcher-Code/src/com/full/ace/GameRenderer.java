package com.full.ace;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.full.ace.Normal.EnemyN;
import com.full.ace.RandomR.EnemyR;
import com.full.ace.Survival.EnemyS;

public class GameRenderer {
	final Catcher game;
	private GameWorld world;
	
	public GameRenderer(final Catcher game,GameWorld world){
		this.game=game;
		this.world=world;
		game.camera.setToOrtho(false,800,480);
		game.writer.setScale(Gdx.graphics.getDensity());
	}
	
	public void render(){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(Loader.GameBackground, 0,0);
        game.batch.draw(Loader.ScoreBord,290,420);
        if(world.gamemode!=world.MODE_SURVIVAL){
        	game.writer.draw(game.batch, "Score: "+world.score,320 , 465);
        }
        if(world.gamemode==world.MODE_SURVIVAL){
        	game.writer.draw(game.batch, "Score: "+world.score/10,320,465);
        }
        game.batch.draw(game.Ball,world.player.position.x,world.player.position.y);
        if(world.gamemode==world.MODE_NORMAL){
        	for(int i = 0; i < world.normal.enemys.size; i++){
        		EnemyN e = (EnemyN) world.normal.enemys.get(i);
        		game.batch.draw(Loader.Red,e.position.x,e.position.y);
        	}
        	if(world.normal.c!=null){
        		game.batch.draw(Loader.Blue,world.normal.c.position.x,world.normal.c.position.y);
        	}
        }
        if(world.gamemode==world.MODE_SURVIVAL){
        	for(int i = 0; i < world.survival.enemys.size; i++){
        		EnemyS e = (EnemyS) world.survival.enemys.get(i);
        		switch(e.pos){
        		case 0:
        			game.batch.draw(Loader.sTop,e.position.x,e.position.y);
        			break;
        		case 1:
        			game.batch.draw(Loader.sBottom,e.position.x,e.position.y);
        			break;
        		case 2:
        			game.batch.draw(Loader.sLeft,e.position.x,e.position.y);
        			break;
        		case 3:
        			game.batch.draw(Loader.sRight,e.position.x,e.position.y);
        			break;
        		case 4:
        			game.batch.draw(Loader.sBest,e.position.x,e.position.y);
        			break;
        		case 5:
        			game.batch.draw(Loader.sBest,e.position.x,e.position.y);
        			break;
        		}
        	}
        	
        }
        if(world.gamemode==world.MODE_RANDOM){
    		for(int i = 0; i < world.random.enemys.size; i++){
    			EnemyR e = (EnemyR) world.random.enemys.get(i);
    			switch(e.colour){
    				case 0:
    					game.batch.draw(Loader.Silver,e.position.x,e.position.y);
    					break;
    				case 1:
    					game.batch.draw(Loader.Blue,e.position.x,e.position.y);
    					break;
    				case 2:
    					game.batch.draw(Loader.Red,e.position.x,e.position.y);
    					break;
    				case 3:
    					game.batch.draw(Loader.Green,e.position.x,e.position.y);
    					break;
    				case 4:
    					game.batch.draw(Loader.Pink,e.position.x,e.position.y);
    					break;
    				case 5:
    					game.batch.draw(Loader.Black,e.position.x,e.position.y);
    					break;
    				case 6:
    					game.batch.draw(Loader.White,e.position.x,e.position.y);
    					break;
    				case 7:
    					game.batch.draw(Loader.Orange,e.position.x,e.position.y);
    					break;
    				case 8:
    					game.batch.draw(Loader.Yellow,e.position.x,e.position.y);
    					break;
    				case 9:
    					game.batch.draw(Loader.Cyan,e.position.x,e.position.y);
    					break;
    			}
    		}
        
	}
        game.batch.end();
	}
}

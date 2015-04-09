package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.full.ace.Normal.EnemyN;

public class GameRenderer {
	final Catcher game;
	private GameWorld world;
	
	public GameRenderer(final Catcher game,GameWorld world){
		this.game=game;
		this.world=world;
		game.camera.setToOrtho(false,800,480);
	}
	
	public void render(){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(Loader.GameBackground, 0,0);
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
        game.batch.end();
	}

}

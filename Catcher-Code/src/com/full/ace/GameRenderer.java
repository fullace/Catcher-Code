package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

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
        game.batch.end();
	}

}

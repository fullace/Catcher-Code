package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen {
	
	final Catcher game;
	GameWorld world;
	GameRenderer renderer;
	
	public GameScreen(final Catcher game,int gamemode){
		this.game=game;
		world=new GameWorld(game,gamemode);
		renderer=new GameRenderer(game,world);
		Gdx.input.setInputProcessor(new GameInputHandler(game,world));
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
	world.update(delta);
	renderer.render();
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
	
	public void nullify(){
		world=null;
		renderer=null;
	}

}

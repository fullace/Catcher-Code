package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Splash implements Screen {
	//Showing the Full Ace Splash Animation
	
	final Catcher game;
	
	//animation variables
	
	private static final int FRAME_COLUMNS = 4;
	private static final int FRAME_ROWS = 4;
	private static final int FRAME_COLUMNS_MIDDLE = 5;
	private static final int FRAME_ROWS_MIDDLE = 4;
	Animation                anim1,anim2,anim3;
	Texture                  splash1,splash2,splash3;
	TextureRegion[]          frames1,frames2,frames3;
	TextureRegion            currentFrame;
	
	float                    state1,state2,state3;
	
	public Splash(final Catcher game){
		this.game=game;
		game.camera.setToOrtho(false,800,480);
		
		initAnimations();
		fillFrames(1);
		fillFrames(2);
		fillFrames(3);
		
		anim1 = new Animation(1/ 12f,frames1);
		anim2 = new Animation(1/ 12f,frames2);
		anim3 = new Animation(1/ 12f,frames3);
		
		state1=0f;
		state2=0f;
		state3=0f;
	}
	
	private void initAnimations(){
		splash1 = new Texture(Gdx.files.internal("splash1_.png"));
		splash2 = new Texture(Gdx.files.internal("splash2_.png"));
		splash3 = new Texture(Gdx.files.internal("splash3_.png"));
		
		frames1 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames2 = new TextureRegion[FRAME_COLUMNS_MIDDLE * FRAME_ROWS_MIDDLE];
		frames3 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
	}
	
	private void fillFrames(int frames){
		switch(frames){
		case 1:
			TextureRegion[][] tmp = TextureRegion.split(splash1,splash1.getWidth()/FRAME_COLUMNS,splash1.getHeight()/FRAME_ROWS);
			int index = 0;
			for(int i = 0; i < FRAME_ROWS; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
					frames1[index++] = tmp[i][j];
				}
			}
			break;
		case 2:
			TextureRegion[][] tmp2 = TextureRegion.split(splash2,splash2.getWidth()/FRAME_COLUMNS_MIDDLE,splash2.getHeight()/FRAME_ROWS_MIDDLE);
			int index2 = 0;
			for(int i = 0; i < FRAME_ROWS_MIDDLE; i++){
				for(int j = 0; j < FRAME_COLUMNS_MIDDLE; j++){
					frames2[index2++] = tmp2[i][j];
				}
			}
			break;
		case 3:
			TextureRegion[][] tmp3 = TextureRegion.split(splash3,splash3.getWidth()/FRAME_COLUMNS,splash3.getHeight()/FRAME_ROWS);
			int index3 = 0;
			for(int i = 0; i < FRAME_ROWS; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
					frames3[index3++] = tmp3[i][j];
				}
			}
			break;
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        state1+=Gdx.graphics.getDeltaTime();
        game.batch.begin();
        game.batch.draw(anim1.getKeyFrame(state1),200,120);
        if(anim1.isAnimationFinished(state1)){
        	state2+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim2.getKeyFrame(state2),200,120);
        }
        if(anim2.isAnimationFinished(state2)){
        	state3+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim3.getKeyFrame(state3),200,120);
        }
        if(anim3.isAnimationFinished(state3)){
        	game.setScreen(new Loader(game));
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
package com.full.ace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashScreen implements Screen {
	//Showing the Full Ace Splash Animation
	
	final CGame game;
	
	//animation variables
	
	private static final int FRAME_COLUMNS = 2;
	private static final int FRAME_ROWS = 4;
	private static final int FRAME_ROWS_LAST = 2;
	Animation                anim1,anim2,anim3,anim4,anim5,anim6,anim7;
	Texture                  splash1,splash2,splash3,splash4,splash5,splash6,splash7;
	TextureRegion[]          frames1,frames2,frames3,frames4,frames5,frames6,frames7;
	TextureRegion            currentFrame;
	
	float                    state1,state2,state3,state4,state5,state6,state7;
	
	public SplashScreen(final CGame game){
		this.game=game;
		game.camera.setToOrtho(false,800,480);
		
		initAnimations();
		fillFrames(1);
		fillFrames(2);
		fillFrames(3);
		fillFrames(4);
		fillFrames(5);
		fillFrames(6);
		fillFrames(7);
		
		anim1 = new Animation(1/ 10f,frames1);
		anim2 = new Animation(1/ 10f,frames2);
		anim3 = new Animation(1/ 10f,frames3);
		anim4 = new Animation(1/ 10f,frames4);
		anim5 = new Animation(1/ 10f,frames5);
		anim6 = new Animation(1/ 10f,frames6);
		anim7 = new Animation(1/ 10f,frames7);
		
		state1=0f;
		state2=0f;
		state3=0f;
		state4=0f;
		state5=0f;
		state6=0f;
		state7=0f;
	}
	
	private void initAnimations(){
		splash1 = new Texture(Gdx.files.internal("splash1.png"));
		splash2 = new Texture(Gdx.files.internal("splash2.png"));
		splash3 = new Texture(Gdx.files.internal("splash3.png"));
		splash4 = new Texture(Gdx.files.internal("splash4.png"));
		splash5 = new Texture(Gdx.files.internal("splash5.png"));
		splash6 = new Texture(Gdx.files.internal("splash6.png"));
		splash7 = new Texture(Gdx.files.internal("splash7.png"));
		
		frames1 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames2 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames3 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames4 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames5 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames6 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS];
		frames7 = new TextureRegion[FRAME_COLUMNS * FRAME_ROWS_LAST];
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
			TextureRegion[][] tmp2 = TextureRegion.split(splash2,splash2.getWidth()/FRAME_COLUMNS,splash2.getHeight()/FRAME_ROWS);
			int index2 = 0;
			for(int i = 0; i < FRAME_ROWS; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
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
		case 4:
			TextureRegion[][] tmp4 = TextureRegion.split(splash4,splash4.getWidth()/FRAME_COLUMNS,splash4.getHeight()/FRAME_ROWS);
			int index4 = 0;
			for(int i = 0; i < FRAME_ROWS; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
					frames4[index4++] = tmp4[i][j];
				}
			}
			break;
		case 5:
			TextureRegion[][] tmp5 = TextureRegion.split(splash5,splash5.getWidth()/FRAME_COLUMNS,splash5.getHeight()/FRAME_ROWS);
			int index5 = 0;
			for(int i = 0; i < FRAME_ROWS; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
					frames5[index5++] = tmp5[i][j];
				}
			}
			break;
		case 6:
			TextureRegion[][] tmp6 = TextureRegion.split(splash6,splash6.getWidth()/FRAME_COLUMNS,splash6.getHeight()/FRAME_ROWS);
			int index6 = 0;
			for(int i = 0; i < FRAME_ROWS; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
					frames6[index6++] = tmp6[i][j];
				}
			}
			break;
		case 7:
			TextureRegion[][] tmp7 = TextureRegion.split(splash7,splash7.getWidth()/FRAME_COLUMNS,splash7.getHeight()/FRAME_ROWS_LAST);
			int index7 = 0;
			for(int i = 0; i < FRAME_ROWS_LAST; i++){
				for(int j = 0; j < FRAME_COLUMNS; j++){
					frames7[index7++] = tmp7[i][j];
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
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        state1+=Gdx.graphics.getDeltaTime();
        game.batch.begin();
        game.batch.draw(anim1.getKeyFrame(state1),0,0);
        if(anim1.isAnimationFinished(state1)){
        	state2+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim2.getKeyFrame(state2),0,0);
        }
        if(anim2.isAnimationFinished(state2)){
        	state3+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim3.getKeyFrame(state3),0,0);
        }
        if(anim3.isAnimationFinished(state3)){
        	state4+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim4.getKeyFrame(state4),0,0);
        }
        if(anim4.isAnimationFinished(state4)){
        	state5+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim5.getKeyFrame(state5),0,0);
        }
        if(anim5.isAnimationFinished(state5)){
        	state6+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim6.getKeyFrame(state6),0,0);
        }
        if(anim6.isAnimationFinished(state6)){
        	state7+=Gdx.graphics.getDeltaTime();
        	game.batch.draw(anim7.getKeyFrame(state7),0,0);
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
		splash1.dispose();
		splash2.dispose();
		splash3.dispose();
		splash4.dispose();
		splash5.dispose();
		splash6.dispose();
		splash7.dispose();
	}

}

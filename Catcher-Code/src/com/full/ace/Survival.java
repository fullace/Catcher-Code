package com.full.ace;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Survival {
	
	private Player player;
	public Array<EnemyS> enemys;
	private long spawnCounter;
	public int HighScore;
	Preferences score;
	final Catcher game;
	GameWorld world;
	public long spawnTime;
	private long border1;
	private long border2;
	private long border3;
	private long startTime;
	
	public Survival(Player player, final Catcher game,GameWorld world){
		this.player=player;
		this.game=game;
		this.world=world;
		enemys = new Array<EnemyS>();
		spawnCounter=0;
		score=Gdx.app.getPreferences("highscore"); //getting the high score preference
		HighScore=score.getInteger("scoresurvival",0);
		spawnTime=1000000000L;
		border1=1000000000L;
		border2=5000000000L;
		border3=10000000000L;
		startTime=TimeUtils.nanoTime();
	}
	
	public void update(float delta){
		if(TimeUtils.nanoTime() - spawnCounter > spawnTime){ 
			spawnEnemy();
		}
		if(TimeUtils.nanoTime() - startTime > border1){
			spawnTime=500000000L;
		}
		if(TimeUtils.nanoTime() - startTime > border2){
			spawnTime=400000000L;
		}
		if(TimeUtils.nanoTime() - startTime > border3){
			spawnTime=300000000L;
		}
		updateEnemys(delta);
	}
	
	private void spawnEnemy(){
		spawnCounter=TimeUtils.nanoTime();
		EnemyS e = new EnemyS(player);
		enemys.add(e);
		world.score++;
	}
	
	private void updateEnemys(float delta){
		for(int i = 0; i < enemys.size; i++){
			EnemyS e = (EnemyS) enemys.get(i);
			if(e.visible==true){
				e.update(delta);
			}
			else{
				enemys.removeIndex(i);
			}
		}
	}
	
	public class EnemyS{
		public boolean visible;
		private Random rand;
		private Circle circle;
		private Player player;
		public Vector2 position;
		private Vector2 velocity;
		public int pos;
		
		public EnemyS(Player player){
			this.player=player;
			visible=true;
			rand=new Random();
			pos=rand.nextInt(6);
			circle=new Circle();
			position=new Vector2();
			velocity=new Vector2();
			switch(pos){
			case 0:
				position.x=rand.nextInt(760);
				position.y=550;
				velocity.x=0;
				velocity.y=-200;
				break;
			case 1:
				position.x=rand.nextInt(760);
				position.y=-50;
				velocity.x=0;
				velocity.y=200;
				break;
			case 2:
				position.x=-50;
				position.y=rand.nextInt(440);
				velocity.x=200;
				velocity.y=0;
				break;
			case 3:
				position.x=810;
				position.y=rand.nextInt(440);
				velocity.x=-200;
				velocity.y=0;
				break;
			case 4:
				position.x=-50;;
				position.y=rand.nextInt(480)+380;
				velocity.x=200;
				velocity.y=-200;
				break;
			case 5:
				position.x=810;
				position.y=rand.nextInt(480)+380;
				velocity.x=-200;
				velocity.y=-200;
				break;
			}
		}
		
		public void update(float delta){
		position.add(velocity.cpy().scl(delta));
		switch(pos){
		case 0:
			if(position.y<-40) visible=false;
			break;
		case 1:
			if(position.y>540) visible=false;
			break;
		case 2:
			if(position.x>810) visible=false;
			break;
		case 3:
			if(position.x<-50) visible=false;
			break;
		case 4:
			if(position.x>810) visible=false;
			break;
		case 5:
			if(position.x<-50) visible=false;
			break;
		} 
		circle.set(position.x+20,position.y+20,20);
		if(Intersector.overlaps(circle, player.circle))
		{
			player.alive=false;
		}
		}
	}
}

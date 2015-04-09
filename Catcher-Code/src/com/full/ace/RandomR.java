package com.full.ace;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class RandomR {
	public Array<EnemyR> enemys;
	private long spawnCounter;
	Preferences score;
	public int HighScore;
	final Catcher game;
	GameWorld world;
	private Player player;
	
	public RandomR(Player player,final Catcher game,GameWorld world){
		this.player=player;
		this.game=game;
		this.world=world;
		enemys=new Array<EnemyR>();
		spawnCounter=0;
		score=Gdx.app.getPreferences("highscore");
		HighScore=score.getInteger("scorerandom",0);
	}
	
	public void update(float delta){
		if(TimeUtils.nanoTime() - spawnCounter > 5000000000L ){  //5s
			spawnEnemy();
		}
		updateEnemys(delta);
	}
	
	private void spawnEnemy(){
		spawnCounter=TimeUtils.nanoTime();
		EnemyR e = new EnemyR(player);
		enemys.add(e);
		world.score++;
	}
	
	private void updateEnemys(float delta){
		for(int i = 0; i < enemys.size; i++){
			EnemyR e = (EnemyR) enemys.get(i);
			e.update(delta);
		}
	}
	
	public class EnemyR{
		
		private Random rand;
		public Vector2 position;
		private Vector2 velocity;
		public int pos;
		private Circle circle;
		private Player player;
		public int colour;
		
		public EnemyR(Player player){
			this.player=player;
			rand=new Random();
			position=new Vector2();
			velocity=new Vector2();
			colour=rand.nextInt(10);
			pos=rand.nextInt(4);
			switch(pos)
			{
			case 0:
				position.x=20;
				position.y=20;
				velocity.x=rand.nextInt(200)+300;
				velocity.y=rand.nextInt(150)+150;
				break;
			case 1:
				position.x=780-40;
				position.y=20;
				velocity.x=-rand.nextInt(200)+300;
				velocity.y=rand.nextInt(150)+150;
				break;
			case 2:
				position.x=780-40;
				position.y=460-40;
				velocity.x=-rand.nextInt(200)+300;
				velocity.y=-rand.nextInt(150)+150;
				break;
			case 3:
				position.x=20;
				position.y=460-40;
				velocity.x=rand.nextInt(200)+300;
				velocity.y=-rand.nextInt(150)+150;
				break;
			}
			circle=new Circle();
			this.player=player;
		}
		
		public void update(float delta){
			position.add(velocity.cpy().scl(delta));
			if(position.x > 780-40) {
				position.x=780-40;
				velocity.x*=-1;
			}
			if(position.x < 20) {
				position.x=20;
				velocity.x*=-1;
			}
			if(position.y > 460-40) {
				position.y=460-40;
				velocity.y*=-1;
			}
			if(position.y < 20) {
				position.y=20;
				velocity.y*=-1;
			}
			circle.set(position.x+20,position.y+20,20);
			if(Intersector.overlaps(circle, player.circle))
			{
				player.alive=false;
			}
		}
	}
}

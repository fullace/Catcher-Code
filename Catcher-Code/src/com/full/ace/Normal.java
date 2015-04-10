package com.full.ace;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Normal {
	
	private Player player;
	public Array<EnemyN> enemys;
	private long spawnCounter;
	private long spawnCounterCatcher;
	public int HighScore;  //high score in normal
	Preferences score;
	final Catcher game;
	GameWorld world;
	public Cat c;
	
	//konstruktor
	
	public Normal(Player player,final Catcher game, GameWorld world){
		this.player=player;
		this.game=game;
		enemys=new Array<EnemyN>();
		spawnCounter=0;
		spawnCounterCatcher=0;
		score=Gdx.app.getPreferences("highscore");  //getting the highscore preference
		HighScore=score.getInteger("scorenormal",0);  //getting the normal high score and set the high score to it
		this.world=world;
		
	}
	
	//update methode für normal

	public void update(float delta){
		if(TimeUtils.nanoTime() - spawnCounter > 15000000000L){
			spawnEnemy();
		}
		if(TimeUtils.nanoTime() - spawnCounterCatcher > 5000000000L && c==null){
			spawnCatcher();
		}
		updateEnemys(delta);
	}
	
	private void spawnEnemy(){
		spawnCounter=TimeUtils.nanoTime();
		EnemyN e = new EnemyN(player);
		enemys.add(e);
	}
	
	private void spawnCatcher(){
		c = new Cat(player);
	}
	
	private void updateEnemys(float delta){
		for(int i = 0; i< enemys.size; i++){
			EnemyN e = (EnemyN) enemys.get(i);
			e.update(delta);
		}
		if(c != null){
			if(c.alive==true){
				c.update(delta);
			}
			else
			{
				c=null;
				spawnCounterCatcher=TimeUtils.nanoTime();
			}
		}
	}
	
	//Catcher class for normal Gamemode
	
	public class Cat{
		private Random rand = new Random();
		public Vector2 position;
		private Vector2 velocity;
		private Player player;
		private Circle circle;
		private int width;
		private int height;
		public boolean alive;
		
		public Cat(Player player){
			position = new Vector2();
			velocity = new Vector2();
			velocity.x=200;
			velocity.y=100;
			position.x=rand.nextInt(760);
			position.y=rand.nextInt(480);
			this.player=player;
			circle = new Circle();
			width=40;
			height=40;
			alive=true;
		}
		
		public void update(float delta){
			position.add(velocity.cpy().scl(delta));
			if(position.x > 780-width) {
				position.x=780-width;
				velocity.x*=-1;
			}
			if(position.x < 20) {
				position.x=20;
				velocity.x*=-1;
			}
			if(position.y > 460-height) {
				position.y=460-height;
				velocity.y*=-1;
			}
			if(position.y < 20) {
				position.y=20;
				velocity.y*=-1;
			}
			circle.set(position.x+20,position.y+20,20);
			if(Intersector.overlaps(circle, player.circle))
			{
				alive=false;
				world.score++;
			}
		}
	}
	
	//Enemy class for normal Gamemode
	
	public class EnemyN{
		private Random rand = new Random();
		public Vector2 position;
		public Vector2 velocity;
		private Player player;
		private Circle circle;
		private int pos;
		private int width;
		private int height;
		
		public EnemyN(Player player){
			position = new Vector2(0,0);
			velocity = new Vector2(0,0);
			this.player=player;
			circle = new Circle();
			width = 40;
			height = 40;
			pos = rand.nextInt(4);
			switch(pos){
			case 0:
				position.x=20;
				position.y=20;
				velocity.x=300;
				velocity.y=150;
				break;
			case 1:
				position.x=780-width;
				position.y=20;
				velocity.x=-300;
				velocity.y=150;
				break;
			case 2:
				position.x=780-width;
				position.y=460-height;
				velocity.x=-300;
				velocity.y=-150;
				break;
			case 3:
				position.x=20;
				position.y=460-height;
				velocity.x=300;
				velocity.y=-150;
				break;
			}	
		}
		
		public void update(float delta){
			position.add(velocity.cpy().scl(delta));
			if(position.x > 780-width) {
				position.x=780-width;
				velocity.x*=-1;
			}
			if(position.x < 20) {
				position.x=20;
				velocity.x*=-1;
			}
			if(position.y > 460-height) {
				position.y=460-height;
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

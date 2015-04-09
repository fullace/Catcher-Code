package com.full.ace;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	
	public Vector2 position;
	public Vector2 velocity;
	private int width = 40;
	private int height = 40;
	private static final int STATE_WAITING    = 0;
	private static final int STATE_READY      = 1;
	private static final int STATE_TRAVELLING = 2;
	private static final int STATE_RUNNING    = 3;
	private int state;
	private boolean controllable;
	public boolean alive;
	public Circle circle;
	
	public Player(int x,int y){
		position = new Vector2(x,y);
		velocity = new Vector2(0,0);
		state    = STATE_READY;
		controllable=false;
		alive=true;
		circle=new Circle();
	}
	
	public void update(float delta){
		switch(state){
		case STATE_READY:
			velocity.x=0;
			velocity.y=0;
			controllable=false;
			break;
		case STATE_TRAVELLING:
			velocity.x=0;
			velocity.y=-300;
			controllable=false;
			break;
		case STATE_RUNNING:
			controllable=true;
			break;
		case STATE_WAITING:
			velocity.x=0;
			velocity.y=0;
			break;
		}
		position.add(velocity.cpy().scl(delta));
		if(position.x<20) position.x=20;
		if(position.x>780-width) position.x=780-width;
		if(position.y<20) position.y=20;
		if(position.y>460-height) position.y=460-height;
		circle.set(position.x+20,position.y+20,20);
	}
	
	public void setReady()
	{
		state=STATE_READY;
	}
	public void setTravelling()
	{
		state=STATE_TRAVELLING;
	}
	public void setRunning()
	{
		state=STATE_RUNNING;
	}
	public void setWaiting()
	{
		state=STATE_WAITING;
	}
	public void moveToUpperLeft(){
		if(state==STATE_RUNNING || state==STATE_WAITING){
			velocity.x=-350;
			velocity.y=175;
			state=STATE_RUNNING;
		}
	}
	public void moveToUpperRight(){
		if(state==STATE_RUNNING || state==STATE_WAITING){
			velocity.x=350;
			velocity.y=175;
			state=STATE_RUNNING;
		}
	}
	public void moveToBottomRight(){
		if(state==STATE_RUNNING || state==STATE_WAITING){
			velocity.x=350;
			velocity.y=-175;
			state=STATE_RUNNING;
		}
	}
	public void moveToBottomLeft(){
		if(state==STATE_RUNNING || state==STATE_WAITING){
			velocity.x=-350;
			velocity.y=-175;
			state=STATE_RUNNING;
		}
	}
	public void stopMoving(){
		state=STATE_WAITING;
		
	}

	public Vector2 getPosition(){
		return position;
	}

}

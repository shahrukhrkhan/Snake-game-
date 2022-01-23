package test;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
   //private field declarations
	private ArrayList<Rectangle> body;
	private int span = Game.width;
	private int tall = Game.height;
	private int proportion = Game.proportion;
	private String motion; //NOTHING, UP, DOWN, LEFT, RIGHT
   
	//constructor
	public Snake() {
		body = new ArrayList<>();
		
		Rectangle shape = new Rectangle(Game.proportion, Game.proportion);
		shape.setLocation(Game.width / 2 * Game.proportion, Game.height / 2 * Game.proportion);
		body.add(shape);
		
		shape = new Rectangle(proportion, proportion);
		shape.setLocation((span / 2 - 1) * proportion, (tall / 2) * proportion);
		body.add(shape);
		
		shape = new Rectangle(proportion, proportion);
		shape.setLocation((span / 2 - 2) * proportion, (tall / 2) * proportion);
		body.add(shape);
		
		motion = "NOTHING";
	}
	//method for the movement of the snake
	public void motion() {
		if(motion != "NOTHING") {
			Rectangle first = body.get(0);
			
			Rectangle shape = new Rectangle(Game.proportion, Game.proportion);
			
			if(motion == "UP") {
				shape.setLocation(first.x, first.y - Game.proportion);
			}
			else if(motion == "DOWN") {
				shape.setLocation(first.x, first.y + Game.proportion);
			}
			else if(motion == "LEFT") {
				shape.setLocation(first.x - Game.proportion, first.y);
			}
			else{
				shape.setLocation(first.x + Game.proportion, first.y);
			}
			
			body.add(0, shape);
			body.remove(body.size()-1);
		}
	}
	//method for expanding snake
	public void expand() {
		Rectangle first = body.get(0);
		
		Rectangle shape = new Rectangle(Game.proportion, Game.proportion);
		
		if(motion == "UP") {
			shape.setLocation(first.x, first.y - Game.proportion);
		}
		else if(motion == "DOWN") {
			shape.setLocation(first.x, first.y + Game.proportion);
		}
		else if(motion == "LEFT") {
			shape.setLocation(first.x - Game.proportion, first.y);
		}
		else{
			shape.setLocation(first.x + Game.proportion, first.y);
		}
		
		body.add(0, shape);
	}
   //arraylist for returning body of snake
	public ArrayList<Rectangle> getBody() {
		return body;
	}
	
   //getters and setters
	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public int getX() {
		return body.get(0).x;
	}
	
	public int getY() {
		return body.get(0).y ;
	}
	
	public String getMotion() {
		return motion;
	}
	//motion method:up,down,left,right for snake
	public void up() {
		motion = "UP";
	}
	public void down() {
		motion = "DOWN";
	}
	public void left() {
		motion = "LEFT";
	}
	public void right() {
		motion = "RIGHT";
	}
}
package test;

import java.awt.Rectangle;

public class Apple {
//private field declarations
	private int x;
	private int y;
	//constructor
	public Apple(Snake contender) {
		this.place(contender);
	}
	//method for placing apple
	public void place(Snake contender) {
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			x = (int)(Math.random() * Game.width - 1);
			y = (int)(Math.random() * Game.height - 1);
			
			for(Rectangle shape : contender.getBody()){
				if(shape.x == x && shape.y == y) {
					onSnake = true;
				}
			}
		}
	}
//Getters and setters method
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
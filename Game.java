package test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Game implements KeyListener{
	//private field declarations
   private Snake contender; 
	private Apple apple;
	private Graphics picture;
	
   //Establishing Frame
	private JFrame frame;
	//proportions of frame declarations
	public static final int width = 30;
	public static final int height = 30;
	public static final int proportion = 20;
	//Constructor
	public Game() 
   {
		frame = new JFrame();
		contender = new Snake();
		apple = new Apple(contender);
		picture = new Graphics(this);
		
		frame.add(picture);
		frame.setVisible(true);
		frame.setTitle("Welcome to the Snake Game");
		frame.setSize(width * proportion + 2, height * proportion + proportion + 4);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void run() 
   {
		picture.condition = "RUNNING";
	}
	//Method to check if snake touches food, collides, touches it self
	public void renew() 
   {
		if(picture.condition == "RUNNING") {
			if(foodTouch()) {
				contender.expand();
				apple.place(contender);
			}
			else if(wallTouch() || selfTouch()) {
				picture.condition = "END";
			}
			else {
				contender.motion();
			}
		}
	}
	//private boolean method for wall collision
	private boolean wallTouch() 
   {
		if(contender.getX() < 0 || contender.getX() >= width * proportion 
				|| contender.getY() < 0|| contender.getY() >= height * proportion) {
			return true;
		}
		return false;
	}
	//private boolean method for food touch
	private boolean foodTouch() 
   {
		if(contender.getX() == apple.getX() * proportion && contender.getY() == apple.getY() * proportion) {
			return true;
		}
		return false;
	}
	//private boolean method for snake touching itself
	private boolean selfTouch() 
   {
		for(int i = 1; i < contender.getBody().size(); i++) {
			if(contender.getX() == contender.getBody().get(i).x &&
					contender.getY() == contender.getBody().get(i).y) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
   {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if(picture.condition == "RUNNING") {
			if(keyCode == KeyEvent.VK_W && contender.getMotion() != "DOWN") 
         {
				contender.up();
			}
		
			if(keyCode == KeyEvent.VK_S && contender.getMotion() != "UP") 
         {
				contender.down();
			}
		
			if(keyCode == KeyEvent.VK_A && contender.getMotion() != "RIGHT") 
         {
				contender.left();
			}
		
			if(keyCode == KeyEvent.VK_D && contender.getMotion() != "LEFT") 
         {
				contender.right();
			}
		}
		else 
      {
			this.run();
		}
	}
   //Getters and setters methods
	@Override
	public void keyReleased(KeyEvent e) {	}

	public Snake getContender() {
		return contender;
	}

	public void setContender(Snake contender) {
		this.contender = contender;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	public JFrame getWind() {
		return frame;
	}

	public void setWindow(JFrame window) {
		this.frame = frame;
	}
	
}
package test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener{
	//private field and timer object declaration
   private Timer time = new Timer(100, this);
	public String condition;
	private Snake animal;
	private Apple apple;
	private Game game;
	//constructor
	public Graphics(Game t) 
   {
		time.start();
		condition = "START";
		
		game = t;
		animal = t.getContender();
		apple = t.getApple();
		
		//add a keyListner 
		this.addKeyListener(t);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	//paint component method
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, Game.width * Game.proportion + 5, Game.height * Game.proportion + 5);
		
		if(condition == "START") 
      {
			g2d.setColor(Color.white);
			g2d.drawString("Press any key to begin",
         Game.width/2 * Game.proportion - 40, Game.height / 2 * Game.proportion - 20);
		}
		else if(condition == "RUNNING") {
			g2d.setColor(Color.red);
			g2d.fillRect(apple.getX() * Game.proportion, 
         apple.getY() * Game.proportion, Game.proportion, Game.proportion);
		
			g2d.setColor(Color.green);
			for(Rectangle shape : animal.getBody()) {
				g2d.fill(shape);
			}
		}
		else {
			g2d.setColor(Color.white);
			g2d.drawString("Score for this try: " + 
         (animal.getBody().size() - 3), Game.width/2 * Game.proportion - 40, Game.height / 2 * Game.proportion - 20);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		game.renew();
	}
	
}
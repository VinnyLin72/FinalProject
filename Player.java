import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{

    int x = 300;
    int y = 300;
    int xa = 1;
    int ya = 1;
    private int lives;
    private boolean alive = true;
    private FinalProject game;
    
    public Player(FinalProject game){
	this.game = game;
	lives = 3;
    }

    public void move(){
	if (x + xa < 0)
	    xa = 1;
	if (x + xa > game.getWidth() - 30)
	    xa = -1;
	if (y + ya < 0)
	    ya = 1;
	if (y + ya > game.getHeight() - 30)
	    ya = -1;

	x = x + xa;
	y = y + ya;
    }

    public void hurt(){
	lives --;
    }

    public void checkAlive(){
	if (lives == 0) alive = false;
    }

    public void paint(Graphics g){	
	g.fillRect(x,y,30,30);
    }

    public void keyPressed(int k){

    }

}

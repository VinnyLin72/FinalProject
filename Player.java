import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle implements KeyListener{
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

    public void keyPressed(KeyEvent e) {
	int k = e.getKeyCode();
	if (k == 37)y --;
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e){

    }
    public void test(){
	x --;
    }
    public void move(){
	y --;
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

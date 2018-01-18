import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle implements KeyListener{
    int x = 100;
    int y = 300;
    int xa = 0;
    int ya = 0;
    
    
    private int lives;
    private FinalProject game;

    public Player(FinalProject game){
	this.game = game;
	lives = 3;
    }

    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_UP) ya = -1;
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) xa = 1;
	if (e.getKeyCode() == KeyEvent.VK_LEFT) xa = -1;
	if (e.getKeyCode() == KeyEvent.VK_DOWN) ya = 1;
    }

    public void keyReleased(KeyEvent e) {
	ya = 0;
	xa = 0;
    }

    public void keyTyped(KeyEvent e){

    }
 
    public void move(){
	y += ya;
	x += xa;
    }

    public void hurt(){
	lives --;
    }

    public int getLives(){
	return lives;
    }

    public boolean checkAlive(){
	return (lives > 0);
    }

    public void paint(Graphics g){	
	g.fillRect(x,y,30,30);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,30,30);
    }
 }

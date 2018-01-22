import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Rectangle implements KeyListener{
    int x = 100;
    int y = 300;
    int xa = 0;
    int ya = 0;
    private BufferedImage image;
    private boolean damagable = true;
    private int lives;
    private int origLives;
    private FinalProject game;
    private damageInvincibility invClock;
    

    public Player(FinalProject game){
	this.game = game;
	lives = 3;
	origLives = lives;
	try{
	    image = ImageIO.read(new File("Player.png"));
	}catch(IOException e){
	    e.printStackTrace();
	}
    }

    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_UP) ya = -1;
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) xa = 1;
	if (e.getKeyCode() == KeyEvent.VK_LEFT) xa = -1;
	if (e.getKeyCode() == KeyEvent.VK_DOWN) ya = 1;
    }

    public void keyReleased(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_UP) ya = 0;
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) xa = 0;
	if (e.getKeyCode() == KeyEvent.VK_LEFT) xa = 0;
	if (e.getKeyCode() == KeyEvent.VK_DOWN) ya = 0;
    }

    public void keyTyped(KeyEvent e){ 

    }
 
    public void move(){
	y += ya;
	x += xa;
    }
    
    public void hurt(){
	if(damagable){
	    damagable = false;
	    lives --;
	    invClock = new damageInvincibility(this);
	    x = 70;
	    y = 300; 
	}
    }
    
    public int getLives(){
	return lives;
    }

    public void revive(){
	lives = origLives;
    }
    
    public boolean checkAlive(){
	return (lives > 0);
    }

    public void godPower(int l){
	lives = l;
	origLives = l;
    }

    public void invincibleStop(){
	damagable = true;
    }
    
    public void paint(Graphics g){	
	//g.fillRect(x,y,30,30);
	g.drawImage(image, x, y, null);
    }

    public Rectangle getBounds(){
	return new Rectangle(x,y,30,30);
    }
 }

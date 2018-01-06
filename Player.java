import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{

    private int lives;
    private boolean alive = true;
    
    public Player(){
	super(50, 100, 20, 20);
	lives = 3;
    }

    public void hurt(){
	lives --;
    }

    public void checkAlive(){
	if (lives == 0) alive = false;
    }

    
}

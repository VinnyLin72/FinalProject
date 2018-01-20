import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hazard extends Rectangle{
    int x;
    int y = -20;
    int ya = 1;
    boolean spawn = true;
    int count;

    private FinalProject game;

    public Hazard(FinalProject game){
	this.game = game;
	randX();
    }

    private void randX(){
	x = (((int)(Math.random() * 4 * 50)) + 20)%160;
    }

    public Rectangle getBounds(){
	return new Rectangle (x,y,20,30);
    }

    public boolean playerCollision(){
	if(getBounds().intersects(game.player.getBounds())){
	    game.player.hurt();
	    return true;
	}
	return false;
    }

    public void move(){
	y += ya;
    }
    public void paint(Graphics g){ 
	g.fillRect(x,y,20,30);
    }
}

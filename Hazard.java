import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hazard extends Rectangle{
    int x;
    int y = -50;
    int xa = 0;
    int ya = 0;

    private FinalProject game;

    public Hazard(FinalProject game){
	this.game = game;
	x = (int)(Math.random() * 10) * 20;
    }

    public void playerCollision(){
	if(new Rectangle(x,y,10,15).intersects(new Rectangle(game.player.x, game.player.y, 30, 30))){
	    game.player.hurt();
	}
    }

    public void move(){
	y ++;
    }
    public void paint(Graphics g){
	g.fillRect(x,y,10,15);
    }
}

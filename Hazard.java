import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Hazard extends Rectangle{
    int x;
    int y = -20;
    int ya = 1;
    boolean spawn = true;
    private BufferedImage image;
    

    private FinalProject game;

    public Hazard(FinalProject game){
	this.game = game;
	randX();
	int imRand=(int)(Math.random()*4);
	try{
	    image = ImageIO.read(new File("poopyprojectile0"+imRand+".png"));
	}catch(IOException e){
	    e.printStackTrace();
	}
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
	//g.fillRect(x,y,20,30);
	g.drawImage(image, x, y, null);
    }
}

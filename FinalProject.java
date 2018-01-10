import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

<<<<<<< HEAD
public class FinalProject extends JPanel{
    public Player player = new Player(this);
    
   
    private void move(){
	player.move();
    }
    public void paint(Graphics g){
	super.paint(g);
	player.paint(g);
    }

    public static void main (String[]args)throws InterruptedException{
	JFrame frame = new JFrame("game");
	FinalProject game = new FinalProject();
	frame.add(game);
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	while (true){
	    game.move();
	    game.repaint();
	    Thread.sleep(10);
	}
    }
=======
public class FinalProject extends Jframe implements keyListener{
    private container pane;
    private Rectangle player, hazard;
    
>>>>>>> master
}

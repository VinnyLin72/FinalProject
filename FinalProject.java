import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject extends JPanel{
    public Player player = new Player(this);
    
    /* public void keyPressed(KeyEvent e){
	
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){
	char s = e.getKeyChar();
	System.out.println(s + "");
    }
    */
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
}

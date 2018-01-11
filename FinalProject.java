import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject extends JPanel implements KeyListener{
    public Player player = new Player(this);

    public void keyPressed(KeyEvent e) {
	int k = e.getKeyCode();
	if (k == KeyEvent.VK_DOWN)player.test();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e){

    }
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
	frame.addKeyListener();
	while (true){
	    game.move();
	    game.repaint();
	    Thread.sleep(10);
	}
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class FinalProject extends JPanel{
    Player player = new Player(this);
    Hazard hazard = new Hazard(this);
    public JLabel liveCounter;

    public FinalProject(){
	addKeyListener(new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		    player.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
		    player.keyPressed(e);
		}
	    });
	setFocusable(true);
	liveCounter = new JLabel(""+player.getLives());
	liveCounter.setHorizontalAlignment(2);
	liveCounter.setVerticalAlignment(1);
    }
    
    private void move(){
      	player.move();
	hazard.move();
    }

    Graphics h2d;
    
    public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		player.paint(g2d);
		hazard.paint(g2d);
    }

    public static void main (String[]args)throws InterruptedException{
	JFrame frame = new JFrame("game");
	FinalProject game = new FinalProject();
	frame.add(game);
	//	frame.add(game.liveCounter);
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	while (true){
	    game.move();
	    game.hazard.playerCollision();
	    //	    game.liveCounter.setText(""+game.player.getLives());
	    game.repaint();
	    Thread.sleep(10);
	    System.out.println(game.player.getLives());
	}
    }
}

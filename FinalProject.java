import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("serial")
public class FinalProject extends JPanel{
    Player player = new Player(this);
    Hazard hazard = new Hazard(this);
    public ArrayList<Hazard> hazards = new ArrayList<Hazard>();
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
	for(Hazard x: hazards){
	    x.move();
	}
    }

    Graphics h2d;
    
    public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		player.paint(g2d);
		hazard.paint(g2d);
		for(Hazard x: hazards){
		    x.paint(g2d);
		}
    }

    public void gameOver(){
	JOptionPane.showMessageDialog(this, "Game Over" , "Game Over", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
    }

    public static void main (String[]args)throws InterruptedException{
	JFrame frame = new JFrame("game");
	FinalProject game = new FinalProject();
	frame.add(game);
	//	frame.add(game.liveCounter);
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new hazardSpawn(game),3000, 300);
	while (game.player.alive){
	    game.move();
	    game.hazard.playerCollision();
	    for(Hazard x: game.hazards){
		x.playerCollision();
	    }
	    //	    game.liveCounter.setText(""+game.player.getLives());
	    game.repaint();
	    Thread.sleep(10);
	    game.player.checkAlive();
	    System.out.println(game.player.getLives());
	}
	game.gameOver();
    }
}

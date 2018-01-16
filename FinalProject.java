import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("serial")
public class FinalProject extends JPanel{
    Player player = new Player(this);
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
	liveCounter.setSize(10,10);
    }
    
    private void move(){
      	player.move();
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
		for(Hazard x: hazards){
		    x.paint(g2d);
		}
    }

    public void gameOver(){
	JOptionPane.showMessageDialog(this, "Game Over" , "Game Over", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
    }

    public void cleanUpHazards(){
	for (int i = 0; i < hazards.size(); i ++){
	    if (hazards.get(i).y > 500) hazards.remove(i);
	}
    }

    public void keepPlayerInBounds(){
	while(player.x > 200){
	    player.x--;
	}
	while(player.x < 0){
	    player.x++;
	}
	while(player.y > 500){
	    player.y--;
	}
	while(player.y < 0){
	    player.y++;
	}
    }

    public static void main (String[]args)throws InterruptedException{
	JFrame frame = new JFrame("game");
	FinalProject game = new FinalProject();
	frame.add(game);
	//	frame.add(game.liveCounter);
	frame.setSize(200,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new hazardSpawn(game),500, 750);
	int Score = 0;
	while (game.player.alive){
	    game.move();
	    for(int i = 0; i < game.hazards.size(); i ++){
		game.hazards.get(i).playerCollision();
	    }
	    
	    game.cleanUpHazards();
	    //  game.liveCounter.setText(""+game.player.getLives());
	    game.keepPlayerInBounds();
	    game.repaint();
	    Thread.sleep(10);
	    game.player.checkAlive();
	    Score += 1;
	    System.out.println(Score / 10);
	    System.out.println(game.player.getLives());
	}
	game.gameOver();
    }
}

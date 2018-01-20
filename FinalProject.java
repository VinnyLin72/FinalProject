import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("serial")
public class FinalProject extends JPanel{
    private JFrame frame;
    private JPanel pane;
    public Player player = new Player(this);
    ArrayList<Hazard> hazards = new ArrayList<Hazard>();
    private JTextField liveCounter;
    private int score;
    private int hiscore;
    private int level = 1;
    private int nextLevelScore = 2000;
    private Timer timer = new Timer();
    private int amount = 1;
    private int timeBetweenSpawn = 500;

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
    }

    private void initGame(FinalProject game){
	frame = new JFrame("Game");
	frame.add(game);
       	frame.setSize(200,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	timer.scheduleAtFixedRate(new hazardSpawn(game),0, 500);
        }

    public int getScore(){
	return score/10;
    }

    public void addScore(){
	score ++;
    }

    public int getHiScore(){
	return hiscore;
    }

    public void updateHiScore(){
	if (score > hiscore){
	hiscore = score/10;
	}
    }
    private void update(){
      	player.move();
	keepPlayerInBounds();
	for(int i = 0; i < hazards.size(); i ++){
	    hazards.get(i).move();
	    if (hazards.get(i).playerCollision()){
		    hazards.remove(i);
		}
	}
	addScore();
	updateHiScore();
	cleanUpHazards();
	repaint();
	levelUp();
    }

    public void paint(Graphics g){
	super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			     RenderingHints.VALUE_ANTIALIAS_ON);
	player.paint(g2d);
	for(int i = 0; i < hazards.size(); i ++){
	    hazards.get(i).paint(g2d);
	}
	g.drawString("Score: " + getScore() + "   Lives: " + player.getLives() + "   Level: " + level, 10, 25);
    }

    public void gameOver(int s, int h){
	JOptionPane.showMessageDialog(this, "Game Over \nYour Score is: " + s + "\nThe Highest Score is: " + h, "Game Over", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
    }

    public void cleanUpHazards(){
	for (int i = 0; i < hazards.size(); i ++){
	    if (hazards.get(i).y > 500) hazards.remove(i);
	}
    }

    public void keepPlayerInBounds(){
	while(player.x > 170){
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

    public void levelUp(){
	if(score >= nextLevelScore){
	    level++;
	    timeBetweenSpawn /= 9/8;
	    nextLevelScore = (nextLevelScore + 700)/4*5;
	    if(level % 10 == 0){
		amount++;
	    }
	
	    timer.cancel();
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new hazardSpawn(this, amount),12, timeBetweenSpawn);
	}
    }

    public int getLevel(){
	return level;
    }

    public static void main (String[]args)throws InterruptedException{
	FinalProject game = new FinalProject();
	game.initGame(game);
	if(args[0].equals("dev")){
	    game.player.godPower(Integer.parseInt(args[1]));
	}

	while (game.player.checkAlive()){
	    game.update();
	    Thread.sleep(5);
	    //System.out.println("Score: " + game.getScore() / 10);
	    //System.out.println("Lives: " + game.player.getLives());
	    // System.out.println("Level: " + game.getLevel());
	}
	game.gameOver(game.getScore(), game.getHiScore());
    }
}

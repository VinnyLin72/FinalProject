import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject extends JFrame implements KeyListener{
    private Container pane;
    private Player player = new Player();

    public FinalProject(){
	this.setTitle("Our Game");
	this.setSize(600,800);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();

	

	/*pane.add(player);*/
    }

    public void keyPressed(KeyEvent e){
	char s = e.getKeyChar();
	System.out.println(s + "");
	
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){
	char s = e.getKeyChar();
	System.out.println(s + "");
    }

    public static void main(String[]args){
	FinalProject g = new FinalProject();
	g.setVisible(true);
    }
}

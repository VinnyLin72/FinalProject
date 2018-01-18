import java.util.Timer;
import java.util.TimerTask;

public class LevelUp extends TimerTask{
    FinalProject game;

    public LevelUp(FinalProject g){
	game = g;
    }

    public void run(){
	game.levelup();
    }
}

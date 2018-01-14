import java.util.Timer;
import java.util.TimerTask;

public class hazardSpawn extends TimerTask{
    FinalProject game;
    
    public hazardSpawn(FinalProject g){
	game = g;
    }
    
    public void run(){
	game.hazards.add(new Hazard(game));
    }
}

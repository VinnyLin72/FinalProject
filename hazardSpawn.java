import java.util.Timer;
import java.util.TimerTask;

public class hazardSpawn extends TimerTask{
    FinalProject game;
    int amount = 1;

    public hazardSpawn(FinalProject g){
	game = g;
    }
    
    public hazardSpawn(FinalProject g, int a){
	game = g;
	amount = a;
    }
    
    public void run(){
	for(int x = 0; x < amount; x++){
	    game.hazards.add(new Hazard(game));
	}
    }
}

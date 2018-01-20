import java.util.Timer;
import java.util.TimerTask;

public class damageInvincibility extends TimerTask{
    public Timer t;
    public Player player;
    
    public damageInvincibility(Player p){
	player = p;
	t = new Timer();
	t.schedule(this, 1000);
    }

    public void run(){
	player.invincibleStop();
	t.cancel();
    }
}

package spacegame;

import java.util.concurrent.TimeUnit;

public class ScoreThread extends Thread {

	public void run() {
		while (Variables.running == true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Variables.score = Variables.score + Variables.scoreIncrement;
		}
	}
}

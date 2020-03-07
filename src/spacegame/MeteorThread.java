package spacegame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MeteorThread extends Thread {
	
	public void run(){
		while (Variables.running == true) {
			Variables.meteorMedianPosition = 0;
			while (Variables.meteorMedianPosition < 2400) {
				try {
					TimeUnit.MILLISECONDS.sleep(Variables.meteorSpeed);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				Variables.meteorMedianPosition = Variables.meteorMedianPosition + 10;
			}
		}

	}

}

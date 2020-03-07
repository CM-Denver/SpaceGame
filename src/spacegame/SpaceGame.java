package spacegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SpaceGame extends JFrame {

	public SpaceGame() throws IOException {
		JFrame frame = new JFrame("Space Game");
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setFocusable(true);
		
		DrawStuff canvas = new DrawStuff();
		
		canvas.setBackgroundImage(Variables.backgroundFile);
		canvas.setSpriteImage(Variables.spriteFile);
		canvas.setEnemyImage(Variables.enemyFile);
		canvas.addMeteors(Variables.meteorCount);
		
		frame.add(canvas);
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					if (Variables.y > 0) {
						Variables.y = Variables.y - 10;
					}
					break;
				case KeyEvent.VK_DOWN:
					if (Variables.y < 600) {
						Variables.y = Variables.y + 10;
					}
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		MeteorThread meteorThread = new MeteorThread();
		meteorThread.start();
		
		ScoreThread scoreThread = new ScoreThread();
		scoreThread.start();
		
		while (true) {
			canvas.repaint();
			for (int i = 0; i <= canvas.meteorCount - 1; i++) {
				int[] meteor = canvas.meteors.get(i);
				if (Variables.x == meteor[0] - Variables.meteorMedianPosition && Variables.y == meteor[1]) {
					System.out.println(Variables.score);
					if (Variables.running == true) {
						JOptionPane.showMessageDialog(frame, "You Crashed! Score: " + Variables.score);
					}
					Variables.running = false;
				}
				else if (Variables.x == meteor[0] - Variables.meteorMedianPosition && (Variables.y - 10 == meteor[1] || Variables.y - 20 == meteor[1])) {
					System.out.println(Variables.score);
					if (Variables.running == true) {
						JOptionPane.showMessageDialog(frame, "You Crashed! Score: " + Variables.score);
					}
					Variables.running = false;
				}
				else if (Variables.x == meteor[0] - Variables.meteorMedianPosition && (Variables.y + 10 == meteor[1] || Variables.y + 20 == meteor[1])) {
					System.out.println(Variables.score);
					if (Variables.running == true) {
						JOptionPane.showMessageDialog(frame, "You Crashed! Score: " + Variables.score);
					}
					Variables.running = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new SpaceGame();

	}

}

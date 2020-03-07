package spacegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class DrawStuff extends JComponent {
	
	private BufferedImage bgImage;
	private BufferedImage spriteImage;
	private BufferedImage enemyImage;
	
	public int meteorCount = 0;
	public ArrayList<int[]> meteors = new ArrayList<int[]>();
	
	public void setBackgroundImage(String fileName) throws IOException {
		File img = new File(fileName);
		bgImage = ImageIO.read(img);
	}
	
	public void setSpriteImage(String fileName) throws IOException {
		File img = new File(fileName);
		spriteImage = ImageIO.read(img);
	}
	
	public void setEnemyImage(String fileName) throws IOException {
		File img = new File(fileName);
		enemyImage = ImageIO.read(img);
	}
	
	public void addMeteors(int amount) {
		while (meteorCount <= amount) {
			Random random = new Random();
			int x = (random.nextInt(180) * 10) + 600;
			int y = random.nextInt(60) * 10;
			
			int[] meteor = new int[2];
			meteor[0] = x;
			meteor[1] = y;
			
			meteors.add(meteor);
			meteorCount = meteorCount + 1;
		}
	}
	
	public void paint(Graphics g) {
		
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		graph2.drawImage(bgImage, 0, 0, (ImageObserver) this);
		
		graph2.drawImage(spriteImage, Variables.x, Variables.y - (spriteImage.getHeight() / 2), (ImageObserver) this);
	
		int i = 0;
		
		while (i <= meteorCount - 1) {
			int[] meteor = meteors.get(i);
			graph2.drawImage(enemyImage, meteor[0] - Variables.meteorMedianPosition - (enemyImage.getWidth() / 2), meteor[1] - (enemyImage.getHeight() / 2), (ImageObserver) this);
			i = i + 1;
		}
	}

}

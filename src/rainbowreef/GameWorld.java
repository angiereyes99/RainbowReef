package rainbowreef;

import rainbowreef.gameobjects.Reef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import static javax.imageio.ImageIO.read;

public class GameWorld extends JPanel {

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
  	public static final int SCREEN_WIDTH = 640;
  	public static final int SCREEN_HEIGHT = 470;

  	private BufferedImage world;
  	private Graphics2D buffer;
  	private JFrame jf;

  	private Katch katch;
  	private Reef reef;
  	private Map background;

  	private static Thread thread;
  	private static boolean start = false;

	public static void main(String[] args) throws InterruptedException {
		Thread x;
		thread = new Thread();
		GameWorld game = new GameWorld();
		game.init();
		for (int i=3; i >= 0; i--) {
			thread.sleep(1000);
			System.out.println(i);
			if (i == 0) {
				start = true;
			}
		}
		try {
			while(start) {
				game.katch.update();
				game.reef.update();
				game.repaint();
				System.out.println(game.katch);
				Thread.sleep(1000/144);
			}
			} catch (InterruptedException ignored) {
		}
	}

	private void init() {
		this.jf = new JFrame("Rainbow Reef");
		this.world = new BufferedImage(GameWorld.GAME_WIDTH, GameWorld.GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
		BufferedImage katchImg = null, reefImg = null;
		try {
			System.out.println(System.getProperty("user.dir"));
			katchImg = read(new File("resources/Katch.gif"));
			reefImg = read(new File("resources/pop.gif"));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		katch = new Katch(280,410,0,0,katchImg);
		reef = new Reef(280,340,-1,-2,reefImg);

		background = new Map();
		background.init();

		KatchControl kc = new KatchControl(katch, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		
		this.jf.setLayout(new BorderLayout());
 		this.jf.add(this);
 		this.jf.addKeyListener(kc);
 		this.jf.setSize(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT + 30);
 		this.jf.setResizable(false);
 		jf.setLocationRelativeTo(null);
 		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		this.jf.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		buffer = world.createGraphics();
		super.paintComponent(g2);

		this.background.drawImage(buffer);
		this.katch.drawImage(buffer);
		this.reef.drawImage(buffer);

		g2.drawImage(world,0,0,null);

		g2.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2.setColor(Color.BLACK);
        g2.drawString("Lives :" + this.reef.getLives(), 25, 445);
        if (this.reef.getLives() == 0) {
        	g2.drawString("GAME OVER", 190,445);
    	}
        g2.drawString("Score : " + this.reef.getPoints(), 470, 445);
	}
}
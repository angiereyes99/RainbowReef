package rainbowreef.gameobjects;

import java.awt.*;
import java.util.*;
import java.awt.image.*;

public abstract class GameObjects {
	protected int x;
	protected int y;
	protected int vx;
	protected int vy;
	protected BufferedImage img;
	private Rectangle bounds;
	public static ArrayList<GameObjects> gameObjects = new ArrayList<>();

	public GameObjects(int x, int y, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.bounds = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
	}

	public Rectangle getBounds() {
		return this.bounds;
	}

	public void updateBounds() {
		this.bounds = new Rectangle(this.x, this.y, img.getWidth(), img.getHeight());
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void drawImage(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img,x,y,null);
	}
}
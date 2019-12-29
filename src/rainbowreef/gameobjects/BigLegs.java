package rainbowreef.gameobjects;

import rainbowreef.gameobjects.GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BigLegs extends GameObjects {

	private Rectangle bounds;

	public BigLegs(BufferedImage img, int x, int y) {
		super(x,y,img);
		this.bounds = new Rectangle(x,y,this.img.getWidth(),this.img.getHeight());
		gameObjects.add(this);
	}
}
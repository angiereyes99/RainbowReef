package rainbowreef;

import rainbowreef.gameobjects.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import static javax.imageio.ImageIO.read;

public class Map {

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static ArrayList<GameObjects> objects = new ArrayList<>();
	private BufferedImage background, wall, redbrick, yellowbrick, bluebrick, purplebrick, greenbrick, healthbrick, doublebrick, starbrick, tealbrick, biglegs;

	public Map() { }

	public void init() {
		try {
			wall = read(new File("resources/Wall.gif"));
			biglegs = read(new File("resources/Bigleg.gif"));
			redbrick = read(new File("resources/Block3.gif"));
			bluebrick = read(new File("resources/Block6.gif"));
			tealbrick = read(new File("resources/Block5.gif"));
			greenbrick = read(new File("resources/Block4.gif"));
			yellowbrick = read(new File("resources/Block2.gif"));
			purplebrick = read(new File("resources/Block1.gif"));
			starbrick = read(new File("resources/Block_split.gif"));
			healthbrick = read(new File("resources/Block_life.gif"));
			background = read(new File("resources/Background2.bmp"));
			doublebrick = read(new File("resources/Block_double.gif"));
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		placeWalls();
		placeBigLeg();
		placeRedBrick();
		placeBlueBrick();
		placeTealBrick();
		placeStarBrick();
		placeGreenBrick();
		placeYellowBrick();
		placePurpleBrick();
		placeHealthBrick();
		placeDoubleBrick();
	}

	void drawImage(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i=0; i<GAME_WIDTH/background.getWidth()+1; i++) {
			for (int j=0; j<GAME_HEIGHT/background.getHeight()+1; j++) {
				g2.drawImage(background, i*background.getWidth(), j*background.getHeight(), null);
			}
		}
		for (int i=0; i<objects.size(); i++) {
			objects.get(i).drawImage(g2);
		}
	}

	private void placeDoubleBrick() {
		for (int i=220; i<360; i+=40) {
			objects.add(new DoubleBrick(doublebrick,i,200));
		}
	}

	private void placeBigLeg() {
		objects.add(new BigLegs(biglegs,150,20));
		objects.add(new BigLegs(biglegs,300,80));
		objects.add(new BigLegs(biglegs,300,20));
	}

	private void placeHealthBrick() {
		for (int i=20; i<70; i+=40) {
			objects.add(new Health(healthbrick,i,20));
		}
		objects.add(new Health(healthbrick,140,160));
	}

	private void placeStarBrick() {
		objects.add(new StarBrick(starbrick,20,120));
		objects.add(new StarBrick(starbrick,60,140));
		objects.add(new StarBrick(starbrick,580,20));
		objects.add(new StarBrick(starbrick,460,200));
	}

	private void placeRedBrick() {
		for (int i=40; i<120; i+=20) {
			objects.add(new RedBrick(redbrick,20,i));
			objects.add(new RedBrick(redbrick,60,i));
		}
		for (int i=40; i<260; i+=20) {
			objects.add(new RedBrick(redbrick,580,i));
		}
	}

	private void placeBlueBrick() {
		for (int i=20; i<80; i+=20) {
			for (int j=260; j<340; j+=40) {
				objects.add(new BlueBrick(bluebrick,220,i));
				objects.add(new BlueBrick(bluebrick,340,i));
				objects.add(new BlueBrick(bluebrick,j,60));
			}
		}
	}

	private void placeTealBrick() {
		for (int i=160; i<260; i+=20) {
			objects.add(new TealBrick(tealbrick,180,i));
		}
		for (int i=180; i<260; i+=20) {
			objects.add(new TealBrick(tealbrick,140,i));
		}
		for (int i=420; i<540; i+=40) {
			objects.add(new TealBrick(tealbrick,i,120));
			objects.add(new TealBrick(tealbrick,i,140));
		}
	}

	private void placeYellowBrick() {
		for (int i=60; i<160; i+=20) {
			objects.add(new YellowBrick(yellowbrick,140,i));
			objects.add(new YellowBrick(yellowbrick,180,i));
		}
		for (int i=420; i<540; i+=40) {
			objects.add(new YellowBrick(yellowbrick,i,20));
			objects.add(new YellowBrick(yellowbrick,i,80));
			objects.add(new YellowBrick(yellowbrick,i,100));
		}
	}

	private void placeGreenBrick() {
		for (int i=140; i<260; i+=20) {
			objects.add(new GreenBrick(greenbrick,20,i));
		}
		for (int i=160; i<260; i+=20) {
			objects.add(new GreenBrick(greenbrick,60,i));
		}
		for (int i=420; i<540; i+=40) {
			objects.add(new GreenBrick(greenbrick,i,160));
			objects.add(new GreenBrick(greenbrick,i,180));
		}
		objects.add(new GreenBrick(greenbrick,60,120));
	}

	private void placeWalls() {
		//******* WALLS ON TOP OF MAP *******//
	    for (int i=0 ; i < 620; i+=20) {
	    	objects.add(new Wall(wall,i,0));
	    }
	    //******* WALLS ON LEFT OF MAP *******//
	    for (int i=0; i < 480; i+=20) {
	    	objects.add(new Wall(wall,0,i));
	    }	
	    //******* WALLS ON RIGHT OF MAP *******//
	    for (int i=0; i < 480; i+=20) {
	    	objects.add(new Wall(wall,620,i));
	    }
	    for (int i=20; i<260; i+=20) {
	    	objects.add(new BlueBrick(bluebrick,100,i));
	    	objects.add(new TealBrick(tealbrick,540,i));
	    	objects.add(new GreenBrick(greenbrick,380,i));
		}
	}

	private void placePurpleBrick() {
		for (int i=80; i<200; i+=20) {
			objects.add(new PurpleBrick(purplebrick,220,i));
			objects.add(new PurpleBrick(purplebrick,340,i));
		}
		for (int i=140; i<200; i+=20) {
			objects.add(new PurpleBrick(purplebrick,260,i));
			objects.add(new PurpleBrick(purplebrick,300,i));
		}
		for (int i=200; i<260; i+=20) {
			objects.add(new PurpleBrick(purplebrick,420,i));
			objects.add(new PurpleBrick(purplebrick,500,i));
		}
		for (int i=220; i<260; i+=20) {
			objects.add(new PurpleBrick(purplebrick,460,i));
		}
		for (int i=220; i<360; i+=40) {
			objects.add(new PurpleBrick(purplebrick,i,220));
			objects.add(new PurpleBrick(purplebrick,i,240));
		}
		for (int i=260; i<340; i+=40) {
			objects.add(new PurpleBrick(purplebrick,i,120));
		}
	}
}
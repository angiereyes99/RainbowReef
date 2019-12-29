package rainbowreef;

import java.awt.event.*;

public class KatchControl implements KeyListener {

	private Katch katch;
	private final int left;
	private final int right;

	public KatchControl(Katch katch, int left, int right) {
		this.katch = katch;
		this.left = left;
		this.right = right;
	}

	@Override
	public void keyTyped(KeyEvent ke) {

	}

	@Override
	public void keyPressed(KeyEvent ke) {
		int keyPressed = ke.getKeyCode();
		if (keyPressed == left) this.katch.toggleLeftPressed();
		if (keyPressed == right) this.katch.toggleRightPressed();
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		int keyReleased = ke.getKeyCode();
		if (keyReleased == left) this.katch.unToggleLeftPressed();
		if (keyReleased == right) this.katch.unToggleRightPressed();
	}
	
}
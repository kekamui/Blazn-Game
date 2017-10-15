//Steven Sung

//package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class box extends GameObject
{
	//instantiate variable of the box
	private int currenty;
	private int currentx;
	private String direction;
	private Shooter shooter;

	//creates a box and objects in relation to the box
	public box(int positionx, int positiony, int width, int height)
	{
		this.rect = new Rectangle(positionx, positiony, width, height);
	}

	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	Image getImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void update(Shooter shooter) {
		// TODO Auto-generated method stub

	}



}

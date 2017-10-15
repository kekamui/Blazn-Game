import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.*;


//the class that player,slender, boss, and box branch off from
public abstract class GameObject
{
	public Image img;
	public int currentx, currenty, height, width, health;
	public int bossx,bossy;

	//rectangle for collisions
	public Rectangle rect;

	abstract void draw(Graphics g);

	abstract Image getImage(String string);

	abstract void update(Shooter shooter);


//creates the getters and setters
		public Image getImg()
		{
			return img;
		}
		public int getX()
		{
			return currentx;
		}
		public int getY()
		{
			return currenty;
		}
		public int getHeight()
		{
			return height;
		}
		public int getWidth()
		{
			return width;
		}
		public int getHealth()
		{
			return health;
		}

		public void setHealth(int health)
		{
			this.health = health;
		}

		public void setX(int x)
		{
			currentx = x;
		}

		public void setY(int y)
		{
			currenty = y;
		}

		public void setImage(Image img)
		{
			this.img = img;
		}
		public void setHeight(int height)
		{
			this.height = height;
		}
		public void setWidth(int width)
		{
			this.width= width;
		}







}
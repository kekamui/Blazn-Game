
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.concurrent.CopyOnWriteArrayList;

public class RightBullet extends GameObject
{
	public CopyOnWriteArrayList<Slender> slender,slender1,slender2;
	public Boss boss;
	public CopyOnWriteArrayList<box> boxes;
	public int direction;
	//CopyOnWriteArrayList<Bullet> b = new CopyOnWriteArrayList<Bullet>();

	public RightBullet(CopyOnWriteArrayList<Slender> slender,CopyOnWriteArrayList<Slender> slender1,CopyOnWriteArrayList<Slender> slender2,Boss boss, CopyOnWriteArrayList<box> boxes,int x, int y,int width, int height, String img)
	{
		this.slender = slender;
		this.slender1 = slender1;
		this.slender2 = slender2;

		this.boss = boss;

		this.boxes = boxes;

		currentx = x;
		currenty = y;
		this.height = height;
		this.width = width;
		this.img = getImage(img);
		this.rect = new Rectangle(x, y,width,height);
	}

	@Override
	public void draw(Graphics g)
	{
		g.drawImage(img,currentx,currenty,width,height,null);
	}

	@Override
	void update(Shooter shooter)
	{
			for(box box: boxes)
			{
				//when intersect, delete
				if(rect.intersects(box.rect))
				{
					shooter.rightbullets.remove(this);
				}

		}


/**
* goes through the enemies of each wave individually
* removes itself if a certain condition is fulfilled
*/

 if (shooter.getWave() == 1)
{
			for(Slender slender: slender)
			{
		if(rect.intersects(slender.rect))
		{
			slender.setHealth(slender.getHealth()-1);
			shooter.rightbullets.remove(this);
		}
		else if (currentx < 0 || currentx > 1000 || currenty < 0 || currenty > 1000)
			shooter.rightbullets.remove(this);
		else
		{

				currentx+= 5;
				rect.x+=5;


		}
			}
}
 else if (shooter.getWave() == 2)
{
			for(Slender slender1: slender1)
			{
		if(rect.intersects(slender1.rect))
		{
			slender1.setHealth(slender1.getHealth()-1);
			shooter.rightbullets.remove(this);
		}
		else if (currentx < 0 || currentx > 1000 || currenty < 0 || currenty > 1000)
			shooter.rightbullets.remove(this);
		else
		{

				currentx+= 5;
				rect.x+=5;


		}
	}


		}
else if (shooter.getWave() == 3)
{
			for(Slender slender2: slender2)
			{
		if(rect.intersects(slender2.rect))
		{
			slender2.setHealth(slender2.getHealth()-1);
			shooter.rightbullets.remove(this);
		}
		else if (currentx < 0 || currentx > 1000 || currenty < 0 || currenty > 1000)
			shooter.rightbullets.remove(this);
		else
		{

				currentx+= 5;
				rect.x+=5;


		}
			}
		}
else if (shooter.getWave() == 4)
{

		if(rect.intersects(boss.rect))
		{
			boss.setHealth(boss.getHealth()-1);
			shooter.rightbullets.remove(this);
		}
		else if (currentx < 0 || currentx > 800 || currenty < 0 || currenty > 800)
			shooter.rightbullets.remove(this);
		else
		{

				currentx+=5;
				rect.x+=5;

		}
}
	}



 Image getImage(String img)
{
	return Toolkit.getDefaultToolkit().getImage(img);

}

}
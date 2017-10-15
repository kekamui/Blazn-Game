
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.concurrent.*;

public class BossUpBullet extends GameObject
{
	public Player player;
	public int direction;
	public CopyOnWriteArrayList<box> boxes;
	//CopyOnWriteArrayList<Bullet> b = new CopyOnWriteArrayList<Bullet>();

	public BossUpBullet(Player player,CopyOnWriteArrayList<box> boxes, int x, int y,int width, int height, String img)
	{
		this.player = player;

		this.boxes = boxes;

		bossx = x;
		bossy = y;
		this.height = height;
		this.width = width;
		this.img = getImage(img);
		this.rect = new Rectangle(x, y,width,height);
	}

	@Override
	public void draw(Graphics g)
	{
		g.drawImage(img,bossx,bossy,width,height,null);
	}

	@Override
	void update(Shooter shooter)
	{
		for(box box: boxes)
		{
			//when intersect, delete
			if(rect.intersects(box.rect))
			{
				shooter.bossupbullets.remove(this);
			}

		}

//conditions for the bullet
		if(rect.intersects(player.rect))
		{
			player.setHealth(player.getHealth()-50);
			shooter.bossupbullets.remove(this);
		}
		else if (bossx < 0 || bossx > 800 || bossy < 0 || bossy > 800)
			shooter.bossupbullets.remove(this);
		else
		{

				bossy-=5;
				rect.y-=5;

		}
}



 Image getImage(String img)
{
	return Toolkit.getDefaultToolkit().getImage(img);

}

}
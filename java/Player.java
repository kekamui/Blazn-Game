//Kevin Mui

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.concurrent.*;

public class Player extends GameObject
{

	private CopyOnWriteArrayList<Slender> slender,slender1,slender2;
	private Boss boss;

	public Player(int x, int y,int width, int height, int health,String img)
	{
		currentx = x;
		currenty = y;
		this.height = height;
		this.width = width;
		this.img = getImage(img);
		this.health = health;
		this.rect = new Rectangle(x, y,width,height);
	}

	@Override
	public void draw(Graphics g)
	{
		g.drawImage(img,currentx,currenty,width,height,null);
	}

	void update(Shooter shooter)
	{

//collisions
		if(currenty >= 800 - 60)
			currenty = 800 - 60;
		if(currenty <= -5)
			currenty = -5;
		if(currentx >= 800 - 60)
			currentx = 800 - 60;
		if(currentx <= 10)
			currentx = 10;

		//collisions for square 1
		if (currentx >= 36 && currentx <= 39 && currenty >= 31 && currenty <= 338)
			currentx -=2;
		if (currentx <= 332 && currentx >= 329 && currenty >= 31 && currenty <= 338)
			currentx +=2;
		if (currentx >= 37 && currentx <= 331 && currenty >= 31 && currenty <= 34)
			currenty-=2;
		if (currentx >= 37 && currentx <= 331 && currenty <= 339 && currenty >= 334)
			currenty+=2;

		//Collisions for square 2
		if (currentx >= 36 && currentx <= 39 && currenty >= 410 && currenty <= 718)
			currentx-=2;
		if (currentx >= 329 && currentx <= 332 && currenty >= 410 && currenty <= 718)
			currentx+=2;
		if (currentx >= 37 && currentx <= 331 && currenty >= 410 && currenty <= 414)
			currenty-=2;
		if (currentx >= 37 && currentx <= 331 && currenty >= 715 && currenty <= 719)
			currenty+=2;

		//collisions for square 3
		if (currentx >= 417  && currentx <= 420 && currenty >= 31 && currenty <= 338)
			currentx-=2;
		if (currentx <= 712 && currentx >= 709 && currenty >= 31 && currenty <= 338)
			currentx+=2;
		if (currentx >= 418 && currentx <= 711 && currenty >= 31 && currenty <= 34)
			currenty-=2;
		if (currentx >= 418 && currentx <= 711 && currenty >= 334 & currenty <= 339)
			currenty+=2;

		//collision for square 4
		if (currentx >= 417 && currentx <= 420 && currenty >= 410 && currenty <= 718)
			currentx-=2;
		if (currentx <= 712 && currentx >= 709 && currenty >= 410 && currenty <= 718)
			currentx+=2;
		if (currentx >= 418 && currentx <= 711 && currenty >= 410 && currenty <= 414)
			currenty-=2;
		if (currentx >= 418 && currentx <= 711 && currenty >= 715 && currenty <= 719)
			currenty+=2;


//moves the player according to the button pressed

		if (shooter.playerUP )
			{
				if(currenty!=0)
				currenty-=2;
				rect.y-=2;
			}
		else if (shooter.playerDOWN)
		{
			if(currenty!=1000)
			currenty+=2;
			rect.y+=2;
		}

		else if(shooter.playerLEFT)
		{
			if(currentx!=0)
			currentx-=2;
			rect.x-=2;
		}
		else if(shooter.playerRIGHT)
		{
			if(currentx!=1000)
			currentx+=2;
			rect.x+=2;
		}

//tests to see if player intersects with the enemy of each wave individually
if(shooter.getWave() == 1)
{
			for(Slender slender: slender)
			{
		if(rect.intersects(slender.rect))
		{
			this.setHealth(this.getHealth()-2);
		}

	}
}
if(shooter.getWave() == 2)
{
			for(Slender slender: slender1)
			{
		if(rect.intersects(slender.rect))
		{
			this.setHealth(this.getHealth()-2);
		}

	}
}
if(shooter.getWave() == 3)
{
			for(Slender slender: slender2)
			{
		if(rect.intersects(slender.rect))
		{
			this.setHealth(this.getHealth()-2);
		}

	}
}
if(shooter.getWave() == 4)
{

		if(rect.intersects(boss.rect))
		{
			this.setHealth(this.getHealth()-2);
		}

}

	}

//gets all the necessary data from the Shooter class
public void getSlender(CopyOnWriteArrayList<Slender> slender,CopyOnWriteArrayList<Slender> slender1,CopyOnWriteArrayList<Slender> slender2,Boss boss)
{
	this.slender = slender;
	this.slender1 = slender1;
	this.slender2 = slender2;
	this.boss = boss;

}

Image getImage(String img)
{
	return Toolkit.getDefaultToolkit().getImage(img);

}

}//end

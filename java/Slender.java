

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Slender extends GameObject
{

		private int currenty;
		private int currentx;
		public int ygoal,xgoal;
		public int xdiff = 0, ydiff = 0;
		private int health;
		private int width,height;
		private Image img;
		public boolean alive = true;;

//takes the player position as well
		public Slender(int me_x, int me_y,int you_x, int you_y, int width, int height, int health, String img) //input the position of a randomized location and of the main user
		{
			currenty = me_y;
			currentx = me_x;
			ygoal = you_y;
			xgoal = you_x;
			this.health = health;
			this.img = getImage(img);
			this.width = width;
			this.height = height;
			this.rect = new Rectangle(currentx, currenty,width,height);
		}


		//@Override
		public void draw(Graphics g)
		{
			g.drawImage(img,currentx,currenty,width,height,null);
		}

		public void update(Shooter shooter, int you_x, int you_y)
		{
			//moves by looking at the difference in position
			ygoal = you_y;
			xgoal = you_x;
			move();

		}

		public void setRect()
		{
			this.rect = new Rectangle(1000,1000,0,0);
		}

		public void setHealth(int h)
		{
			health = h;
		}


		public void move()
		{

//moves by looking at the difference in position
			ydiff = ygoal-currenty;
			xdiff = xgoal-currentx;

			//move the character
			if (ydiff > 0)
				currenty += 1;
			else if (ydiff < 0)
				currenty -= 1;
			if(xdiff > 0)
				currentx += 1;
			else if (xdiff < 0)
				currentx -= 1;

			if (currentx >= 36 && currentx <= 39 && currenty >= 31 && currenty <= 338)
				currentx -=1;
			if (currentx <= 332 && currentx >= 329 && currenty >= 31 && currenty <= 338)
				currentx +=1;
			if (currentx >= 37 && currentx <= 331 && currenty >= 31 && currenty <= 34)
				currenty -=1;
			if (currentx >= 37 && currentx <= 331 && currenty <= 339 && currenty >= 334)
				currenty +=1;

			//Collisions for square 2
			if (currentx >= 36 && currentx <= 39 && currenty >= 410 && currenty <= 718)
				currentx -=1;
			if (currentx >= 329 && currentx <= 332 && currenty >= 410 && currenty <= 718)
				currentx +=1;
			if (currentx >= 37 && currentx <= 331 && currenty >= 410 && currenty <= 414)
				currenty -=1;
			if (currentx >= 37 && currentx <= 331 && currenty >= 715 && currenty <= 719)
				currenty +=1;

			//collisions for square 3
			if (currentx >= 417  && currentx <= 420 && currenty >= 31 && currenty <= 338)
				currentx -=1;
			if (currentx <= 712 && currentx >= 709 && currenty >= 31 && currenty <= 338)
				currentx +=1;
			if (currentx >= 418 && currentx <= 711 && currenty >= 31 && currenty <= 34)
				currenty -=1;
			if (currentx >= 418 && currentx <= 711 && currenty >= 334 & currenty <= 339)
				currenty +=1;

			//collision for square 4
			if (currentx >= 417 && currentx <= 420 && currenty >= 410 && currenty <= 718)
				currentx -=1;
			if (currentx <= 712 && currentx >= 709 && currenty >= 410 && currenty <= 718)
				currentx +=1;
			if (currentx >= 418 && currentx <= 711 && currenty >= 410 && currenty <= 414)
				currenty -=1;
			if (currentx >= 418 && currentx <= 711 && currenty >= 715 && currenty <= 719)
				currenty +=1;


			this.rect = new Rectangle(currentx, currenty, width, height);

		}//end move

	public int getSlenderX()
	{
		return currentx;
	}

	public int getSlenderY()
	{
		return currenty;
	}

	public int getHealth()
	{
		return health;
	}

////	public void spawnEnemy(Graphics g)
	//{
		//enemyicon.paintIcon(component, g, getSlenderX(), getSlenderY());

	//}

	public void collision(Slender enemy)
	{
		int enemydiffx = enemy.getSlenderX() - currentx;
		int enemydiffy = enemy.getSlenderY() - currenty;

		if (enemydiffx > 0 && enemydiffx <= 50)
			currentx += 1;
		else if (enemydiffx < 0 && enemydiffx >= -50)
			currentx -= 1;
		if (enemydiffy > 0 && enemydiffy <= 50)
			currenty += 1;
		else if (enemydiffy < 0 && enemydiffy >= -50)
			currenty -= 1;
	}

	Image getImage(String img)
	{
		return Toolkit.getDefaultToolkit().getImage(img);

	}


	@Override
	void update(Shooter shooter) {
		// TODO Auto-generated method stub

	}





}//end

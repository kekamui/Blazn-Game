

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Boss extends GameObject
{

		private int bossy;
		private int bossx;
		public int ygoal,xgoal;
		public int xdiff = 0, ydiff = 0;
		private int health;
		private int width,height;
		private Image img;
		public boolean alive = true;;
		private ImageIcon enemyicon = new ImageIcon("/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");
//		static Component component = new MyComponent();

//randomized location, then stops???????

		public Boss(int me_x, int me_y,int you_x, int you_y, int width, int height, int health, String img) //input the position of a randomized location and of the main user
		{
			bossy = me_y;
			bossx = me_x;
			ygoal = you_y;
			xgoal = you_x;
			this.health = health;
			this.img = getImage(img);
			this.width = width;
			this.height = height;
			this.rect = new Rectangle(bossx, bossy,width,height);
		}


		//@Override
		public void draw(Graphics g)
		{
			g.drawImage(img,bossx,bossy,width,height,null);
		}


//same as Slender class
		public void update(Shooter shooter, int you_x, int you_y)
		{

			//moves towards the player by looking at the difference in position
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
			//takes the difference
			ydiff = ygoal-bossy;
			xdiff = xgoal-bossx;

			//move the character
			if (ydiff > 0)
				bossy += 1;
			else if (ydiff < 0)
				bossy -= 1;
			if(xdiff > 0)
				bossx += 1;
			else if (xdiff < 0)
				bossx -= 1;

			if (bossx >= 36 && bossx <= 39 && bossy >= 31 && bossy <= 338)
				bossx -=1;
			if (bossx <= 332 && bossx >= 329 && bossy >= 31 && bossy <= 338)
				bossx +=1;
			if (bossx >= 37 && bossx <= 331 && bossy >= 31 && bossy <= 34)
				bossy -=1;
			if (bossx >= 37 && bossx <= 331 && bossy <= 339 && bossy >= 334)
				bossy +=1;

			//Collisions for square 2
			if (bossx >= 36 && bossx <= 39 && bossy >= 410 && bossy <= 718)
				bossx -=1;
			if (bossx >= 329 && bossx <= 332 && bossy >= 410 && bossy <= 718)
				bossx +=1;
			if (bossx >= 37 && bossx <= 331 && bossy >= 410 && bossy <= 414)
				bossy -=1;
			if (bossx >= 37 && bossx <= 331 && bossy >= 715 && bossy <= 719)
				bossy +=1;

			//collisions for square 3
			if (bossx >= 417  && bossx <= 420 && bossy >= 31 && bossy <= 338)
				bossx -=1;
			if (bossx <= 712 && bossx >= 709 && bossy >= 31 && bossy <= 338)
				bossx +=1;
			if (bossx >= 418 && bossx <= 711 && bossy >= 31 && bossy <= 34)
				bossy -=1;
			if (bossx >= 418 && bossx <= 711 && bossy >= 334 & bossy <= 339)
				bossy +=1;

			//collision for square 4
			if (bossx >= 417 && bossx <= 420 && bossy >= 410 && bossy <= 718)
				bossx -=1;
			if (bossx <= 712 && bossx >= 709 && bossy >= 410 && bossy <= 718)
				bossx +=1;
			if (bossx >= 418 && bossx <= 711 && bossy >= 410 && bossy <= 414)
				bossy -=1;
			if (bossx >= 418 && bossx <= 711 && bossy >= 715 && bossy <= 719)
				bossy +=1;


			this.rect = new Rectangle(bossx, bossy, width, height);

		}//end move

	public int getBossX()
	{
		return bossx;
	}

	public int getBossY()
	{
		return bossy;
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
		int enemydiffx = enemy.getSlenderX() - bossx;
		int enemydiffy = enemy.getSlenderY() - bossy;

		if (enemydiffx > 0 && enemydiffx <= 50)
			bossx += 1;
		else if (enemydiffx < 0 && enemydiffx >= -50)
			bossx -= 1;
		if (enemydiffy > 0 && enemydiffy <= 50)
			bossy += 1;
		else if (enemydiffy < 0 && enemydiffy >= -50)
			bossy -= 1;
	}

	Image getImage(String img)
	{
		return Toolkit.getDefaultToolkit().getImage(img);

	}


	@Override
	void update(Shooter shooter) {



	}





}//end

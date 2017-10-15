import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;



public class MyScreen extends Screen {

	private static int x = 0;
	private static int y = 0;
	@SuppressWarnings("unused")
	private float velocityX = 0, velocityY = 0;
	private ImageIcon icon = new ImageIcon("C:\\Users\\ANKON\\Downloads\\downStat_50x50.png");
	private ImageIcon icon1 = new ImageIcon("C:\\Users\\ANKON\\Downloads\\downStat_50x50.png");
	private ImageIcon icon2 = new ImageIcon("C:\\Users\\ANKON\\Downloads\\rightStat_50x50.png");
	private ImageIcon icon3 = new ImageIcon("C:\\Users\\ANKON\\Downloads\\upStat_50x50.png");
	private ImageIcon icon4 = new ImageIcon("C:\\Users\\ANKON\\Downloads\\leftStat_50x50.png");
	
	Graphics g;
	Component component = new MyComponent();
	private int enemycount = 3;
	
	//Slender enemy = new Slender(700, 30, x, y, 1);
	//Slender enemy2 = new Slender(700, 700, x, y, 1);
	//Slender enemy3 = new Slender(250, 250, x, y, 1);
	
	
	public MyScreen(ScreenFactory screenFactory) {
		super(screenFactory);
		//getScreenFactory().getGame().getWindow().;
		// TODO Auto-generated constructor stub
	}

	public static int getX() {
		return x;
	}

	public void setX(int x) {
		MyScreen.x = x;
	}
	public static int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		MyScreen.y = y;
	}

	@Override
	public void onCreate() {
		System.out.println("Creating!");
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onUpdate() {
		//if (collision() == false)
		{		if(getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_LEFT))
			{
				//velocityX -= 2;
				
				x -= 2;
				icon = icon4;
			}
			else if(getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_RIGHT))
			{
				//velocityX += 2;
				x += 2;
				icon = icon2;
			}
			else if(getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP))
			{
				//velocityY -= 2;
				y -= 2;
				icon = icon3;
			}
			else if(getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN))
			{
				//velocityY += 2;
				y += 2;
				icon = icon1;
			}
			if(!getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_LEFT))
				velocityX *= 0.6;
			if(!getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_RIGHT))
				velocityX *= 0.6;
			if(!getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_UP))
				velocityY *= 0.6;
			if(!getScreenFactory().getGame().getKeyboardListener().isKeyPressed(KeyEvent.VK_DOWN))
				velocityY *= 0.6;
		}
	/*	

		enemy.update(x, y);
		enemy2.update(x, y);
		enemy3.update(x, y);
		
		enemy.collision(enemy2);
		enemy2.collision(enemy);
		enemy.collision(enemy3);
		enemy2.collision(enemy3);
		enemy3.collision(enemy);
		enemy3.collision(enemy2);
		
		enemy.move();
		enemy2.move();
		enemy3.move();
		*/

		if(y >= 800 - 60)
			y = 800 - 60;
		if(y <= -5)
			y = -5;
		if(x >= 800 - 60)
			x = 800 - 60;
		if(x <= 10)
			x = 10;
		
		//collisions for square 1
		if (x >= 36 && x <= 39 && y >= 31 && y <= 338)
			x -=2;
		if (x <= 332 && x >= 329 && y >= 31 && y <= 338)
			x +=2;
		if (x >= 37 && x <= 331 && y >= 31 && y <= 34)
			y-=2;
		if (x >= 37 && x <= 331 && y <= 339 && y >= 334)
			y+=2;
		
		//Collisions for square 2
		if (x >= 36 && x <= 39 && y >= 410 && y <= 718)
			x-=2;
		if (x >= 329 && x <= 332 && y >= 410 && y <= 718)
			x+=2;
		if (x >= 37 && x <= 331 && y >= 410 && y <= 414)
			y-=2;
		if (x >= 37 && x <= 331 && y >= 715 && y <= 719)
			y+=2;
		
		//collisions for square 3
		if (x >= 417  && x <= 420 && y >= 31 && y <= 338)
			x-=2;
		if (x <= 712 && x >= 709 && y >= 31 && y <= 338)
			x+=2;
		if (x >= 418 && x <= 711 && y >= 31 && y <= 34)
			y-=2;
		if (x >= 418 && x <= 711 && y >= 334 & y <= 339)
			y+=2;
		
		//collision for square 4
		if (x >= 417 && x <= 420 && y >= 410 && y <= 718)
			x-=2;
		if (x <= 712 && x >= 709 && y >= 410 && y <= 718)
			x+=2;
		if (x >= 418 && x <= 711 && y >= 410 && y <= 414)
			y-=2;
		if (x >= 418 && x <= 711 && y >= 715 && y <= 719)
			y+=2;
		
	}


	public void onDraw(Graphics g) {

			Component component = new MyComponent();
			getScreenFactory().getGame().getWindow().add(component);
			
				

			ImageIcon background = new ImageIcon("C:\\Users\\ANKON\\Desktop\\Ankon's\\APCS\\Final S2\\map.png");

			getScreenFactory().getGame().getWindow().add(component);
			background.paintIcon(component, g, 0, 0);
			icon.paintIcon(component, g, x, y);
			//g2d.setColor(Color.black);
			//g2d.fillRect(x, y, 64, 64);
			//enemy.spawnEnemy(g);
			//enemy.spawnEnemy(g);
			//enemy2.spawnEnemy(g);
			//enemy3.spawnEnemy(g);

		//g2d.setColor(Color.blue);
		//g2d.fillRect(x, y, 64, 64);
		
	}

}


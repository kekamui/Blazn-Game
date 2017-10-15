
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;

public class Shooter extends JFrame implements KeyListener
{

//initialize all variables
	private Player player;
	private Slender enemy, enemy2,enemy3,enemy4;
	private Slender one, two, three, four, five,six;
	private Slender uno, dos, tres, quatro, cinco,seis,siete,ocho;
	private Boss boss;
	private box box1,box2,box3,box4;
	private Graphics graphics;
	private Image image,background;
	public boolean playerLEFT = false;
	public boolean playerRIGHT = false;
	public boolean playerDOWN = false;
	public boolean playerUP = false;
	public int direction = 0;
	private int wave = 1;
	private boolean waveone = false, wavetwo = false, wavethree = false, bosswave = false,endgame=false;

//Creates arrays to store boxes, enemies, and bullets

	CopyOnWriteArrayList<box> boxes = new CopyOnWriteArrayList<box>();

	CopyOnWriteArrayList<UpBullet>  upbullets = new CopyOnWriteArrayList<UpBullet>();
	CopyOnWriteArrayList<DownBullet>  downbullets = new CopyOnWriteArrayList<DownBullet>();
	CopyOnWriteArrayList<LeftBullet>  leftbullets = new CopyOnWriteArrayList<LeftBullet>();
	CopyOnWriteArrayList<RightBullet>  rightbullets = new CopyOnWriteArrayList<RightBullet>();

	CopyOnWriteArrayList<BossUpBullet>  bossupbullets = new CopyOnWriteArrayList<BossUpBullet>();
	CopyOnWriteArrayList<BossDownBullet>  bossdownbullets = new CopyOnWriteArrayList<BossDownBullet>();
	CopyOnWriteArrayList<BossLeftBullet>  bossleftbullets = new CopyOnWriteArrayList<BossLeftBullet>();
	CopyOnWriteArrayList<BossRightBullet>  bossrightbullets = new CopyOnWriteArrayList<BossRightBullet>();

	CopyOnWriteArrayList<Slender> slender = new CopyOnWriteArrayList<Slender>();
	CopyOnWriteArrayList<Slender> slender1 = new CopyOnWriteArrayList<Slender>();
	CopyOnWriteArrayList<Slender> slender2 = new CopyOnWriteArrayList<Slender>();


	public Shooter()
	{
//creates the game screen
		setTitle("Blazn Asian Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setBackground(Color.black);
		setResizable(false);
		setVisible(true);
		addKeyListener(this);

//initializes player, enemies, boss, and boxes

		player = new Player(400,400,50,50,500,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/downStat.png");

		enemy = new Slender(0, 400, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		enemy2 = new Slender(400, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");
		enemy3 = new Slender(400, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		enemy4 = new Slender(800, 400, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );

		one = new Slender(0, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		two = new Slender(0, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");
		three = new Slender(400, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		four = new Slender(400, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		five = new Slender(800, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");
		six = new Slender(800, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");

		uno = new Slender(0, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		dos = new Slender(0, 400, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		tres = new Slender(0, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");
		quatro = new Slender(400, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		cinco = new Slender(400, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		seis = new Slender(800, 0, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png");
		siete = new Slender(800, 400, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );
		ocho = new Slender(800, 800, player.getX(), player.getY(), 50,50,5,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossDownStat.png" );

		boss = new Boss(700, 750, player.getX(), player.getY(), 50,50,75,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/goldenBossDown.png" );

	Slender[] array = new Slender[]{enemy,enemy2,enemy3,enemy4};
	Slender[] array1 = new Slender[]{one,two,three,four,five,six};
	Slender[] array2 = new Slender[]{uno, dos, tres, quatro, cinco,seis,siete,ocho};

		slender.addAll(Arrays.asList(array));
		slender1.addAll(Arrays.asList(array1));
		slender2.addAll(Arrays.asList(array2));

				box1 = new box(80, 80, 250, 260);
				box2 = new box(80, 450, 250, 260);
				box3 = new box(450, 80, 250, 260);
				box4 = new box(450, 450, 250, 260);

				boxes.add(box1);
				boxes.add(box2);
				boxes.add(box3);
				boxes.add(box4);

//initializes background

		background = Toolkit.getDefaultToolkit().createImage("/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/background.png");
	}

//paints the screen first and calls paintcomponent and repaints
public void paint(Graphics g)
{

	image = createImage(getWidth(),getHeight());
	graphics = image.getGraphics();

	paintComponent(graphics);
	g.drawImage(image,0,0,null);
	repaint();

}

//paints everything else
public void paintComponent(Graphics g)
{

//gets the enemies and boss for the player class
	player.getSlender(slender,slender1,slender2,boss);

	//background
	g.drawImage(background,0,0,null);

//goes through the waves of enemies
if(!waveone)
{
	for (Slender slender: slender)
	{
		if (slender.getHealth() > 0)
		{
			slender.draw(g);
			slender.update(this,player.getX(), player.getY());
		}
		else
			slender.setRect();

	}//for
		if (enemy.getHealth() <=0 && enemy2.getHealth() <=0 && enemy3.getHealth() <=0 && enemy4.getHealth() <=0)
		{
		waveone = true;
		wave = 2;
	}

}//if

else if(!wavetwo)
{
	for (Slender slender: slender1)
	{
		if (slender.getHealth() > 0)
		{
			slender.draw(g);
			slender.update(this,player.getX(), player.getY());
		}
		else
			slender.setRect();
	}
			if (one.getHealth() <=0 && two.getHealth() <=0 && three.getHealth() <=0 && four.getHealth() <=0 && five.getHealth() <=0
					&& six.getHealth() <=0)
			{
		wavetwo = true;
		wave = 3;
	}
}//else if

else if (!wavethree)
{
	for (Slender slender: slender2)
	{
		if (slender.getHealth() > 0)
		{
			slender.draw(g);
			slender.update(this,player.getX(), player.getY());
		}
		else
			slender.setRect();
	}

			if (uno.getHealth() <=0 && dos.getHealth() <=0 && tres.getHealth() <=0 && quatro.getHealth() <=0 && cinco.getHealth() <=0
				&& seis.getHealth() <=0 && siete.getHealth() <=0 && ocho.getHealth() <=0)
				{
		wavethree = true;
		wave = 4;
	}
}//else

else if(!bosswave)
{

//if boss is alive, keep drawing it
if (boss.getHealth() > 0)
{
			boss_shoot(g);
			boss.draw(g);
			boss.update(this,player.getX(), player.getY());
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
			g.drawString("Enemy Boss Health: " + boss.getHealth(), 280, 750);
}
		else
			boss.setRect();

		if(boss.getHealth() <= 0)
		{
		bosswave = true;
		endgame =true;
		}

}//else

//if player is alive, keep drawing
		if(player.getHealth() > 0 )
		{

	player_shoot(g);

	player.draw(g);
	player.update(this);

	 if (endgame){
			g.setColor(Color.blue);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g.drawString("YOU WIN",300,400);
		}

}
	else if (player.getHealth() <= 0)
	{
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.drawString("Game Over",300,400);
	}


//draws health always
	g.setColor(Color.red);
	g.setFont(new Font("TimesRoman", Font.BOLD, 30));
	g.drawString("Your health is "+ player.getHealth(),300,60);




}
/*
public static void main(String[] args)
{
	new Shooter();
}
*/


//gets the keys pressed to make player move
@Override
public void keyPressed(KeyEvent e)
{
	if(e.getKeyCode() == KeyEvent.VK_UP)
	{
		playerUP = true;
		player = new Player(player.getX(),player.getY(),50,50,player.getHealth(),"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/upStat.png");
		//direction = 1;
	}
	else if(e.getKeyCode() == KeyEvent.VK_DOWN)
	{
		playerDOWN = true;
		player = new Player(player.getX(),player.getY(),50,50,player.getHealth(),"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/downStat.png");
		//direction = 2;
	}
	else if(e.getKeyCode() == KeyEvent.VK_LEFT)
	{
		playerLEFT = true;
		player = new Player(player.getX(),player.getY(),50,50,player.getHealth(),"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/leftStat.png");
		//direction = 3;
	}
	else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	{
		playerRIGHT = true;
		player = new Player(player.getX(),player.getY(),50,50,player.getHealth(),"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/rightStat.png");
		//direction = 4;
	}

}

//gets keys for shooting. if you shoot one direction, the boss shoots the other direction
@Override
public void keyReleased(KeyEvent e)
{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			playerUP = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			playerDOWN = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			playerLEFT = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			playerRIGHT = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_W)
		{
			UpBullet playerBullet = new UpBullet(slender,slender1,slender2,boss,boxes,player.getX(),player.getY(),20,30,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bulletup.png");
			upbullets.add(playerBullet);

			BossDownBullet bossBullet = new BossDownBullet(player,boxes,boss.getBossX(),boss.getBossY(),20,30,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossdownbullet.png");
			bossdownbullets.add(bossBullet);

		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			DownBullet playerBullet = new DownBullet(slender,slender1,slender2,boss,boxes,player.getX(),player.getY(),20,30,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bulletdown.png");
			downbullets.add(playerBullet);

			BossUpBullet bossBullet = new BossUpBullet(player,boxes,boss.getBossX(),boss.getBossY(),20,30,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossupbullet.png");
			bossupbullets.add(bossBullet);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A)
		{
			LeftBullet playerBullet = new LeftBullet(slender,slender1,slender2,boss,boxes,player.getX(),player.getY(),30,20,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bulletleft.png");
			leftbullets.add(playerBullet);

			BossRightBullet bossBullet = new BossRightBullet(player,boxes,boss.getBossX(),boss.getBossY(),30,20,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossrightbullet.png");
			bossrightbullets.add(bossBullet);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			RightBullet playerBullet = new RightBullet(slender,slender1,slender2,boss,boxes,player.getX(),player.getY(),30,20,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bulletright.png");
			rightbullets.add(playerBullet);

			BossLeftBullet bossBullet = new BossLeftBullet(player,boxes,boss.getBossX(),boss.getBossY(),30,20,"/Users/kevinmui/Documents/Importantish stuff/Ap Comp Sci HS/Final Shooting/final start (1)/bossleftbullet.png");
			bossleftbullets.add(bossBullet);
		}
}


@Override
public void keyTyped(KeyEvent e)
{
	;
}

public int getWave()
{
	return wave;
}


//methods for drawing the bullets in method form

public void boss_shoot(Graphics g)
{
	for(BossUpBullet bossbullet: bossupbullets)
		{
			bossbullet.draw(g);
			bossbullet.update(this);
		}
		for(BossDownBullet bossbullet: bossdownbullets)
		{
			bossbullet.draw(g);
			bossbullet.update(this);
		}
		for(BossLeftBullet bossbullet: bossleftbullets)
		{
			bossbullet.draw(g);
			bossbullet.update(this);
		}
		for(BossRightBullet bossbullet: bossrightbullets)
		{
			bossbullet.draw(g);
			bossbullet.update(this);
		}
}

public void player_shoot(Graphics g)
{

		for(UpBullet bullet: upbullets)
		{
			bullet.draw(g);
			bullet.update(this);
		}
		for(DownBullet bullet: downbullets)
		{
			bullet.draw(g);
			bullet.update(this);
		}
		for(LeftBullet bullet: leftbullets)
		{
			bullet.draw(g);
			bullet.update(this);
		}
		for(RightBullet bullet: rightbullets)
		{
			bullet.draw(g);
			bullet.update(this);
		}


}


}

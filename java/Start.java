import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Start extends JFrame implements KeyListener
{

	private Image image;
	private Graphics graphics;
	public Start()
	{
		//initializes start screen
		setTitle("Blazn Asian Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setBackground(Color.black);
		setResizable(false);
		setVisible(true);
		addKeyListener(this);
	}

	public static void main (String [] args)
	{
		new Start();
	}

	public void paint(Graphics g)
	{

		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();

		paintComponent(graphics);
		g.drawImage(image,0,0,null);
		repaint();

	}
	public void paintComponent(Graphics g)
	{
		//creates the start screen words
		g.setColor(Color.pink);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("Press space to play.",280,750);
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.drawString("BLAZN ASIAN GAME", 40, 60);
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("How to play:", 40, 100);
		g.drawString("W - Shoot up, A - Shoot left, S - Shoot down,", 40, 150);
		g.drawString("D - Shoot right", 40, 190);
		g.drawString("Arrow up - Move up, Arrow down - Move down,", 40, 230);
		g.drawString("Arrow right - Move right, Arrow left - Move left", 40, 270);
		g.setColor(Color.green);
		g.drawString("Good luck!", 300, 500);


	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE);
		{
			new Shooter();
			//closes the start window when starting game
			setVisible(false);
			dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}

}

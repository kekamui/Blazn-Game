import java.awt.Graphics;

import javax.swing.JFrame;

public class Game
{
	private final JFrame window = new JFrame();
	private final ScreenFactory screenFactory;
	private final GameThread gameThread;
	private final KeyboardListener keyboardListener;
	private final MousepadListener mousepadListener;
	private Graphics g;

	
	public Game (int windowX, int windowY, String title)
	{
		window.setSize(windowX, windowY);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);
	    //window.setLayout(new BorderLayout());
	    //window.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ANKON\\Downloads\\main_background.png")));
	    //window.setLayout(new FlowLayout());
	    // Just for refresh :) Not optional!
	    //window.setSize(999,999);
	    //window.setSize(1000,1000);
		window.setResizable(false);
		screenFactory = new ScreenFactory(this);
		gameThread = new GameThread(this);
		keyboardListener = new KeyboardListener();
		mousepadListener = new MousepadListener();
		
		window.add(gameThread);
		window.addKeyListener(keyboardListener);
		window.addMouseListener(mousepadListener);
		
		new Thread(gameThread).start();
		gameThread.paint(g);
		
	}
	
	public MousepadListener getMouseListener() {
		return mousepadListener;
	}
	
	public KeyboardListener getKeyboardListener() {
		return keyboardListener;
	}
	
	public ScreenFactory getScreenFactory() {
		return screenFactory;
	}
	
	public JFrame getWindow() {
		return window;
	}

}
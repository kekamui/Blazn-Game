import java.awt.Graphics;


public abstract class Screen {
	
	private final ScreenFactory screenFactory;
	
	public Screen(ScreenFactory screenFactory)
	{
		this.screenFactory = screenFactory;
	}
	
	public abstract void onCreate();
	
	public abstract void onUpdate();
	
	public abstract void onDraw(Graphics g);
	
	public ScreenFactory getScreenFactory() {
		return screenFactory;
	}

}

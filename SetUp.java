import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SetUp extends JPanel 
{
	private JFrame window;
	private boolean running;
	
	public SetUp (JFrame frame)
	{
	   window = frame;
	   running =true;
	}
	
	public void run()
	{
		JLabel picture= new JLabel(new ImageIcon("Title.png"));
		picture.setSize(window.getWidth(),window.getHeight());
		picture.setLocation(0,0);
		picture.setVisible(true);
		window.add(picture);
		System.out.printf("%d\n",window.getWidth());

		window.revalidate();
		window.repaint();
	}
	
	public boolean ran()
	{
		return running;
	}
}
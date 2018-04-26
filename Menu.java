//Scott Wilits Carlito Que
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Menu
{
	public JFrame menu;
	public JButton start;
	public JLabel picture;

	public boolean running;
	
	public Menu (JFrame frame)
	{	
		running=true;
		menu = frame;
		picture= new JLabel(new ImageIcon("Title.png"));
	}
	
	public void run()
	{
		//for menu picture
		picture.setSize(menu.getWidth(),menu.getHeight());
		picture.setLocation(0,0);
		picture.setVisible(true);
		
		//for start button
		start=new JButton("START");
		start.setSize(300,125);
		start.setLocation((menu.getWidth()/2)-330,menu.getHeight()-230);
		start.setBackground(Color.GRAY);
		start.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				menu.remove(start);
				menu.remove(picture);
				//menu.setVisible(false);
				menu.revalidate();
				menu.repaint();
				running = false;
			}
		});
		start.setVisible(true);
		

		
		//at the end, add everything to frame and set visible	
		menu.add(picture);
		menu.add(start);

		menu.setVisible(true);
		
		menu.revalidate();
		menu.repaint();
	}
	
	public boolean running()
	{
		return running;
	}
	
}	

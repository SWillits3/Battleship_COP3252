import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Menu
{
	public JFrame menu;
	public JButton start,load;
	public JLabel picture;

	public boolean running;
	
	public Menu (JFrame frame)
	{	
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
		//start.setBackground(Color.BLACK);
		start.setSize(300,125);
		start.setLocation(menu.getWidth()/2,menu.getHeight()-230);
		start.setVisible(true);
		
		//for load button
		
		//at the end, add everything to frame and set visible
		menu.getContentPane().add(picture);
		menu.getContentPane().add(start);
		
		running=true;
		menu.setVisible(true);
		
		menu.getContentPane().revalidate();
		menu.getContentPane().repaint();
	}
	
	public boolean running()
	{
		return running;
	}
}	

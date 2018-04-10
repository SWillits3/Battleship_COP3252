//Scott Wilits Carlito Que
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

import javax.swing.*;

public class SetUp extends JPanel 
{
	private JFrame window; 
	private boolean running;
	private Image pic;
	private JLabel picture;
	
	public SetUp (JFrame frame)
	{
	   window = frame;
	   running =true;
	   Image temppic;
	   try
	   {
		   pic = ImageIO.read(new File("grid.png"));		//resizing grid picture
	   }
	   catch (IOException e)
	   {
		   
	   }
	   int size=window.getContentPane().getHeight();
	   pic = pic.getScaledInstance(size,size,Image.SCALE_DEFAULT);
	}
	
	public void run()
	{
		picture= new JLabel(new ImageIcon(pic));
		picture.setSize(window.getContentPane().getHeight(),window.getContentPane().getHeight());
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
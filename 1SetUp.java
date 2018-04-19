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
		/*try
		{
			pic = ImageIO.read(new File("grid.png"));	//resizing grid picture
		}
	  	catch (IOException e)
	  	{
			   
	 	}
	 	int size=window.getContentPane().getHeight();
		pic = pic.getScaledInstance(size,size,Image.SCALE_DEFAULT);*/
	}
	
	public void run(Player player1, Player player2)
	{
		//for player 1 setup
		Transition p1 = new Transition (1);
		window.add(p1);
		window.revalidate();
		window.repaint();
		while(p1.isThere()==true)	//doesnt run unless you put in a println in there
			System.out.println("");
		window.remove(p1);	
		
		//end transition slide and player 1 creates his board
		//call a player class function
		player1.choosePosition(window);
		while(player1.isRunning()==true)
			System.out.println("");
		/*picture= new JLabel(new ImageIcon(pic));
		picture.setSize(window.getContentPane().getHeight(),window.getContentPane().getHeight());
		picture.setLocation(0,0);
		picture.setVisible(true);
		window.add(picture);  comment this in if gridpanels dont work*/

		window.revalidate();
		window.repaint();
		
		//for player 2 setup
		Transition p2 = new Transition (2);
		window.add(p2);
		window.revalidate();
		window.repaint();
		while(p2.isThere()==true)	//doesnt run unless you put in a println in there
			System.out.println("");
		window.remove(p2);	
		
		player2.choosePosition(window);
		while(player2.isRunning()==true)
			System.out.println("");

		running=false;
	}
	
	public boolean ran()
	{
		return running;
	}
}

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
		player1.choosePosition(window,player1);
		while(player1.isRunning()==true)
			System.out.printf("player1 choosing position\n");


		window.revalidate();
		window.repaint();
		//for player 2 setup
		Transition p2 = new Transition (2);
		window.add(p2);
		window.revalidate();
		window.repaint();
		while(p2.isThere()==true)	//doesnt run unless you put in a println in there
			System.out.println("player2 choosing position");
		window.remove(p2);

		player2.choosePosition(window,player2);
		while(player2.isRunning()==true)
			System.out.println("");

	}

	public void printGrid()
	{}

	public boolean ran()
	{
		return running;
	}
}

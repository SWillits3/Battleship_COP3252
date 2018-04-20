//Scott Wilits Carlito Que
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/*
		player array rules
		1 - completely empty spot
		2 - taken by player
		3 - hit player spot
		4 - missed player spot

		Player has the following ships:
		Carrier - 5 spaces
		Battleship - 4 spaces
		Cruiser (2) - 3 spaces
		Submarine - 2 spaces
*/

public class Player
{
	public int array [][];
	private int lifes;
	private boolean running;
	public JButton continu,save;

	public Player()
	{
		lifes=17;
		array=new int [10][10];
		for(int i=0;i<10;i++)
		{
			for (int j=0;j<10;j++)
				array[i][j]=1;
		}

		continu = new JButton("Manual");
		continu.setSize(300,125);
		continu.setLocation(615,615-270);


		save = new JButton("Auto Random Generator");
		save.setSize(285,125);
		save.setLocation(615,615-125);

	}

	public void hit()
	{
		lifes--;
	}

	public void choosePosition(JFrame window)
	{
		running = true;

		continu.setVisible(true);
		continu.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				window.remove(continu);
				window.remove(save);
				//menu.setVisible(false);
				window.revalidate();
				window.repaint();
				running = false;
			}
		});
		save.setVisible(true);

		window.add(continu);
		window.add(save);
		window.revalidate();
		window.repaint();

	}

	public boolean isDead()
	{
		if (lifes==0)
			return true;
		else
			return false;
	}


	public int get_value(int row, int col)
	{
		return array[row][col];
	}

	public void print_board(JFrame frame)
	{
		System.out.println("printing board");
	}

	public boolean isRunning()
	{
		return running;
	}

}

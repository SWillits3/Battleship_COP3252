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
	public JButton continu,save,random;

	public Player()
	{
		lifes=17;
		array=new int [10][10];
		for(int i=0;i<10;i++)
		{
			for (int j=0;j<10;j++)
				array[i][j]=1;
		}
		
		

		continu = new JButton("Continue");
		continu.setSize(300,100);
		continu.setLocation(615,615-270);


		save = new JButton("Save");
		save.setSize(285,100);
		save.setLocation(615,615-150);
		
		random=new JButton("Random");
		random.setSize(285,100);
		random.setLocation(615,615-150);
	}

	public void hit()
	{
		lifes--;
	}

	public void choosePosition(JFrame window)
	{
		JPanel temp = new JPanel(); //may remove
		
		running = true;

		continu.setVisible(true);
		continu.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				window.remove(continu);
				window.remove(save);
				window.remove(temp);
				//menu.setVisible(false);
				window.revalidate();
				window.repaint();
				running = false;
			}
		});
		save.setVisible(true);
		
		//going to have to move continue, auto randomgenerator button
		temp.setSize(window.getContentPane().getHeight(),window.getContentPane().getHeight());
		GridBagConstraints gbc = new GridBagConstraints();
		BoardButton buttons[][] = new BoardButton[10][10];
		temp.setLayout(new GridLayout(10,10));
		for(int i =0; i<10; ++i)
		{
			for(int j = 0; j<10; ++j)
			{
				buttons[i][j] = new BoardButton();
				gbc.gridx=i;
				gbc.gridy=j;
				temp.add(buttons[i][j],gbc);

			}
		}
		temp.setVisible(true);
		window.add(temp);
		
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

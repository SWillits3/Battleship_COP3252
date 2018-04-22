//Scott Wilits Carlito Que
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/*
		player array rules
		1 - completely empty spot
		2 - taken by enemy player
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
	public int array [][];		//might delete this
	public BoardButton buttons[][];
	private int lifes;
	private boolean running;
	public JButton continu,save,random;
	JPanel temp;

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
		temp = new JPanel();
		
		running = true;

		continu.setVisible(true);
		continu.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				window.remove(continu);
				window.remove(random);
				window.remove(temp);
				//menu.setVisible(false);
				window.revalidate();
				window.repaint();
				for(int i =0; i<10; ++i)
				{
					for(int j = 0; j<10; ++j)
					{
						buttons[i][j].inSetup=false;
					}
				}
				for(int i =0; i<10; ++i)
				{
					for(int j = 0; j<10; ++j)
					{
						if (buttons[i][j].returnVal()==2)
							array[i][j]=2;
					}
				}
				running = false;
			}
		});
		save.setVisible(true);
		
		temp.setSize(window.getContentPane().getHeight(),window.getContentPane().getHeight());
		buttons = new BoardButton[10][10];
		temp.setLayout(new GridLayout(10,10));
		//GridBagConstraints gbc=new GridBagConstraints();
		for(int i =0; i<10; ++i)
		{
			for(int j = 0; j<10; ++j)
			{
				buttons[i][j] = new BoardButton(i,j,true,1,false);
				//gbc.gridx=i;
				//gbc.gridy=j;
				temp.add(buttons[i][j]);
			}
		}
		temp.setVisible(true);
		window.add(temp);
		
		window.add(random);
		window.revalidate();
		window.repaint();
		

		window.add(continu);
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
	
	public void pickFire(JFrame window, Player enemy)
	{
		running = true;
		
		BoardButton play[][];
		play = new BoardButton[10][10];
		
		temp = new JPanel();
		temp.setSize(window.getContentPane().getHeight(),window.getContentPane().getHeight());
		temp.setLayout(new GridLayout(10,10));
		//GridBagConstraints gbc=new GridBagConstraints();
		for(int i =0; i<10; ++i)		
		{
			for(int j = 0; j<10; ++j)
			{
				play[i][j] = new BoardButton(i,j,false,enemy.array[i][j],true);
				//gbc.gridx=i;
				//gbc.gridy=j;
				temp.add(play[i][j]);
			}
		}
		
		JButton fire = new JButton("FIRE");
		fire.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				window.remove(save);
				window.remove(fire);
				window.remove(temp);
				//menu.setVisible(false);
				for(int i =0; i<10; ++i)		
				{
					for(int j = 0; j<10; ++j)
					{
						enemy.array[i][j]=play[i][j].returnVal();
					}
				}
				window.revalidate();
				window.repaint();
				running = false;
			}
		});
		fire.setSize(300,100);
		fire.setLocation(615,615-270);
		fire.setVisible(true);
		
		temp.setVisible(true);
		window.add(temp);
		window.add(fire);
		window.add(save);
		window.revalidate();
		window.repaint();
	}
	
	public void showBoard(JFrame window)
	{
		running=true;
		JButton panels[][]=new JButton[10][10];
		
		temp = new JPanel();
		temp.setSize(window.getContentPane().getHeight(),window.getContentPane().getHeight());
		temp.setLayout(new GridLayout(10,10));
		//GridBagConstraints gbc=new GridBagConstraints();
		for(int i =0; i<10; ++i)		
		{
			for(int j = 0; j<10; ++j)
			{
				panels[i][j] = new JButton();
				//gbc.gridx=i;
				//gbc.gridy=j;
				ImageIcon picture=new ImageIcon();
				
				if (array[i][j]==2)
					picture=new ImageIcon(this.getClass().getResource("O.png"));
				else if (array[i][j]==3)
					picture=new ImageIcon(this.getClass().getResource("Hit.png"));
				else if (array[i][j]==4)
					picture=new ImageIcon(this.getClass().getResource("Dead.png"));
				
				panels[i][j].setIcon(picture);
				
				temp.add(panels[i][j]);
			}
		}
		
		JButton cont = new JButton("Continue");
		cont.setSize(300,100);
		cont.setLocation(615,615-270);
		cont.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				window.remove(temp);
				window.remove(cont);
				window.revalidate();
				window.repaint();
				running = false;
			}
		});
		cont.setVisible(true);
		window.add(cont);
		
		temp.setVisible(true);
		window.add(temp);
		
		window.revalidate();
		window.repaint();
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

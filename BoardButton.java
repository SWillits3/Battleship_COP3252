import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardButton extends JButton implements ActionListener
{
	ImageIcon Hidden,Hit,Miss;
	private int value;
	private int row;
	private int col;
	public Boolean inSetup;
	public Player enemy;
	/*
	1:empty
	2:X (taken, could be hidden to player)
	3:O (hit)
	4:missed
	*/

	public BoardButton(int ro, int column,boolean isSetup, int val,boolean isEnemy)
	{
		Hit=new ImageIcon(this.getClass().getResource("Hit.png"));
		Hidden=new ImageIcon(this.getClass().getResource("O.png"));	//probably wont need
		Miss = new ImageIcon(this.getClass().getResource("Dead.png"));
		this.addActionListener(this);

		value=val;
		row=ro;
		col=column;
		inSetup=isSetup;
		switch(value)
			{
				case 1:
					setIcon(null);	//empty spot
					break;
				case 2:
					if (isEnemy==true)
						setIcon(null);
					else
						setIcon(Hidden);
					break;
				case 3:
					setIcon(Hit);
					break;
				case 4:
					setIcon(Miss);
					break;
			}
	}

	public BoardButton(int ro, int column,boolean isSetup, int val,boolean isEnemy, Player p)
	{
		enemy = p;
		Hit=new ImageIcon(this.getClass().getResource("Hit.png"));
		Hidden=new ImageIcon(this.getClass().getResource("O.png"));	//probably wont need
		Miss = new ImageIcon(this.getClass().getResource("Dead.png"));
		this.addActionListener(this);

		value=val;
		row=ro;
		col=column;
		inSetup=isSetup;
		switch(value)
			{
				case 1:
					setIcon(null);	//empty spot
					break;
				case 2:
					if (isEnemy==true)
						setIcon(null);
					else
						setIcon(Hidden);
					break;
				case 3:
					setIcon(Hit);
					break;
				case 4:
					setIcon(Miss);
					break;
			}
	}


	public void actionPerformed(ActionEvent e)
	{
		//somehow get value = array[row][col]
		//will use this after confirmation of bottom button layout
	/*	switch(value)
		{
			case 1:
				setIcon(null);	//empty spot
				break;
			case 2:
				setIcon(Hidden);
				break;
			case 3:
				setIcon(Hit);
				break;
			case 4:
				setIcon(Miss);
				break;
		}*/


		if(inSetup==true)
		{
			if (value==1)
				value++;
			else
				value--;
			switch(value)
			{
				case 1:
					setIcon(null);
					break;
				case 2:
					setIcon(Hidden);
					break;
			}
		}
		else
		{
			if (value==1)
				{
					value=4;
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				}

			else if (value==2)
				{
					value=3;
					enemy.hit();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				}

			switch(value)
			{
				case 1:
					setIcon(null);	//empty spot
					break;
				case 2:
					setIcon(Hidden);
					break;
				case 3:
					setIcon(Hit);
					break;
				case 4:
					setIcon(Miss);
					break;
			}
		}
	}

	public int returnRow()
	{
		return row;
	}

	public int returnCol()
	{
		return col;
	}

	public int returnVal()
	{
		return value;
	}
}

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardButton extends JButton implements ActionListener
{
	ImageIcon Hidden,Hit,Miss, Mark;
	private int value;
	private int row;
	private int col;
	public Boolean inSetup;
	public Player enemy;
	public int counter;
	/*
	1:empty
	2:X (taken, could be hidden to player)
	3:O (hit)
	4:missed
	*/
	//for show
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
	//for action fire
	public BoardButton(int ro, int column,boolean isSetup, int val,boolean isEnemy, Player p)
	{
		enemy = p;
		Hit=new ImageIcon(this.getClass().getResource("Hit.png"));
		Hidden=new ImageIcon(this.getClass().getResource("O.png"));	//probably wont need
		Miss = new ImageIcon(this.getClass().getResource("Dead.png"));
		Mark = new ImageIcon(this.getClass().getResource("Mark.png"));
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
		if(inSetup==true)
		{
			if(enemy.initializer<17)
			{
				if (value==1)
			{
				value++;
				enemy.add_initializer(true);//not actually enemy, own board
			}
				else
				{
					value--;
					enemy.add_initializer(false);	//not actually enemy, just own player
				}
			}
			else
			{
				if(value!=1)
				{
					value--;
					enemy.add_initializer(false);
				}
			}
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
		else	//if we are in play mode
		{
			if(!enemy.get_miss()&&!enemy.get_hit())	//if miss = false, then changes can be made
			{
				if (value==1)
					{
						value=4;
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						enemy.missed();
					}

				else if (value==2)
					{
						value=3;
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						enemy.hit();
					}
			}
			switch(value)
			{
				case 1:
					setIcon(null);	//empty spot
					break;
				//case 2:	//shouldnt show hidden anyway
				//	setIcon(Hidden);
				//	break;
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

	public void set_hidden()	//for random button
	{
		value = 2;
		setIcon(Hidden);
	}
}

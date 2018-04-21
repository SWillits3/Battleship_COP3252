import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardButton extends JButton implements ActionListener
{
	ImageIcon Hidden,Hit,Miss;
	private int value=0;
	private int row;
	private int col;
	public Boolean inSetup;
	/*
	0:nothing
	1:X
	2:O
	*/

	public BoardButton(int ro, int column)
	{
		Hit=new ImageIcon(this.getClass().getResource("Hit.png"));
		Hidden=new ImageIcon(this.getClass().getResource("O.png"));	//probably wont need
		Miss = new ImageIcon(this.getClass().getResource("Dead.png"));
		this.addActionListener(this);
		
		row=ro;
		col=column;
		inSetup=true;
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


		if(inSetup==true)//not the actual functionality. Just use this to test for now
		{
			if (value==0)
				value++;
			else
				value--;
			switch(value)
			{
				case 0:
					setIcon(null);
					break;
				case 1:
					setIcon(Hidden);
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

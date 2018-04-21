import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardButton extends JButton implements ActionListener
{
	ImageIcon Hidden,Hit,Miss;
	int value=0;
	/*
	0:nothing
	1:X
	2:O
	*/

	public BoardButton()
	{
		Hit=new ImageIcon(this.getClass().getResource("Hit.png"));
		Hidden=new ImageIcon(this.getClass().getResource("O.png"));	//probably wont need
		Miss = new ImageIcon(this.getClass().getResource("Dead.png"));
		this.addActionListener(this);
	}

//Create a function that gets the 2darray
 public int get_array_value(int[][] arr,int row, int col)
 {
	 return arr[row][col];	//may not need this
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


		if(value!=2)//not the actual funcionality. Just use this to test for now
		{
			value++;
			value%=3;
			switch(value){
				case 0:
					setIcon(null);
					break;
				case 1:
					setIcon(Hit);
					break;
				case 2:
					setIcon(Miss);
					break;
			}
		}
		//else do nothing
	}
}

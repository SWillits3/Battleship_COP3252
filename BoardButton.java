import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardButton extends JButton implements ActionListener{
	ImageIcon Hidden,Hit,Miss;
	int value=0;
	/*
	0:nothing
	1:X
	2:O
	*/

	public BoardButton(){
		Hit=new ImageIcon(this.getClass().getResource("Hit.png"));
		Hidden=new ImageIcon(this.getClass().getResource("O.png"));	//probably wont need
		Miss = new ImageIcon(this.getClass().getResource("Dead.png"))
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(value!=2)
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

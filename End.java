import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class End extends JPanel implements ActionListener
{
	private JLabel picture;
	private boolean running;
	
	private int delay = 3000;
	protected Timer timer;

	public End(int who)
	{
			if (who==1)
				picture= new JLabel(new ImageIcon("P1Win.png"));
			else if (who==2)
				picture= new JLabel(new ImageIcon("P2Win.png"));;
			
			//picture.setSize(900,615);
			this.add(picture);
			this.setSize(900,615);
			this.setLocation(0,0);
			//this.setVisible(true);
			timer = new Timer(delay, this);
			timer.start();		// start the timer
			running = true;
	}
	
	public void actionPerformed(ActionEvent e)
	// will run when the timer fires
	{
		this.remove(picture);
		running=false;
	}
	
	public boolean isThere()
	{
		return running;
	}
}

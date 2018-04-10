import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Transition extends JPanel implements ActionListener
{
	private JLabel picture;
	private boolean running;
	private int which;
	
	private int delay = 3000;
	protected Timer timer;

	public Transition(int whichwindow)
	{
			which=whichwindow;
			if (which==1)
				picture= new JLabel(new ImageIcon("P1choose.png"));
			else if (which==2)
				picture= new JLabel(new ImageIcon("P2choose.png"));
			else if (which==3)
				picture= new JLabel(new ImageIcon("P1turn.png"));
			else if (which==4)
				picture= new JLabel(new ImageIcon("P2turn.png"));
			
			picture.setSize(900,615);
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
		running=false;
	}
	
	public boolean isThere()
	{
		return running;
	}
}
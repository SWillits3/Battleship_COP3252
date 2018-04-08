import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Battleship
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame( "Battleship" );
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 900, 615 ); // set frame size
		frame.setResizable(false);

		//code this in if setSize() doesn't work
		//frame.setPreferredSize(new Dimension(900, 615));
		//frame.setMinimumSize(new Dimension(900, 615));		
		//frame.pack();
		//frame.setVisible( true ); // display frame


		
		Menu menu = new Menu(frame); 
		menu.run();
		while(menu.running())	//be on menu until user presses play
		{}

	}
}
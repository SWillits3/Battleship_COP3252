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
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//opens JFrame for other operations
		frame.setPreferredSize(new Dimension(900, 615));
		frame.setMinimumSize(new Dimension(900, 615));
		frame.setResizable(false);
		frame.pack();
		
		Menu menu = new Menu(frame); 
		frame.add( menu );
		frame.setSize( 900, 650 ); // set frame size
		frame.setVisible( true ); // display frame
	}
}
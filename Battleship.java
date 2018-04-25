//Scott Wilits Carlito Que
//testing github
//import sun.audio.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;


public class Battleship
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame( "Battleship" );
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 900, 615 ); // set frame size
		frame.getContentPane().setBackground( Color.black );
		frame.setResizable(false);

		//code this in if setSize() doesn't work
		//frame.setPreferredSize(new Dimension(900, 615));
		//frame.setMinimumSize(new Dimension(900, 615));
		//frame.pack();
		//frame.setVisible( true ); // display frame



		Menu menu = new Menu(frame);
		menu.run();
		while(menu.running()==true)	//be on menu until user presses play
		{
			System.out.println("menu");
		}
		//System.out.println("End test");
		//			System.out.println("TEST");
		SetUp grid = new SetUp (frame);

			//while(grid.ran())
				//System.out.println("setup");

		System.out.println("done setupdone setupdone setupdone setupdone setupdone setupdone setupdone setupdone setupdone setup");

		Player player1 = new Player();
		Player player2 = new Player();
		int whowon;

		grid.run(player1, player2);
		//while(grid.ran()==true)	//doesnt run unless you put in a println in there
		//{
			//System.out.println("grid.ran=true");
		//}

		boolean firstplay=true;
		while(true)		//after setup and we will play the game now
		{
			Transition p1 = new Transition (3);
			frame.add(p1);
			frame.revalidate();
			frame.repaint();
			while(p1.isThere()==true)	//doesnt run unless you put in a println in there
			{
					System.out.println("p1 transition isthere");
			}
			frame.remove(p1);
			/*
				player1.print_board(frame);
				//player selects a Button
				//repaint after button is selected.
				//dont think we need firstplay

			*/
			if (firstplay==true)
				firstplay=false;
			else		//show the player's board and what happened in the previous turn
			{
				player1.showBoard(frame);
				while(player1.isRunning()==true)
					System.out.println("Showing player1 board");
			}

			player1.pickFire(frame, player2);
			while(player1.isRunning()==true)
				System.out.printf("player1 picking play %s\n", player2.get_life());

			if(player2.isDead())
			{
				whowon=1;
				break;
			}

			//player 2's turn now
			Transition p2 = new Transition (4);
			frame.add(p2);
			frame.revalidate();
			frame.repaint();
			while(p2.isThere()==true)
				System.out.println("p2 transition isthere");
			frame.remove(p2);	//end transition, now show what happened on previous turn


			player2.showBoard(frame);
			while(player2.isRunning()==true)
				System.out.println("Showing player2 board");



			player2.pickFire(frame,player1);
			while(player2.isRunning()==true)
				System.out.printf("player2 picking play %s\n", player1.get_life());

			if (player1.isDead())
			{
				whowon=2;
				break;
			}
		}

		//print end screen
		End gameover = new End (whowon);
		frame.add(gameover);
		frame.revalidate();
		frame.repaint();
		while(gameover.isThere()==true)
			System.out.println("");
		System.exit(0);
	}
}

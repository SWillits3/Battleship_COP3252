public class Player
{
	public int array [][];
	private int lifes;
	/*	
		player array rules
		1 - completely empty spot
		2 - taken by player
		3 - hit player spot
		4 - missed player spot
		
		Player has the following ships:
		Carrier - 5 spaces
		Battleship - 4 spaces
		Cruiser (2) - 3 spaces
		Submarine - 2 spaces
	*/
	public Player()
	{
		lifes=17;
		array=new int [10][10];
		for(int i=0;i<10;i++)
		{
			for (int j=0;j<10;j++)
				array[i][j]=1;
		}
		
	}
	
	public void hit()
	{
		lifes--;
	}
	
	public boolean isDead()
	{
		if (lifes==0)
			return true;
		else
			return false;
	}
}
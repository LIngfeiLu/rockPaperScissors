/** 
 * Class RockPaperScissors.  Plays repeated games of Rock Paper Scissors with a user 
 * @author Zhiyu Mao
 * @date April, 5, 2015
 * */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class RockPaperScissors
{
	public static Random randGen = new Random();
	public static int numAtpt = 0;
	public static int myWin, youWin, bothWin;
	public static void main( String[] args )
	{
		int initialCapacity = 5;
		// Store the user's move history
		String[] userMoves = new String[initialCapacity];  
		// Store the System's move history
		LinkedList<String> systemMoves = new LinkedList<String>();
		helper();
		Scanner scnr = new Scanner(System.in);
		String usrInput = "";
		String randMove = "";


		while (!usrInput.equals("q"))
		{
			usrInput = scnr.nextLine();
			if (numAtpt != initialCapacity)
			{
				randMove = randGen();
				systemMoves.add(randMove);

				if (usrInput.equals("r"))
				{
					userMoves [numAtpt] = "rock";
					compete(userMoves[numAtpt], randMove);
					numAtpt = numAtpt + 1;

				}
				else if (usrInput.equals("p"))
				{
					userMoves [numAtpt] = "paper";
					compete(userMoves[numAtpt], randMove);
					numAtpt = numAtpt + 1;
				}
				else if (usrInput.equals("s"))
				{
					userMoves [numAtpt] = "scissors";
					compete(userMoves[numAtpt], randMove);
					numAtpt = numAtpt + 1;
				}
				else if (usrInput.equals("q"))
				{break;}
				else
				{
					System.out.print("That is not a valid move. "); 
					System.out.println("Please try again");
					helper();
				} 
			}
			else
			{
				initialCapacity = initialCapacity * 2;
				String[] newMoves = new String[initialCapacity];
				for (int i = 0; i < numAtpt; i ++)
				{
					newMoves[i] = userMoves[i];
				}	
				userMoves = newMoves;
				randMove = randGen();
				systemMoves.add(randMove);

				if (usrInput.equals("r"))
				{
					userMoves [numAtpt] = "rock";
					compete(userMoves[numAtpt], randMove);
					numAtpt = numAtpt + 1;

				}
				else if (usrInput.equals("p"))
				{
					userMoves [numAtpt] = "paper";
					compete(userMoves[numAtpt], randMove);
					numAtpt = numAtpt + 1;
				}
				else if (usrInput.equals("s"))
				{
					userMoves [numAtpt] = "scissors";
					compete(userMoves[numAtpt], randMove);
					numAtpt = numAtpt + 1;
				}
				else
				{
					System.out.print("That is not a valid move. "); 
					System.out.println("Please try again.");
					helper();
				} 


			}
		}
		System.out.println("Thanks for playing!");
		System.out.print("Our most recent games " + "(");
		System.out.println("in reverse order"+") "+ "were:");
		if (numAtpt <= 10)
		{
			for (int i = numAtpt-1; i >=0; i--)
			{
				System.out.printf("Me: %-10s" , systemMoves.get(i));
				System.out.println(" You: " + userMoves[i]);
			}
			int sum = 1;
			sum = myWin + youWin + bothWin;
			if (sum == 0)
			{sum=1;}

			System.out.println("Our overall stats are:");
			System.out.print("I won:"+ myWin*100/sum + "%     ");
			System.out.print("You won:"+ youWin*100/sum + "%    ");
			System.out.println("We tied:"+ bothWin*100/sum + "%");
		}
		else
		{
			for (int i = 9; i >=0; i--)
			{
				System.out.printf("Me: %-10s" , systemMoves.get(i));
				System.out.println("You: " + userMoves[i]);
			}
			int sum = myWin + youWin + bothWin;
			System.out.println("Our overall stats are:");
			System.out.print("I won:"+ myWin*100/sum + "%     ");
			System.out.print("You won:"+ youWin*100/sum + "%    ");
			System.out.println("We tied:"+ bothWin*100/sum + "%");
		}

	}
	public static void helper()
	{
		System.out.println("Let's paly! What's your move?" + "(" + 
				"r=rock, p=paper, s=scissors or q to quit)");
	}

	public static String randGen()
	{
		int newNum;
		String myMove = "";
		newNum = randGen.nextInt(3);
		switch (newNum)
		{
			case 0:
				myMove = "rock";
				break;
			case 1:
				myMove = "paper";
				break;
			case 2:
				myMove = "scissors";
				break;
		}
		return myMove;
	}
	public static void compete(String your, String my)
	{
		System.out.print("I choose " + my + ". ");
		int compare = your.compareTo(my);
		if (your.equals(my))
		{
			System.out.println("It's a tie");
			helper();
			bothWin ++;
		}

		else if(compare==2 || compare==-3 || compare==1)
		{
			System.out.println("I win!");
			helper();
			myWin ++;
		}
		else
		{
			System.out.println("You win.");
			helper();
			youWin++;
		}
	}


}
// vim: ts=4:sw=4:tw=78

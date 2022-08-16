import java.util.Random; // To generate a random integer
import java.util.Scanner; // To take the input from the user

// The guesser class will generate a random no between [0, upper_bound)
// The guesser is the computer generating a pseudo-random number

class Guesser
{	
	int upper_bound = 11;

	public int randomNo()
	{	
		Random r = new Random(); // random no object
		int guesser_no = r.nextInt(upper_bound);
		return guesser_no;
	}
}


// The player class will guess the no and return the player guessed number

class Player
{
	public int playerGuess()
	{
		Scanner sc = new Scanner(System.in); // created a scanner obj
		int player_guess = sc.nextInt();
		return player_guess; 
	}
}


// The umpire class will compare the player guess and the random guess

class Umpire
{
	public void Compare()
	{
		int won_count = 0;

		Guesser g = new Guesser(); // create a guesser class
		Player p = new Player(); // create a player class
		Scanner sc = new Scanner(System.in); // create a scanner obj

		int key_no = g.randomNo(); // the random no by guesser is stored in the variable 
		// System.out.println(key_no); // testing purpose

		System.out.println("Enter the no of players (min 1 and max 3):");
		int no_of_players = sc.nextInt(); // user input

		if(no_of_players > 3 || no_of_players < 1)
		{
			System.out.println("Invalid input");
			System.out.println("----------------Exiting Game--------------------");
			System.exit(0);
		}

		else
		{
			int a[] = new int[no_of_players]; // an array obj created
			for(int i = 0; i < a.length; i++) // feeding the player guess to the array
			{
				System.out.println("Enter the guess between 0 & " + (g.upper_bound - 1)+ " both inclusive for player " + (i + 1) + ".");
				a[i] = sc.nextInt();
			}

			System.out.println("------------------Results-----------------------");

			for(int i = 0; i < a.length; i++)
			{
				if(a[i] == key_no)
				{
					won_count++;
					System.out.println("Player " + (i + 1) + " has guessed the number correctly");
				}

				else
				{
					System.out.println("Player " + (i + 1) + " has guessed the number incorrectly");
					a[i] = -1; 
				}
			}

			System.out.println();

			if(won_count == 0)
			{
				System.out.println("Sorry!No player has won the round. The key number was " + key_no);
				System.out.println("Thank you for playing!!");
			}

			else if(won_count == 1)
			{
				for(int i = 0; i < a.length; i++)
				{
					if(a[i] != -1)
					{
						System.out.println("Congrats!! Player "+ (i + 1) + " has won the game.");
					}
				}
			}

			else if(won_count > 1)
			{	

				System.out.println("It is a Draw between:");
				for(int i = 0; i < a.length; i++)
				{
					if(a[i] != -1)
					{
						System.out.println("Player "+ (i + 1));
					}
				}

			}

		}

	}
}


class Play
{
	public static void main(String[] args)
	{
		Umpire play = new Umpire();
		play.Compare();
	}
}
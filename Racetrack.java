//
// Singleton Pattern Program
// Gordon Doskas
// PRG/421
// January 25, 2016
// Roland Morales  
//

import java.util.Scanner;

public class Racetrack
{
	// Definition of singleton instance
	private static final Racetrack INSTANCE = new Racetrack();
	private Runner[] lanes;

	// method to retrieve the singleton
	public static final Racetrack getInstance()
	{
		return INSTANCE;
	}

	private Racetrack()
	{
		lanes = new Runner[8];
	}

	// Visual representation of the lanes.
	//    Empty : _
	// Occupied : O
	//
	public void showLanes()
	{
		String val = "";

		for (int i = 0; i < lanes.length; i++)
		{
			val = val + (lanes[i] == null ? "_" : "O");
		}

		System.out.println(
	"\n==========\n" +
		"|12345678|\n" +
		"|"+val+ "|\n" +
		"==========");
	}

	// Attempts to enter a Runner into the specified lane, notifying the user of
	// failure if it is occupied or invalid
	//
	public void addLane(int lane, Runner runner)
	{
		if(lane < 0 || lane > 7)
		{
			System.out.println("Invalid lane");
			return;
		}
		if(lanes[lane] == null)
		{
			lanes[lane] = runner;
		}
		else
		{
			System.out.println("Lane occupied");
			return;
		}
	}


	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int exitCode = -1;
		Racetrack racetrack = Racetrack.getInstance();

		String rawInput;

		// Loops the over the display of a menu, asking the user to choose between
		// displaying the racetrack, adding a Runner to the racetrack, and exiting
		//
		do
		{
			displayMenu();
			rawInput = input.nextLine();

			switch(Character.toUpperCase(rawInput.charAt(0)))
			{
			case 'D':
				racetrack.showLanes();
				break;
			case 'A':
				System.out.print("Which lane? ");
				rawInput = input.nextLine();
				int lane = 0;
				try
				{
					lane = Integer.parseInt(rawInput);
				}
				catch(IllegalArgumentException e) {}
				racetrack.addLane(lane-1, new Runner());
				break;
			case 'X':
				exitCode = 0;
				break;
			}
		}
		while(exitCode != 0);
	}

	public static void displayMenu()
	{
		System.out.print("\n[D]isplay Racetrack\n[A]dd Runner\ne[X]it\n>");
	}
}

class Runner {}

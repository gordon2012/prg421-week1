//
// Singleton Pattern Program
// Gordon Doskas
// PRG/421
// January 25, 2016
// Roland Morales
//

import java.util.Scanner;

public class Main
{
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

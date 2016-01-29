/**
 * Singleton Pattern Program - Week 2 Team Improvements
 *
 * Team B -
 *  ( Elijah Cornell / Eric Landeis / Gordon Doskas / James Rippon /
 *    Joseph Hart / Keith Green / Lance Branford )
 *
 * PRG/421
 * February 1, 2016
 * Roland Morales
 *
 * -
 *
 * The project is based on  Gordon's Week 1 program
 *
 * Team Improvements:
 *  -  Refactored program into separate classes
 *  -  Added localization of strings via Resource Bundles - English and French
 *  -
 *  -
 */

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main
{

    private static Locale locale;
    private static ResourceBundle rb;

    public static ResourceBundle getRB() {
        if (rb == null) {
            rb = ResourceBundle.getBundle("Strings", locale == null ? Locale.getDefault() : locale);
        }
        return rb;
    }

    /**
     *
     * Parameter 1 (Optional) : Localization code value - valid codes (en, fr)
     *
     * @param args Program arguments
     */
    public static void main(String[] args)
	{

        //

        if (args.length > 0 && args[0] != null) {
            locale = new Locale(args[0]);
        }

        //

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

            if (rawInput.equalsIgnoreCase( getRB().getString("menu.display.code") )) {

                racetrack.showLanes();

            } else if (rawInput.equalsIgnoreCase( getRB().getString("menu.add.code") )) {

				System.out.print(getRB().getString("which.lane"));
				rawInput = input.nextLine();
				int lane = 0;
				try
				{
					lane = Integer.parseInt(rawInput);
				}
				catch(IllegalArgumentException e) {}
				racetrack.addLane(lane-1, new Runner());

            } else if (rawInput.equalsIgnoreCase( getRB().getString("menu.exit.code") )) {

                exitCode = 0;

			}
		}
		while(exitCode != 0);
	}

	public static void displayMenu()
	{
		System.out.print("\n"
            + getRB().getString("menu.display") + "\n"
            + getRB().getString("menu.add") + "\n"
            + getRB().getString("menu.exit") + "\n"
            + "> ");
	}
}

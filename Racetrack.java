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
}

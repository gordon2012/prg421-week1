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
            System.out.println(Main.getRB().getString("error.invalid.lane"));
            return;
        }
        if(lanes[lane] == null)
        {
            lanes[lane] = runner;
            System.out.println(Main.getRB().getString("menu.added") + (lane+1));
        }
        else
        {
            System.out.println(Main.getRB().getString("error.lane.occupied"));
            return;
        }
    }
    
    public void showAvailable()
    {
//        int lane;
        System.out.print("[ ");
        for(int i = 0; i < lanes.length; i++)
        {
            System.out.print((lanes[i] != null ? "X" : (i+1)) + " ");
            //String chr = lanes[i] == null ? "X" : ((Integer)i).toString();
//            lane = i;
        }
        System.out.print("]\n> ");    
    }
    
    public int getLastLane()
    {
        int count = 0;
        int loc = -1;
        for(int i = 0; i < lanes.length; i++)
        {
            if(lanes[i] == null)
            {
                count++;
                loc = i;
            }            
        }
        if(count == 1)
        {
            return loc;
        }
        else
        {
            return -1;
        }
    }
    
}

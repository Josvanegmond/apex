package joozey.apps.apex;

/**
 * Created by mint on 5/3/14.
 */

public class NameValue
{
    private int points;
    private String name;

    public NameValue( int points, String name )
    {
        this.points = points;
        this.name = name;
    }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public void addPoints( int amount ) { points += amount; }
}

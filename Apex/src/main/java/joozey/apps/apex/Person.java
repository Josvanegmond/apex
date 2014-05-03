package joozey.apps.apex;

/**
 * Created by mint on 5/3/14.
 */

public class Person
{
    private int points;
    private String name;

    public Person(int points, String name)
    {
        this.points = points;
        this.name = name;
    }

    public String getName() { return this.name; }
    public int getPoints() { return this.points; }
    public void addPoints( int amount ) { this.points += amount; }
}

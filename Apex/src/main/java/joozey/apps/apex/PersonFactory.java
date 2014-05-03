package joozey.apps.apex;

import java.util.ArrayList;

/**
 * Created by mint on 5/3/14.
 */
public class PersonFactory
{
    private static PersonFactory _instance = null;
    public static PersonFactory getInstance()
    {
        if( _instance == null ) { _instance = new PersonFactory(); }
        return _instance;
    }

    private ArrayList<Person> entryList = null;

    private PersonFactory()
    {
        entryList = new ArrayList<Person>();
        entryList.add( new Person( 0, "Adam Jensen [Box F1]" ) );
        entryList.add( new Person( 0, "Megan Reed [Box A2]" ) );
        entryList.add( new Person( 0, "David Serif [Box B3]" ) );
        entryList.add( new Person( 0, "Faridah Malik [Box C4]" ) );
        entryList.add( new Person( 0, "Hugh Darrow [Box D5]" ) );
        entryList.add( new Person( 0, "Frank Pritchard [Box E3]" ) );
        entryList.add( new Person( 0, "William Taggart [Box F2]" ) );
        entryList.add( new Person( 0, "Yelena Fedorova [Box C6]" ) );
        entryList.add( new Person( 0, "Bob Page [Box F1]" ) );
        entryList.add( new Person( 0, "Jaron Namir [Box F1]" ) );
    }

    public ArrayList<Person> getParticipants()
    {
        return entryList;
    }

    public Person getParticipant( int i )
    {
        return entryList.get( i );
    }

    public void addParticipant(String personName)
    {
        entryList.add( new Person( 0, personName ) );
    }
}

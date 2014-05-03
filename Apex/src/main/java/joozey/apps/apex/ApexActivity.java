package joozey.apps.apex;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ApexActivity extends Activity {

    private Fragment addPersonFragment;
    private NametagAdapter nametagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apex);

        ArrayList<NameValue> entryList = new ArrayList<NameValue>();
        entryList.add( new NameValue( 0, "Adam Jensen [Box F1]" ) );
        entryList.add( new NameValue( 0, "Megan Reed [Box A2]" ) );
        entryList.add( new NameValue( 0, "David Serif [Box B3]" ) );
        entryList.add( new NameValue( 0, "Faridah Malik [Box C4]" ) );
        entryList.add( new NameValue( 0, "Hugh Darrow [Box D5]" ) );
        entryList.add( new NameValue( 0, "Frank Pritchard [Box E3]" ) );
        entryList.add( new NameValue( 0, "William Taggart [Box F2]" ) );
        entryList.add( new NameValue( 0, "Yelena Fedorova [Box C6]" ) );
        entryList.add( new NameValue( 0, "Bob Page [Box F1]" ) );
        entryList.add( new NameValue( 0, "Jaron Namir [Box F1]" ) );

        nametagAdapter = new NametagAdapter( this, R.layout.name_tag, entryList );

        ListView nameList = (ListView) this.findViewById( R.id.nametaglist );
        nameList.setAdapter( nametagAdapter );
    }

    public void updateScores( View button )
    {
    }

    public void addPerson( View button )
    {
        addPersonFragment = new AddPersonFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.rootLayout, addPersonFragment);
        ft.commit();
    }

    public void invertPoints( View button )
    {
        nametagAdapter.invertPoints();
    }

    public void deletePerson( View button )
    {

    }

    public void addPersonConfirmed( View button )
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(addPersonFragment);
        ft.commit();
    }
}

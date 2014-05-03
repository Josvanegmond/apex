package joozey.apps.apex;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class ApexActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apex);

        ViewPersonsFragment viewPersonsFragment = new ViewPersonsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.parent_fragment_layout, viewPersonsFragment);
        ft.commit();
    }

    public void updateScores( View button )
    {
    }

    public void addPerson( View button )
    {
        AddPersonFragment addPersonFragment = new AddPersonFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.parent_fragment_layout, addPersonFragment);
        ft.commit();
    }

    public void invertPoints( View button )
    {
        ViewPersonsFragment viewPersonsFragment = (ViewPersonsFragment)getFragmentManager()
                .findFragmentById( R.id.parent_fragment_layout );
        viewPersonsFragment.getNametagAdapter().invertPoints();
    }

    public void deletePerson( View button )
    {

    }

    public void addPersonConfirmed( View button )
    {
        EditText editText = (EditText)this.findViewById( R.id.addperson_name );
        Editable editable = editText.getText();
        String personName = editable.toString();

        PersonFactory.getInstance().addParticipant( personName );

        ViewPersonsFragment viewPersonsFragment = new ViewPersonsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.parent_fragment_layout, viewPersonsFragment);
        ft.commit();
    }
}

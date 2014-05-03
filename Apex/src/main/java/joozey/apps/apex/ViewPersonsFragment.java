package joozey.apps.apex;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by mint on 5/3/14.
 */
public class ViewPersonsFragment extends Fragment
{
    private ListView nameList;
    private NametagAdapter nametagAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpersons_fragment,
                container, false);

        nameList = (ListView) view.findViewById(R.id.nametaglist);

        return view;
    }

    @Override
    public void onActivityCreated( Bundle bundle )
    {
        super.onActivityCreated( bundle );

        nametagAdapter = new NametagAdapter( this.getActivity(), R.layout.name_tag );
        nameList.setAdapter( nametagAdapter );
    }

    public NametagAdapter getNametagAdapter()
    {
        return this.nametagAdapter;
    }

}

package joozey.apps.apex;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by mint on 5/2/14.
 */
public class NametagAdapter extends ArrayAdapter<Person> implements View.OnClickListener
{
    private static class NameHolder
    {
        public int personId;
        public View tagView;
        public TextView nameView;
        public TextView pointButton;
        public TextView pointView;
    }

    private static int getColor( int points )
    {
        points = (points - 50) * 5;
        return Color.argb( 255, 255 - Math.max(0, points), 255 + Math.min( 0, points ), 24 );
    }

    private boolean addPoints = true;

    public NametagAdapter( Context context, int entryId )
    {
        super(context, entryId, PersonFactory.getInstance().getParticipants() );
    }

    public void invertPoints() {
        this.addPoints = !this.addPoints;
        super.notifyDataSetChanged();
    }


    @Override
    public View getView( int position, View tagView, ViewGroup viewGroup )
    {
        NameHolder holder = null;
        Person person = PersonFactory.getInstance().getParticipant(position);

        if( tagView == null )
        {
            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            tagView = inflater.inflate( R.layout.name_tag, viewGroup, false );

            TextView nameView = (TextView)tagView.findViewById( R.id.nametag_name );
            nameView.setText( person.getName() );

            TextView pointView = (TextView) tagView.findViewById( R.id.point_view );
            pointView.setText( person.getPoints() + "" );

            TextView pointButton = (TextView) tagView.findViewById( R.id.point_button );
            pointButton.setOnClickListener( this );

            holder = new NameHolder();
            holder.personId = position;
            holder.nameView = nameView;
            holder.pointView = pointView;
            holder.pointButton = pointButton;
            holder.tagView = tagView;

            tagView.setTag( R.string.entry_holder, holder );
            pointButton.setTag( R.string.entry_holder, holder );
        }

        else
        {
            holder = (NameHolder)tagView.getTag( R.string.entry_holder );
            holder.personId = position;
            person = PersonFactory.getInstance().getParticipant( holder.personId );
        }

        holder.nameView.setText( person.getName() );
        holder.pointView.setText( person.getPoints() + "" );
        holder.pointButton.setText( (this.addPoints == true) ? "+" : "-");
        holder.tagView.setBackgroundColor(getColor(person.getPoints()));

        return tagView;
    }

    public void onClick( View view )
    {
        NameHolder holder = (NameHolder)view.getTag( R.string.entry_holder );
        Person person = PersonFactory.getInstance().getParticipant( holder.personId );

        person.addPoints( (this.addPoints == true) ? 10 : -10 );

        holder.pointView.setText( person.getPoints() + "" );
        holder.tagView.setBackgroundColor( getColor( person.getPoints() ) );
    }

}

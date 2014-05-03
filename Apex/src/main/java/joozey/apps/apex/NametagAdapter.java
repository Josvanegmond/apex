package joozey.apps.apex;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mint on 5/2/14.
 */
public class NametagAdapter extends ArrayAdapter<NameValue> implements View.OnClickListener
{
    private static class NameHolder
    {
        public NameValue nameValue;
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

    private boolean addPoints;
    private List<NameValue> nameList;

    public NametagAdapter( Context context, int entryId, List<NameValue> nameList )
    {
        super(context, entryId, nameList);
        this.nameList = nameList;
    }

    public void invertPoints() {
        this.addPoints = !this.addPoints;
        super.notifyDataSetChanged();
    }


    @Override
    public View getView( int i, View view, ViewGroup viewGroup )
    {
        NameHolder holder = null;
        NameValue nameValue = nameList.get( i );

        if( view == null )
        {
            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate( R.layout.name_tag,  viewGroup, false );

            TextView nameView = (TextView)view.findViewById( R.id.nametag_name );
            nameView.setText( nameValue.getName() );

            TextView pointView = (TextView) view.findViewById( R.id.point_view );
            pointView.setText( nameValue.getPoints() + "" );

            TextView pointButton = (TextView) view.findViewById( R.id.point_button );
            pointButton.setOnClickListener( this );

            holder = new NameHolder();
            holder.tagView = view;
            holder.nameView = nameView;
            holder.pointButton = pointButton;
            holder.pointView = pointView;
            holder.nameValue = nameValue;

            view.setTag( R.string.entry_holder, holder );
            pointButton.setTag( R.string.entry_holder, holder );
        }

        else
        {
            holder = (NameHolder)view.getTag( R.string.entry_holder );
        }

        holder.nameValue = nameValue;
        holder.nameView.setText( nameValue.getName() );
        holder.pointView.setText( nameValue.getPoints() + "" );
        holder.pointButton.setText( (this.addPoints == true) ? "+" : "-");
        holder.tagView.setBackgroundColor(getColor(nameValue.getPoints()));

        return view;
    }



    public void onClick( View view )
    {
        NameHolder holder = (NameHolder)view.getTag( R.string.entry_holder );
        NameValue nameValue = holder.nameValue;

        nameValue.addPoints( (this.addPoints == true) ? 10 : -10 );

        holder.pointView.setText( nameValue.getPoints() + "" );
        holder.tagView.setBackgroundColor( getColor( nameValue.getPoints() ) );
    }

}

package comsci.kalin.bookshop;

/**
 * Created by Kalin on 5/3/2017.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadepter extends BaseAdapter {

    //Eplicit
    private Context context ;
    private int[] ints ;
    private String[] titleStrings,detailStrings ;

    //Alt + Insert add Constuctor for implement method

    public Myadepter(TypeBook typeBook, int[] ints, String[] titleStrings) {
        this.context = context ;
        this.ints = ints ;
        this.titleStrings = titleStrings ;
        this.detailStrings = detailStrings ;
    }

    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // recieve information then send to show on app

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        //Intitial View
        ImageView imageView = (ImageView) view.findViewById(R.id.imvIcon);
        TextView titleTextView = (TextView) view.findViewById(R.id.txttitleLiv);
        TextView detailTextView = (TextView) view.findViewById(R.id.txtDetailLiv);

        //Show View send information to show on app
        imageView.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detailStrings[position]);
        return view;
    }

}

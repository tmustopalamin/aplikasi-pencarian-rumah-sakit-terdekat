package com.example.admientoto.cobacoba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class rsListAdapter extends ArrayAdapter<rsList> {
    public rsListAdapter(Activity context, ArrayList<rsList> RSnya) {

        super(context, 0, RSnya);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        listItemView = null;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_layout, parent, false);
        }else{
           //?
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        rsList currentrsList = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = listItemView.findViewById(R.id.tvNamaCustom);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentrsList.getnamaRS());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView jarakTextView = listItemView.findViewById(R.id.tvJarak);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        jarakTextView.setText(new DecimalFormat("##.##").format(currentrsList.getJarakRS()) + "KM ");

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
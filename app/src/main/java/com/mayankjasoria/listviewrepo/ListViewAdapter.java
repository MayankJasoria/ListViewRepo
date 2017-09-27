package com.mayankjasoria.listviewrepo;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class for ListView. It handles displaying of views in the ListView and swtiching on clicking the button
 */

public class ListViewAdapter extends ArrayAdapter<String> {

    ArrayList<String> list;
    ArrayList<Integer> viewTypes;

    public ListViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.list = objects;
        viewTypes = new ArrayList<Integer>(list.size());
        for(int i = 0; i < list.size(); i++) {
            viewTypes.add(0);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        View listItemView = convertView;
        int viewType = getItemViewType(position);
        if(convertView == null)
        {
            int layoutResId = viewType == 0 ? R.layout.list_element_main : R.layout.list_element_switch;
            listItemView = LayoutInflater.from(getContext()).inflate(layoutResId, parent, false);
        }
        if(viewType == 0) {
            listItemView.findViewById(R.id.switch_layout_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewTypes.remove(position);
                    viewTypes.add(position, 1);
                    notifyDataSetChanged();
                }
            });
        }

        return listItemView;
    }
}

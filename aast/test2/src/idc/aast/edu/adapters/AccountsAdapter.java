package idc.aast.edu.adapters;

import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;


import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class AccountsAdapter extends BaseAdapter {
	 
    private  Activity context;
    private  ArrayList<String> cats;

    private String selected;
    public AccountsAdapter(Activity context, ArrayList<String> cats,String selected) {

       
        this.context = context;
        this.cats = cats;
        this.selected= selected;
      
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    	
    	
        // 1. Create inflater
        LayoutInflater inflater = context.getLayoutInflater();

        // 2. Get rowView from inflater
        convertView = inflater.inflate(R.layout.simple_list_item_2, null);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) convertView.findViewById(R.id.text212);
        TextView type = (TextView) convertView.findViewById(R.id.text214);
        CheckBox ch = (CheckBox) convertView.findViewById(R.id.text213);

        // 4. Set the text for textView
        labelView.setText(cats.get(position).substring(1));
        if(cats.get(position).substring(0,1).equals("0"))
        {
        	type.setText("„ÊŸ›");
        }
        else
        {
        	type.setText("ÿ«·»");
        }
        if(!cats.get(position).substring(1).equals(selected))
        {
        	ch.setVisibility(View.INVISIBLE);
        }
        else
        {
        	ch.setVisibility(View.VISIBLE);
        }
        
        // 5. retrn rowView
        return convertView;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cats.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
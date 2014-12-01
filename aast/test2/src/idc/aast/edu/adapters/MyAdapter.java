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
import android.widget.TextView;
 
public class MyAdapter extends BaseAdapter {
 
        private  Activity context;
        private  ArrayList<String> cats;
        private  ArrayList<String> counts;
        public MyAdapter(Activity context, ArrayList<String> cats, ArrayList<String> counts) {
 
           
            this.context = context;
            this.cats = cats;
            this.counts = counts;
        }
 @Override
public void notifyDataSetChanged() {
// TODO Auto-generated method stub
super.notifyDataSetChanged();
}
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
 
        	
        	
            // 1. Create inflater
            LayoutInflater inflater = context.getLayoutInflater();
 
            // 2. Get rowView from inflater
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
 
            // 3. Get the two text view from the rowView
            TextView labelView = (TextView) convertView.findViewById(R.id.text111);
            TextView valueView = (TextView) convertView.findViewById(R.id.text222);
 
            // 4. Set the text for textView
            labelView.setText(cats.get(position));
            valueView.setText(counts.get(position));
 
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
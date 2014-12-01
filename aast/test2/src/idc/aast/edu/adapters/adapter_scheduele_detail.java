package idc.aast.edu.adapters;

import idc.aast.edu.classes.scheduele_slot;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class adapter_scheduele_detail extends BaseAdapter {

	Activity context;
	ArrayList<scheduele_slot> slots;

	// TODO Auto-generated con structor stub
	public adapter_scheduele_detail(Activity context,
			ArrayList<scheduele_slot> slots) {
		this.context = context;
		this.slots = slots;
	}
static int dpi;
	private class ViewHolder {

		/** The link t. */
		TextView course_name;
		TextView course_code;
		TextView room_data;
		TextView name;
		TextView kind;
		TextView lect_no;
		TextView lect_no_split_top;
		TextView lect_no_split_bot;

		/** The Count t. */

	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		LayoutInflater inflater = context.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.scheduele_detail_item, null);
			holder = new ViewHolder();
			holder.course_name = (TextView) convertView.findViewById(R.id.course_name);
			holder.course_code= (TextView) convertView.findViewById(R.id.course_code);
			holder.room_data= (TextView) convertView.findViewById(R.id.room);
			holder.name= (TextView) convertView.findViewById(R.id.lect_name);
			holder.kind= (TextView) convertView.findViewById(R.id.slot_type);
			holder.lect_no= (TextView) convertView.findViewById(R.id.lect_no);
			holder.lect_no_split_top= (TextView) convertView.findViewById(R.id.sch_det_right_top_lev_2);
			holder.lect_no_split_bot= (TextView) convertView.findViewById(R.id.sch_det_right_bot_lev_2);
			

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		  
		for (int i=0 ;i<slots.size();i++) {
			scheduele_slot current = slots.get(i);
			int start = Integer.parseInt(current.getFrom());
			int end  = Integer.parseInt(current.getTo());
			position+=1;
			if((start) == position*2 || (start)==(position *2 -1 )  )
			{
				holder.course_name.setText(current.getCourse());
				holder.course_code.setText(current.getCourse_code());
				holder.room_data.setText(current.getRoom_num());
				holder.name.setText(current.getName());
				holder.kind.setText(current.getType());
				holder.lect_no.setText(position + "");
				holder.lect_no_split_top.setText((position*2-1) +"");
				holder.lect_no_split_bot.setText((position*2 ) + "");
break;			}
			position-=1;
			
		}
		  int temd=dpi/7;
		    if(temd<110)
		    	temd=120;
			convertView.setMinimumHeight(100);
				convertView.setMinimumHeight(300);
		// TODO Auto-generated method stub
		return convertView;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
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

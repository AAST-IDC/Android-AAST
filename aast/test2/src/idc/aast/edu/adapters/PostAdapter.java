package idc.aast.edu.adapters;

import idc.aast.edu.classes.Post;
import idc.aast.edu.classes.community.Group;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.test2.R;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PostAdapter extends BaseAdapter {

	Activity context;
	ArrayList<Post> posts;

	private class ViewHolder {

		/** The link t. */
		TextView p_time;
		TextView user_name;
		TextView p_text;
		ImageView p_image;
	}

	public PostAdapter(Activity context, ArrayList<Post> posts) {
		this.context = context;
		this.posts = posts;
		// TODO Auto-generated constructor stub
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		LayoutInflater inflater = context.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.post_item, null);
			holder = new ViewHolder();
			holder.p_time = (TextView) convertView
					.findViewById(R.id.p_time);
			holder.p_text = (TextView) convertView.findViewById(R.id.post_text);
			holder.user_name = (TextView) convertView
					.findViewById(R.id.user_name);
			holder.p_image =  (ImageView) convertView
					.findViewById(R.id.p_image);
			// holder.desc = (TextView)
			// convertView.findViewById(R.id.news_desc);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		 
			 java.util.Date date= new java.util.Date();
			
		Post p = posts.get(position);
		holder.p_time.setText(date.toString());
		holder.p_text.setText(p.post_text);
		holder.user_name.setText(p.user_name);
		
		MySQLiteHelper db = new MySQLiteHelper(context);
		byte[] decodedString = Base64.decode(db.getImage("3672"), Base64.DEFAULT);
		Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
;
		holder.p_image.setImageBitmap(decodedByte);
		
		
		// holder.desc.setText(n.desc);

		// TODO Auto-generated method stub
		return convertView;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return posts.size();
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

package idc.aast.edu.classes;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class news_item  implements Parcelable{

	public String title;
	public String desc;
	public String link;
	public String date;
	public String id;
	public news_item() {
		// TODO Auto-generated constructor stub
		
	}
	public news_item(Parcel in)
	{
		
		String[] data= new String[4];
		 
		in.readStringArray(data);
		this.title= data[0];
		this.desc= data[1];
		this.link= data[1];
		this.date= data[1];
	}
	public news_item(JSONObject j)
	{

		try {
			title= j.getString("title");
			desc = j.getString("description");
			link = j.getString("link");
			date = j.getString("date");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public news_item(String title,String desc,String link,String date)
	{
		this.title=title;
		this.desc=desc;
		this.link=link;
		this.date = date;
	}
	public static final Parcelable.Creator<news_item> CREATOR= new Parcelable.Creator<news_item>() {
		 
		@Override
		public news_item createFromParcel(Parcel source) {
		// TODO Auto-generated method stub
		return new news_item(source);  //using parcelable constructor
		}
		 
		@Override
		public news_item[] newArray(int size) {
		// TODO Auto-generated method stub
		return new news_item[size];
		}
		};
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringArray(new String[]{this.title,this.desc,this.link,this.date});
		// TODO Auto-generated method stub
		
	}
	
}

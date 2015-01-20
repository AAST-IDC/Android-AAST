package idc.aast.edu.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {

	public String post_id;
	public String user_id;
	public String user_name;
	public String post_text;
	public String comment_count;
	public String comment_enabled;
	public String group_id;
	public String post_date;
	public Post(JSONObject j,String g_id) {

		try {
			post_id = j.getString("post_id");
			user_id = j.getString("user_id");
			user_name = j.getString("user_name");
			post_text = j.getString("posts_text");
			comment_count = j.getString("comment_count");
			comment_enabled = j.getString("comment_enabled");
			post_date = j.getString("post_date");
			group_id = g_id;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated constructor stub
	}

	public Post(String post_id, String user_id, String user_name,String group_id,
			String post_text, String comment_count, String comment_enabled,String post_date ) {

		this.post_id =post_id ;
		this.user_id = user_id;
		this.user_name = user_name;
		this.post_text =post_text ;
		this.comment_count =comment_count ;
		this.comment_enabled = comment_enabled;
		this.post_date = post_date;
		this.group_id = group_id;
		// TODO Auto-generated constructor stub
	}

}

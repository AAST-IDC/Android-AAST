package idc.aast.edu.CallWeb;

import org.json.JSONArray;
import org.json.JSONObject;

import idc.aast.Other.CommunityDatabase;
import idc.aast.Other.MySQLiteHelper;
import idc.aast.edu.classes.news_item;
import idc.aast.edu.classes.community.Group;
import android.content.Context;

public class CommunityCaller extends Thread {

	public String function;
	public Context con;
	public String user_id;
	public String user_type;

	public CommunityCaller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		if (function.toLowerCase().equals("getusergroups")) {

			try {
				CommunityCallSoap cs = new CommunityCallSoap();
				String rslt = cs.get_user_groups(user_id, user_type);
				
				if (rslt.equals("error")) {
					// rslt= preferences1.getString("settlinks",
					// "@name^http://www.aast.edu@name2^http://www.aast.edu@");
				} else {
					CommunityDatabase db = new CommunityDatabase(con);
					JSONObject reader = new JSONObject(rslt);
					JSONArray arr = reader.getJSONArray("UserGroups");
					for (int i=0 ; i<arr.length();i++) {
						Group g = new Group(arr.getJSONObject(i));
						db.insert_group(g);
					}

					
				}

			} catch (Exception ex) {
			

			}
		}
		super.run();
	}

}

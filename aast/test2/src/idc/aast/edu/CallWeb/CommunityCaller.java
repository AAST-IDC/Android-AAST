package idc.aast.edu.CallWeb;

import org.json.JSONArray;
import org.json.JSONObject;

import idc.aast.edu.classes.Post;
import idc.aast.edu.classes.news_item;
import idc.aast.edu.classes.community.Group;
import idc.aast.edu.database.CommunityDatabase;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.edu.webservice.STDWEBService1Soap;
import android.content.Context;

public class CommunityCaller extends Thread {

	
	public String done ;
	public String function;
	public Context con;
	public String user_id;
	public String user_type;
	public String group_id;
	public String all_ids;

	public CommunityCaller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		if (function.toLowerCase().equals("getusergroups")) {

			try {
				CommunityCallSoap cs = new CommunityCallSoap();
				STDWEBService1Soap ws = new STDWEBService1Soap();
				
				String rslt =  cs.get_user_groups(user_id, user_type);
				
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
					String usname = reader.getString("name");
					MySQLiteHelper db2 = new MySQLiteHelper(con);
					db2.setname(usname, user_id);
					String depname = reader.getString("dep_name");
					db2.setdepname(depname, user_id);
					String title = reader.getString("title");
					db2.settitle(title, user_id);
					
					
				}

			} catch (Exception ex) {
			

			}
		}
		else if (function.equals("getGroupPosts")) {

			try {
				CommunityCallSoap cs = new CommunityCallSoap();
				STDWEBService1Soap ws = new STDWEBService1Soap();
				
			//	String rslt =   ws.get_student_Info("8101423");// cs.get_user_groups(user_id, user_type);
				String rslt = cs.get_group_posts(user_id, user_type, group_id, all_ids);
	
				if (rslt.equals("error")) {
					
					// rslt= preferences1.getString("settlinks",
					// "@name^http://www.aast.edu@name2^http://www.aast.edu@");
				} else {
					CommunityDatabase db = new CommunityDatabase(con);
					JSONObject reader = new JSONObject(rslt);
					JSONArray arr = reader.getJSONArray("posts");
					for (int i=0 ; i<arr.length();i++) {
						Post p = new Post(arr.getJSONObject(i),group_id); 
						db.insert_post(p,user_id);
					}

					
				}
				done="yes";

			} catch (Exception ex) {
			

			}
		}
		super.run();
	}

}

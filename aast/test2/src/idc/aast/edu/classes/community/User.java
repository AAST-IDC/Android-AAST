package idc.aast.edu.classes.community;

import idc.aast.Other.CommunityDatabase;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class User {

	public String user_id;
	public String user_type;	
	public Context con;
	public  ArrayList<Group> UsGroups;
	public User(Context con,String user_id,String user_type) {
		this.con =con;
		this.user_id =user_id;
		this.user_type = user_type;
		CommunityDatabase db = new CommunityDatabase(con);
		UsGroups =  db.get_user_groups(user_id);
		// TODO Auto-generated constructor stub
	}
	public void addGroup(Group g)
	{
		UsGroups.add(g);
	}

}

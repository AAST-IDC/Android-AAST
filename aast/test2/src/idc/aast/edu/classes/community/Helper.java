package idc.aast.edu.classes.community;

import idc.aast.edu.CallWeb.Caller;
import idc.aast.edu.CallWeb.CommunityCaller;
import android.content.Context;

public class Helper {

	public Helper() {
		// TODO Auto-generated constructor stub
	}
	static public void getGroups(String name,Context context )
	{
		  
		CommunityCaller c= new CommunityCaller();
		c.user_id = name;
		c.user_type="0";
		c.con=context;
		// get the links of the inbox , outbox .....
		c.function = "getusergroups";

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
	
	}
	static public void getPosts(String name ,  String user_type, String group_id, String all_ids,Context context )
	{
		
		CommunityCaller c= new CommunityCaller();
		c.user_id = name;
		c.user_type=user_type;
		c.group_id = group_id;
		c.all_ids = all_ids;
		c.con=context;
		// get the links of the inbox , outbox .....
		c.function = "getGroupPosts";

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
	
	}

}

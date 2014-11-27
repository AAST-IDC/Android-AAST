package idc.aast.test2;

import java.net.InetAddress;

import android.content.Context;
import android.content.SharedPreferences;

public class helper {
	
	static public void getall(Context context , String name,String type,SharedPreferences preferences1)
	{
		Caller c = new Caller();

		c.preferences1=preferences1;
		c.con=context;
		c.c = "getsettings"; // set the webservice action name
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		// wait for the webservice to return the result
		
		c = new Caller();
		c.a = name;
		c.b=type;
		c.con=context;
		c.preferences1=preferences1;
		c.c = "getcounts";
		// call the webservice to retrieve the counts for (inbox, outbox, ... ) because it takes very long time
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		// put the settings syscode in the settings actvity class
	
		 c = new Caller();
		c.a = name;
		c.b=type;
	
		c.con=context;
		c.preferences1=preferences1;
		// get the links of the inbox , outbox .....
		c.c = "getlinks";
		c.con = context;

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		c= new Caller();
		c.a = name;
		c.b=type;
		c.con=context;
		// get the links of the inbox , outbox .....
		c.c = "getresult";

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
		
		c= new Caller();
		c.a = name;
		c.b=type;
		c.con=context;
		// get the links of the inbox , outbox .....
		c.c = "get_scheduele";

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
		
		c= new Caller();
		c.a = name;
		c.b=type;
		c.con=context;
		// get the links of the inbox , outbox .....
		c.c = "getlinks_morasalat";

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
		
		
		
		
		
	}
	static public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com"); //You can replace it with your name

            if (ipAddr.equals("")) {
                return false;
            } else {
                return true; 
            }

        } catch (Exception e) {
            return false;
        }

    }
}

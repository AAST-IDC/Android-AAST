package idc.aast.edu.database;

import idc.aast.edu.CallWeb.Caller;
import idc.aast.edu.webservice.STDWEBIServiceEvents;
import idc.aast.edu.webservice.STDWEBOperationResult;
import idc.aast.edu.webservice.STDWEBService1Soap;
import idc.aast.edu.webservice.STDWEBService1Soap12;

import java.net.InetAddress;

import android.content.Context;
import android.content.SharedPreferences;

public class helper {
	
	static public void getall(Context context , String name,String type,SharedPreferences preferences1)
	{
		Caller c ;//;= new Caller();
//
//		c.preferences1=preferences1;
//		c.con=context;
//		c.c = "getsettings"; // set the webservice action name
//		try {
//			c.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		c.start();
//		// wait for the webservice to return the result
////		
//		c = new Caller();
//		c.a = name;
//		c.b=type;
//		c.con=context;
//		c.preferences1=preferences1;
//		c.c = "getcounts";
//		// call the webservice to retrieve the counts for (inbox, outbox, ... ) because it takes very long time
//		try {
//			c.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		c.start();
//		// put the settings syscode in the settings actvity class
//	
		
		STDWEBService1Soap ws = new STDWEBService1Soap(new STDWEBIServiceEvents() {
			
			@Override
			public void Starting() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void Completed(STDWEBOperationResult result) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
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
		
		      
		
		
		 c = new Caller();
			c.a = name;
			c.b=type;
		
			c.con=context;
			c.preferences1=preferences1;
			// get the links of the inbox , outbox .....
			c.c = "get_image";
			c.con = context;

			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.start();
			
		
	
	
		c= new Caller();
		MySQLiteHelper db = new MySQLiteHelper(context);
		
		c.a =db.get_last_news_date();
		c.b=type;
		c.con=context;
		// get the links of the inbox , outbox .....
		c.c = "get_news";

		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
		getScheduele(name,context);
		getResults_all(name,context);
		
	}
	static public void getResults_all(String name,Context context )
	{
		
		Caller c= new Caller();
    		c.a = name;
		c.b="all";
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
	
	
	}
	static public void getResults_last(String name,Context context )
	{
		
		Caller c= new Caller();
		c.a = name;
		c.b="last";
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
	
	
	}
	static public void getScheduele(String name,Context context )
	{
		
		Caller c= new Caller();
		c.a = name;
		c.b="1";
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
		
		
	
	}
	static public void getMorasalat(String name,Context context )
	{
		
		Caller 	c= new Caller();
		c.a = name;
		c.b="0";
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

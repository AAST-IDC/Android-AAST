/*
 * 
 */
package idc.aast.edu.CallWeb;

import idc.aast.Other.MySQLiteHelper;
import idc.aast.edu.activities.ListActivity;
import idc.aast.edu.activities.LinksList;
import idc.aast.edu.activities.Login;
import idc.aast.edu.activities.Morasalat;
import idc.aast.edu.classes.news_item;
import idc.aast.edu.classes.result_item;
import idc.aast.edu.classes.scheduele_slot;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
// this class calls the right webservice from call soap class

/**
 * The Class Caller.
 */
@TargetApi(10)
public class Caller extends Thread {

	/** The cs. */
	public CallSoap cs;

	/** The c. */
	public String a, b, c, d;   
	

	/** The con. */
	public Context con;

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public SharedPreferences preferences1;

	public void run() {
		
		if (c.equals("main"))
			// login webservice
			try {
				cs = new CallSoap();
				String resp = cs.Call(a, b);
				Login.rslt = resp;
			} catch (Exception ex) {
				Login.rslt = ex.toString();

			}
		else if (c.equals("amr"))
			// update webservice
			try {

				cs = new CallSoap();
				String resp = cs.Call2(a, b);

				ListActivity.rslt = resp;
				if (resp.equals("Updated")) {
					Toast.makeText(con, "You have the latest version",
							Toast.LENGTH_SHORT).show();

				} else if (resp.equals("ERROR")) {
					Toast.makeText(
							con,
							"Error Connecting to the host.\n Please try Again later",
							Toast.LENGTH_SHORT).show();

				}

				else {
					Uri uri = Uri.parse(resp);

					con.startActivity(new Intent(Intent.ACTION_VIEW, uri));

				}
			} catch (Exception ex2) {
				Login.rslt = ex2.toString();
			}
		else if (c.equals("read"))
			// mark as read webservice
			try {
				cs = new CallSoap();
				cs.read(a, b, d);

			} catch (Exception ex) {
				Login.rslt = ex.toString();

			}
		else if (c.equals("unread"))
			// Mark As Unread web service
			try {
				cs = new CallSoap();
			 cs.unread(a, b,d);

			} catch (Exception ex) {
				Login.rslt = ex.toString();

			}
		else if (c.equals("remove"))
			// remove item
			try {
				cs = new CallSoap();
			 cs.remove(a, b,d);

			} catch (Exception ex) {
				Login.rslt = ex.toString();

			}
		else if (c.equals("getall"))
			// get all th e previous notification webservice
			try {
				cs = new CallSoap();
		cs.getall(a, b);
				Login.rslt = "ssa";
			} catch (Exception ex) {
				Login.rslt = "ssa";

			}
		else if (c.equals("gettype"))
			// not used
			try {
				cs = new CallSoap();
			 cs.GetType(a);
				Login.rslt = "ssa";
			} catch (Exception ex) {
				Login.rslt = "ssa";

			}
		else if (c.equals("calls"))
			// not used
			try {
				cs = new CallSoap();
				 cs.Calls(a, b);
				Login.rslt = "ssa";
			} catch (Exception ex) {
				Login.rslt = "ssa";

			}
			else if (c.equals("getlinks_morasalat"))
			{
				// not used
				try {
					cs = new CallSoap();
					String resp = cs.getlinks_morasalast(a, b);
					MySQLiteHelper db=new MySQLiteHelper(con);
					db.setmorasalat(resp, a);
				
				} catch (Exception ex) {
					Morasalat.rslt = "error";

				}   
			}
		
			else if (c.equals("get_news"))
			{
				// not used
				try {
					cs = new CallSoap();
					if(a==null)
						a="0";
					String resp = cs.get_news(a, b);
					if(!resp.equals("error"))
					{
						
					MySQLiteHelper db=new MySQLiteHelper(con);
					JSONObject reader = new JSONObject(resp);
					JSONArray arr = reader.getJSONArray("news");
					for (int i=0 ; i<arr.length();i++) {
						news_item news = new news_item(arr.getJSONObject(i));
						db.insert_news(news);
					}
					db.setresults(resp, a);
					}
				
				} catch (Exception ex) {
					Morasalat.rslt = "error";

				}
			}
			else if (c.equals("getresult"))
			{
				// not used
				try {
					cs = new CallSoap();
					String resp = cs.getresults(a, b);
					if(!resp.equals("error"))
					{
						
					MySQLiteHelper db=new MySQLiteHelper(con);
					JSONObject reader = new JSONObject(resp);
					JSONArray arr = reader.getJSONArray("results");
					for (int i=0 ; i<arr.length();i++) {
						result_item res = new result_item(arr.getJSONObject(i),a);
						db.insert_result(res);
					}
					db.setresults(resp, a);
					}
				
				} catch (Exception ex) {
					Morasalat.rslt = "error";

				}
			}
		
			else if (c.equals("get_scheduele"))
			{
				// not used
				try {
					cs = new CallSoap();
					String resp = cs.get_scheduele(a, b);
					if(!resp.equals("error"))
					{
						
					MySQLiteHelper db=new MySQLiteHelper(con);
					JSONObject reader = new JSONObject(resp);
					JSONArray arr = reader.getJSONArray("scheduele");
					for (int i=0 ; i<arr.length();i++) {
						scheduele_slot sch = new scheduele_slot(arr.getJSONObject(i),a);
						db.insert_scheduele(sch);
					}
					db.setresults(resp, a);
					}
				
				} catch (Exception ex) {
					Morasalat.rslt = "error";

				}
			}
		else if (c.equals("getlinks"))
		{
			String rslt;
			// get the links of certain employee of (outbox, inbox , ... )
			try {
				cs = new CallSoap();
				 rslt = cs.getlinks(a, b);
				
			
			
				if(rslt.equals("error"))
				{
					//rslt= preferences1.getString("settlinks", "@name^http://www.aast.edu@name2^http://www.aast.edu@");
				}
				else
				{
					MySQLiteHelper db=new MySQLiteHelper(con);
					db.setLinks(rslt, a);
				}
				
			} catch (Exception ex) {
				//rslt= preferences1.getString("settlinks", "@name^http://www.aast.edu@name2^http://www.aast.edu@");

			}
		//	List_detail.rslt2 = rslt;
		}
		else if (c.equals("getcounts"))
		{
			String rslt;
			// get the counts of certain employee of (outbox, inbox , ... )
			try {
				cs = new CallSoap();
				 rslt = cs.getcounts(a, b);
				
				if(rslt.equals("error"))
				{
				}
				else
				{
					MySQLiteHelper db=new MySQLiteHelper(con);
					db.setCounts(rslt, a);
				}
				
				
				
			} catch (Exception ex) {
				rslt = "0^0^0^0";

			}
			
		}
		else if (c.equals("getsettings")) {
			// get the settings menu options
			String rslt;
			try {
				cs = new CallSoap();
				rslt = cs.getsettings(a, b);

				LinksList.count = "0^0^0^0"; // initialize the count

				// wait for the webservice to return the result
				while (rslt == "START") {
					try {
						Thread.sleep(10);
					} catch (Exception ex) {
					}
				}
				if (rslt.equals("error")) {

					rslt = preferences1.getString("settpref", " @ ");
					// in case of no internet connection it will retrieve the
					// prev settings

				} else {

					// in case of connection it will save the settings data for
					// further use
					Editor edit3 = preferences1.edit();
					Login.rslt = rslt;
					edit3.putString("settpref", rslt);
					edit3.commit();
				}
				// MainActivity.rslt = resp;
			} catch (Exception ex) {
				rslt = preferences1.getString("settpref", " @ ");

			}
			int prev = 0;
			int nw = 0;
		//	int ii = 0; 
			
		
			String x = rslt.substring(0, rslt.indexOf('@'));

			// parse the settings string and put it in the myservice class so
			// the new notification can be filtered
			String name=preferences1.getString("username", "noone");
			while (x.indexOf('^', prev) != -1) {
				nw = x.indexOf('^', prev);

			
				prev = nw + 1;
				//ii++;
			}
		}
	}

	/**
	 * Run2.
	 */
	public void run2() {

	}
}
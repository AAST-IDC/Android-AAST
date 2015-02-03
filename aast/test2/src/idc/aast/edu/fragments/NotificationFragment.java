package idc.aast.edu.fragments;

import idc.aast.edu.CallWeb.Caller;
import idc.aast.edu.activities.Accounts;
import idc.aast.edu.activities.ListActivity;
import idc.aast.edu.activities.Login;
import idc.aast.edu.adapters.NotificationAdapter;
import idc.aast.edu.adapters.DrawerAdapter;
import idc.aast.edu.classes.Message;
import idc.aast.edu.database.MySQLiteHelper;

import idc.aast.test2.R;

import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.parse.PushService;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class NotificationFragment extends Fragment {

	private boolean doubleBackToExitPressedOnce = false; // boolean for exiting
	private static Activity context;

	// the task

	static String filter = "";

	/** The lis2t. */
	static ArrayList<String> lis2t;
	static DrawerAdapter s;
	/** The list. */
	static ListView list; // Current list

	/** The lview adapter. */
	static NotificationAdapter lviewAdapter; // List Custom adapter

	/** The arr. */
	static ArrayList<String> arr; // contains list items
	static ArrayList<Message> msgs;
	/** The name. */
	static String name; // username
	static String type; // username
	/** The rslt. */
	static String rslt; // recieve result from webservice

	static Map<String, Integer> map;
	/** The tabs. */
	private String[] tabs = { "Links", "Notifications" }; // the names of the
															// tabs in the
															// action bar
	/** The bb. */
	static Boolean bb = false;

	/** The ivb. */
	static Boolean ivb = false;

	static ArrayList<String> arr4;
	static ArrayList<String> arr5;
	/** The rslt2. */
	static Set<String> set;

	// private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	private class ViewHolder {

		/** The txt view title. */
		TextView txtViewTitle;

		/** The txt view description. */
		TextView txtViewDescription;

		/** The time. */
		// TextView time;

		/** The year. */
		// TextView year;

		// /** The dumm. */
		// TextView dumm;

		/** The dumm1. */
		// TextView dumm1;

		/** The dumm2. */
		TextView col;

		/** The cat. */
		TextView cat;

		/** The date. */
		TextView date;

		/** The l layout. */
		// LinearLayout lLayout;

	}

	@Override
	public void onStart() {

		context = getActivity();
		bb = false;

		if (getResources().getString(R.string.app_config).equals("small")) {
			// mPlanetTitles = getResources()
			// .getStringArray(R.array. planets_array);
			mDrawerLayout = (DrawerLayout) getView().findViewById(
					R.id.drawer_layout);

		}
		SharedPreferences preferences1 = context
				.getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		type = preferences1.getString("type", "noone");

		PushService.subscribe(context.getApplicationContext(), "a" + name,
				Login.class);

		mDrawerList = (ListView) context.findViewById(R.id.left_drawer);

		MySQLiteHelper db = new MySQLiteHelper(context.getApplicationContext());

		arr4 = db.getSysNames(name, type);
		arr5 = db.getSysNamesCounts(name, type);
		// mPlanetTitles = arr4.toArray(new String[0]);
		// Set the adapter for the list view
		s = new DrawerAdapter(context, arr4, arr5);

		mDrawerList.setAdapter(s);
		// Set the list's click listener

		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ListActivity.setFilter(arr4.get(arg2));
				if (arr4.get(arg2).equals("All"))
					filter = "";
				if (getResources().getString(R.string.app_config).equals(
						"small")) {
					if (!mDrawerLayout.isDrawerOpen(mDrawerList))
						mDrawerLayout.openDrawer(mDrawerList);
					else
						mDrawerLayout.closeDrawer(mDrawerList);
				}

				MySQLiteHelper db = new MySQLiteHelper(context
						.getApplicationContext());
				msgs.clear();
				arr4.clear();
				arr5.clear();
				arr4.addAll(db.getSysNames(name, type));
				arr5.addAll(db.getSysNamesCounts(name, type));
				msgs.addAll(db.getall(name, type, filter));
				// TextView v=(TextView)
				// context.findViewById(R.id.actionbar_notifcation_textview);
				// v.setText(""+db.getmessagecount(name, type, filter));
				s.notifyDataSetChanged();
				lviewAdapter.notifyDataSetChanged();
				s.notifyDataSetChanged();

			}

		});

		// box
		// appContext = getApplicationContext();

		// ActionBar

		Display display = context.getWindowManager().getDefaultDisplay(); // get
																			// the
		// display
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics); // get the display metrics
		// ListViewAdapter.dpi = (int) metrics.heightPixels; // pass the screen

		// height to the
		// list adapter

		context.setTitle("AASTMT Portal");

		doubleBackToExitPressedOnce = false; // initialize the boolean to detect
												// the double back button

		// get all the list data

		// sort the data

		// get the list view
		list = (ListView) context.findViewById(R.id.listView2);
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.listitem, Countries);
		list.requestFocus();
		db = new MySQLiteHelper(context.getApplicationContext());
		msgs = db.getall(name, type, filter);
		lviewAdapter = new NotificationAdapter(context, msgs); // initialize the
																// list adater
		// TextView v=(TextView)
		// context.findViewById(R.id.actionbar_notifcation_textview);
		// v.setText(""+db.getmessagecount(name, type, filter));
		// swipe code to remove the selected item

		list.setAdapter(lviewAdapter);

		registerForContextMenu(list);

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {

				final Message msg = msgs.get(position);

				// String x = arr.get(info.position);
				Caller c = new Caller();
				c.a = msg.getSerial();
				c.b = name;
				c.d = type;
				c.c = "read";
				c.con = context.getApplicationContext();
				try {
					c.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				c.start();

				MySQLiteHelper db = new MySQLiteHelper(context
						.getApplicationContext());
				msgs.clear();
				db.markAsRead(msg.id);
				msgs.addAll(db.getall(name, type, filter));
				lviewAdapter.notifyDataSetChanged();
				// TextView v=(TextView)
				// context.findViewById(R.id.actionbar_notifcation_textview);
				// v.setText(""+db.getmessagecount(name, type, filter));
				// ContentValues cv = new ContentValues();
				// cv.put("badgecount", db.getmessagecount(name, type, ""));
				// getContentResolver().update(Uri.parse("content://com.sec.badge/apps"),
				// cv, "package=?", new String[] {getPackageName()});

				int[] r = { 196, 0, 248, 86, 255, 134, };

				/** The g. */
				int[] g = { 0, 156, 88, 146, 191, 1 };

				/** The b. */
				int[] b = { 2, 156, 0, 0, 1, 110 };

				/** The searc. */

				/** The r2. */
				int[] r2 = { 196, 0, 248, 86, 255, 134, 29 };

				/** The g2. */
				int[] g2 = { 0, 156, 88, 146, 191, 1, 29 };

				/** The b2. */
				int[] b2 = { 2, 156, 0, 0, 1, 110, 29 };

				/** The nmon. */
				String[] nmon = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
						"JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.list3);

				ViewHolder holder = new ViewHolder();
				holder.txtViewTitle = (TextView) dialog
						.findViewById(R.id.txtViewTitle2);
				// holder.time = (TextView) convertView.findViewById(R.id.time);
				holder.txtViewDescription = (TextView) dialog
						.findViewById(R.id.txtViewDescription2);
				// holder.dumm = (TextView)
				// convertView.findViewById(R.id.textView44);
				// holder.dumm1 = (TextView)
				// convertView.findViewById(R.id.textView45);
				holder.cat = (TextView) dialog.findViewById(R.id.cat2);
				holder.date = (TextView) dialog.findViewById(R.id.date2);
				holder.col = (TextView) dialog.findViewById(R.id.col);
				// holder.year = (TextView) convertView.findViewById(R.id.year);
				// holder.lLayout = (LinearLayout)
				// convertView.findViewById(R.id.linear_layout);

				Button bt1 = (Button) dialog.findViewById(R.id.button1);
				Button bt2 = (Button) dialog.findViewById(R.id.button2);
				Button bt3 = (Button) dialog.findViewById(R.id.button3);
				dialog.setTitle("Notification Details");
				bt1.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {

						Uri uri;

						try {
							String emp = Encrypt(name, "123");
							String url = Encrypt(msg.getLink(), "123");
							if (!msg.getLink().contains("http")) {

								return;
							}
							int currentapiVersion = android.os.Build.VERSION.SDK_INT;

							if (type.equals("0"))
								uri = Uri
										.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
												+ URLEncoder.encode(emp,
														"ISO-8859-1")
												+ "&url="
												+ URLEncoder.encode(url,
														"ISO-8859-1"));
							else
								uri = Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
										+ URLEncoder.encode(emp, "ISO-8859-1")
										+ "&url="
										+ URLEncoder.encode(url, "ISO-8859-1")
										+ "&std=1");
							// String xxx=
							// "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
							// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
							// +URLEncoder.encode(url, "ISO-8859-1");
							startActivity(new Intent(Intent.ACTION_VIEW, uri));

							// uri=
							// Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
							// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
							// +URLEncoder.encode(url, "ISO-8859-1") );

							// String xxx=
							// "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
							// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
							// +URLEncoder.encode(url, "ISO-8859-1");
							// startActivity(new Intent(Intent.ACTION_VIEW,
							// uri));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dialog.dismiss();
					}

				});
				bt2.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						Caller c = new Caller();
						c.a = msg.getSerial();
						c.b = name;
						c.d = type;

						c.c = "remove";
						c.con = context.getApplicationContext();
						// ArrayList<String> tarr;
						// tarr = new ArrayList<String>();
						try {
							c.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						c.start();
						MySQLiteHelper db = new MySQLiteHelper(context
								.getApplicationContext());
						db.deleteMessage(msg.id);
						msgs.clear();

						msgs.addAll(db.getall(name, type, filter));
						lviewAdapter.notifyDataSetChanged();
						TextView v2 = (TextView) context
								.findViewById(R.id.actionbar_notifcation_textview);
						v2.setText("" + db.getmessagecount(name, type, filter));

						lviewAdapter.notifyDataSetChanged();
						dialog.dismiss();
					}

				});
				bt3.setOnClickListener(new Button.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				if (msg.getRead().equals("1")) {

					// holder.dumm.setBackgroundColor(Color.rgb(245, 245, 245));
					// holder.dumm1.setBackgroundColor(Color.rgb(245, 245,
					// 245));
					// holder.dumm2.setBackgroundColor(Color.rgb(245, 245,
					// 245));
					holder.txtViewDescription.setTextColor(Color.rgb(149, 149,
							149));
					holder.txtViewTitle.setTextColor(Color.rgb(149, 149, 149));

				} else {

					// holder.dumm.setBackgroundColor(Color.rgb(213, 213, 213));
					// holder.dumm1.setBackgroundColor(Color.rgb(213, 213,
					// 213));
					// holder.dumm2.setBackgroundColor(Color.rgb(213, 213,
					// 213));
					holder.txtViewTitle.setTextColor(Color.BLACK);
					holder.txtViewDescription.setTextColor(Color.BLACK);
				}
				String mk;

				// TODO Auto-generated method stub
				try {
					mk = msg.getSys_name();
				} catch (Exception e) {
					mk = "2";
				}
				int mod = 0;
				for (int i = 0; i < mk.length(); i++)
					mod += mk.charAt(i);
				mod %= 6;
				// holder.time.setText(title.get(position).substring(11, 16));
				// holder.time.setTextColor(Color.WHITE);
				// holder.cat.setTextColor(Color.WHITE);
				holder.cat.setText(msg.getSys_name());
				holder.cat.setTypeface(null, Typeface.BOLD);
				holder.date.setTypeface(null, Typeface.BOLD);
				// count++;
				// holder.date.setBackgroundColor(Color.rgb(r[mod], g[mod],
				// b[mod]));
				holder.col.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));
				holder.cat.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));

				// holder.time.setBackgroundColor(Color.rgb((r[mod]<40 ) ?
				// 0:r[mod]-40, (g[mod]<40 ) ? 0:g[mod]-40,(b[mod]<40 ) ?
				// 0:b[mod]-40));
				// String til=msg;

				holder.date.setText("20" + msg.getDateTime().substring(0, 8)
						+ "   " + msg.getDateTime().substring(11, 16));
				holder.date.setTextColor(Color.WHITE);
				holder.date.setTextSize(15);
				// holder.year.setTextColor(Color.WHITE);
				// holder.year.setText("2\n0\n"+ til.charAt(0) +"\n"+
				// til.charAt(1));
				// holder.year.setTypeface(null, Typeface.BOLD);
				holder.date.setTextSize(15);
				holder.txtViewDescription.setTextSize(18);
				holder.cat.setTextSize(14);
				holder.txtViewTitle.setTextSize(30);
				holder.cat.setTextColor(Color.WHITE);

				holder.date.setTextColor(Color.rgb(r[mod], g[mod], b[mod]));
				// String tempstr= title.get(position).substring(n1+1,n2);

				// tempstr=tempstr.substring(0,i+3);
				holder.txtViewTitle.setText(msg.getMessage_title());
				holder.txtViewDescription.setText(msg.getMessage_desc());

				dialog.show();
				// Uri uri;
				//
				//
				// try {
				// String emp = Encrypt(name, "123");
				// String url= Encrypt(msg.getLink(), "123");
				// if(!msg.getLink().contains("http"))
				// {
				//
				// return;
				// }
				// int currentapiVersion = android.os.Build.VERSION.SDK_INT;
				//
				// if (currentapiVersion <=
				// android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH){
				// Intent i = new Intent(getApplicationContext(),
				// TesttActivity.class);
				//
				// i.putExtra("url",
				// "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
				// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
				// +URLEncoder.encode(url, "ISO-8859-1")+"&std=1");
				// startActivity(i);
				//
				// } else{
				// if(type.equals("0"))
				// uri =
				// Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
				// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
				// +URLEncoder.encode(url, "ISO-8859-1") );
				// else
				// uri =
				// Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
				// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
				// +URLEncoder.encode(url, "ISO-8859-1")+ "&std=1" );
				// //String xxx=
				// "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
				// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
				// +URLEncoder.encode(url, "ISO-8859-1");
				// startActivity(new Intent(Intent.ACTION_VIEW, uri));
				// }
				// // uri =
				// Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
				// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
				// +URLEncoder.encode(url, "ISO-8859-1") );
				//
				// // String xxx=
				// "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid="
				// +URLEncoder.encode(emp, "ISO-8859-1") +"&url="
				// +URLEncoder.encode(url, "ISO-8859-1");
				// // startActivity(new Intent(Intent.ACTION_VIEW, uri));
				// } catch (UnsupportedEncodingException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (Exception e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

				// Intent i = new Intent(getApplicationContext(),
				// List_detail.class);
				// i.putExtra("item",arr[position]);
				// startActivity(i);
				// Toast.makeText(ListActivity.this,"Title => "+month[position]+"=> n Description"+number[position],
				// Toast.LENGTH_SHORT).show();

			}
		});

		registerForContextMenu(list);
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_list, container,
				false);

		setHasOptionsMenu(true);
		return rootView;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			// ProjectsActivity is my 'home' activity
			// if
			// (getResources().getString(R.string.app_config).equals("small")) {
			// if (!mDrawerLayout.isDrawerOpen(mDrawerList))
			// mDrawerLayout.openDrawer(mDrawerList);
			// else
			// mDrawerLayout.closeDrawer(mDrawerList);
			// }
			return true;
		} else if (itemId == R.id.item1) {
			MySQLiteHelper db = new MySQLiteHelper(getActivity()
					.getApplicationContext());
			msgs.clear();
			arr4.clear();
			arr5.clear();
			arr4.addAll(db.getSysNames(name, type));
			arr5.addAll(db.getSysNamesCounts(name, type));
			msgs.addAll(db.getall(name, type, filter));
			s.notifyDataSetChanged();
			lviewAdapter.notifyDataSetChanged();
			// TextView v=(TextView)
			// context.findViewById(R.id.actionbar_notifcation_textview);
			// v.setText(""+db.getmessagecount(name, type, filter));
			// ContentValues cv = new ContentValues();
			// cv.put("badgecount", db.getmessagecount(name, type, ""));
			// getContentResolver().update(Uri.parse("content://com.sec.badge/apps"),
			// cv, "package=?", new String[] {getPackageName()});
			return true;
		} else if (itemId == R.id.item2) {
			SharedPreferences preferences2 = getActivity()
					.getSharedPreferences("AAST", 0);
			String acc = preferences2.getString("naccount", "");
			acc = acc.replace(type + name + "^", "");

			Editor edit = preferences2.edit();
			if (acc.equals("^")) {
				edit.putString("login", "no");
				edit.commit();
				// finish();

			}
			if (!acc.equals("^"))
				edit.putString("username",
						acc.substring(2, acc.indexOf("^", 1)));
			edit.putString("type", acc.substring(1, 2));
			edit.putString("login", "no");
			edit.putString("naccount", acc);
			edit.commit();

			Intent i = new Intent(getActivity().getApplicationContext(),
					Accounts.class);
			// finish();
			startActivity(i);

			// edit.putString("login", "no");

			return true;
		} else if (itemId == R.id.item4) {
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle("About")
					.setMessage("Build number is" + Login.version)
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		} else if (itemId == R.id.item6) {
			Intent i = new Intent(getActivity(), Accounts.class);
			i.putExtra("id", "ok");
			// finish();
			startActivity(i);
			return true;
		}
		return true;
	}

	String Encrypt(String text, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length)
			len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));

		return Base64.encodeToString(results, Base64.DEFAULT);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		String arr[] = { "Mark as read", "Mark as unread", "remove", "Open" };
		if (v.getId() == R.id.listView2) {
			// AdapterView.AdapterContextMenuInfo info =
			// (AdapterView.AdapterContextMenuInfo) menuInfo;
			menu.setHeaderTitle("please choose");
			String[] menuItems = arr.clone();
			for (int i = 0; i < menuItems.length; i++) {
				menu.add(Menu.NONE, i, i, menuItems[i]);
			}
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		Activity ac = getActivity();
		int menuItemIndex = item.getItemId();
		if (menuItemIndex == 2) { // remove item
			Message msg = msgs.get(info.position);
			Caller c = new Caller();
			c.a = msg.getSerial();
			c.b = name;
			c.d = type;
			// WEBService1Soap w = new WEBService1Soap();

			c.c = "remove";
			c.con = ac;
			// ArrayList<String> tarr;
			// tarr = new ArrayList<String>();
			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.start();
			MySQLiteHelper db = new MySQLiteHelper(ac);
			db.deleteMessage(msg.id);
			msgs.clear();

			msgs.addAll(db.getall(name, type, filter));
			lviewAdapter.notifyDataSetChanged();
			// TextView v=(TextView)
			// context.findViewById(R.id.actionbar_notifcation_textview);
			// v.setText(""+db.getmessagecount(name, type, filter));

			lviewAdapter.notifyDataSetChanged();

		} else if (menuItemIndex == 0) {// mark as read

			Message msg = msgs.get(info.position);
			Caller c = new Caller();
			c.a = msg.getSerial();
			c.b = msg.getUser_name();
			c.d = msg.getUser_type();
			;
			c.c = "read";
			c.con = ac;
			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.start();
			MySQLiteHelper db = new MySQLiteHelper(ac.getApplicationContext());
			msgs.clear();
			db.markAsRead(msg.id);
			msgs.addAll(db.getall(name, type, filter));
			lviewAdapter.notifyDataSetChanged();
			// TextView v=(TextView)
			// context.findViewById(R.id.actionbar_notifcation_textview);
			// v.setText(""+db.getmessagecount(name, type, filter));
			// ContentValues cv = new ContentValues();
			// cv.put("badgecount", db.getmessagecount(name, type,"" ));
			// getContentResolver().update(Uri.parse("content://com.sec.badge/apps"),
			// cv, "package=?", new String[] {getPackageName()});
		} else if (menuItemIndex == 1) { // mark as unread
			Message msg = msgs.get(info.position);
			Caller c = new Caller();
			c.a = msg.getSerial();
			c.b = msg.getUser_name();
			c.d = msg.getUser_type();
			;

			c.c = "unread";
			c.con = ac;
			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.start();
			MySQLiteHelper db = new MySQLiteHelper(ac.getApplicationContext());
			msgs.clear();
			db.markAsUnRead(msg.id);
			msgs.addAll(db.getall(name, type, filter));
			lviewAdapter.notifyDataSetChanged();
			// ContentValues cv = new ContentValues();
			// cv.put("badgecount", db.getmessagecount(name, type, ""));
			// getContentResolver().update(Uri.parse("content://com.sec.badge/apps"),
			// cv, "package=?", new String[] {getPackageName()});
		} else if (menuItemIndex == 3) { // open

			Message msg = msgs.get(info.position);

			// String x = arr.get(info.position);
			Caller c = new Caller();
			c.a = msg.getSerial();
			c.b = name;
			c.d = type;
			c.c = "read";
			c.con = ac.getApplicationContext();
			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.start();

			MySQLiteHelper db = new MySQLiteHelper(ac.getApplicationContext());
			msgs.clear();
			db.markAsRead(msg.id);
			msgs.addAll(db.getall(name, type, filter));
			lviewAdapter.notifyDataSetChanged();

			try {
				Uri uri = Uri.parse(msg.getLink());
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
			} catch (Exception e) {
			}

		}
		// String arr[] = { "11", "22" };
		// String[] menuItems = arr.clone();

		return true;
	}

}

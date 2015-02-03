package idc.aast.test2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.bugsense.trace.BugSenseHandler;

import idc.aast.edu.activities.Accounts;
import idc.aast.edu.activities.Login;
import idc.aast.edu.activities.NewsDetails;
import idc.aast.edu.activities.Results;
import idc.aast.edu.activities.TabMain;
import idc.aast.edu.adapters.LinksAdapter;
import idc.aast.edu.adapters.NewsAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.news_item;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.edu.database.helper;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainLinksFragment extends Fragment {
	private boolean doubleBackToExitPressedOnce = false;

	/** The tabs. */
	private String[] tabs = { "Links", "Notifications" };

	/** The bb. */
	static Boolean bb = false;

	/** The rslt. */
	static String rslt;
	static String rslt2;
	/** The arr2. */
	static ArrayList<String> arr2; // used to have the name of the links

	/** The arr3. */
	static ArrayList<String> arr3; // used to have the counts of the links

	public static String count;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */

	/**
	 * 
	 */
	static String name;
	static String type;

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
	public void onStart() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		SharedPreferences preferences1 = getActivity().getSharedPreferences(
				"AAST", 0);
		name = preferences1.getString("username", "noone");
		type = preferences1.getString("type", "0");
		BugSenseHandler.initAndStartSession(getActivity(), "1fd17091");
		BugSenseHandler.addCrashExtraData("Name", name);
		bb = false;

		ListView myList = (ListView) getView().findViewById(R.id.listView3);
		if (arr2 == null)
			arr2 = new ArrayList<String>();
		if (arr3 == null)
			arr3 = new ArrayList<String>();
		arr2.clear();
		arr3.clear();
		int prev = 0;
		int nw = 0;
		if (type.equals("1")) {
			arr2.addAll(Arrays.asList(new String[] { "Notifications",
					"Schedule", "News", "Results", "Links", "Accounts" }));
			arr3.addAll(Arrays.asList(new String[] { "nots", "sch", "news",
					"results", "links", "acc" }));
		} else if (type.equals("0")) {
			arr2.addAll(Arrays.asList(new String[] { "Notifications",
					 "Links", "Accounts" }));
			arr3.addAll(Arrays.asList(new String[] { "nots", "links", "acc" }));
		}
		LinksAdapter adap = new LinksAdapter(getActivity(), arr2, arr2);

		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String url = "https://payslip.aast.edu/online_payroll/Emp_Salary.aspx";
				url = arr3.get(arg2);
				if (url.equals("results")) {

					TabMain.nw = 3;
				} else if (url.equals("nots")) {
					TabMain.nw = 0;
				} else if (url.equals("sch")) {
					TabMain.nw = 1;
				} else if (url.equals("news")) {
					TabMain.nw = 2;
				} else if (url.equals("links")) {
					TabMain.nw = 4;

				} else if (url.equals("acc")) {
					Intent i = new Intent(getActivity(), Accounts.class);
					startActivity(i);
					return;

				}
				Intent i = new Intent(getActivity(), TabMain.class);
				startActivity(i);
				return;

			}
		});

		// TableLayout c = (TableLayout)findViewById(R.id.lay);

		super.onStart();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_list_detail,
				container, false);
		setHasOptionsMenu(true);
		return rootView;
	}

}

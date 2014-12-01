package idc.aast.Other;

import java.util.ArrayList;


import idc.aast.edu.classes.result_item;
import idc.aast.edu.classes.community.Group;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CommunityDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 2;

	private static final String DATABASE_NAME = "Community";

	// /--------------------------------------------------------------
	private static final String[] usergroup_columns = { "id", "group_name",
			"group_id", "group_type", "user_id", "role_id", };

	public CommunityDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String create_community_groups_table = "CREATE TABLE usergroup ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "group_name TEXT ,"
				+ "group_id TEXT, " + "group_type TEXT,  " + "user_id TEXT, "
				+ "role_id TEXT )";
		db.execSQL(create_community_groups_table);
	}

	public int insert_group(Group g) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(
				"usergroup", // a. table
				new String[] { "count(user_id)" }, // b. column names
				"user_id = ? and group_id = ? ", // selections
				new String[] { String.valueOf(g.user_id),
						String.valueOf(g.group_id), }, // d. selections args
				null, // e. group by
				null, // f. having
				null, // g. order by
				null); // h. limit
		int count = 0;
		if (cursor.moveToFirst()) {
			// db.close();
			count = cursor.getInt(0);

		}
		if (count == 0) {

			ContentValues values = new ContentValues();
			values.put("user_id", g.user_id); // get title
			values.put("group_name", g.group_name);
			values.put("group_id", g.group_id); // get title
			values.put("role_id", g.role_id);
			values.put("group_type", g.group_type); // get title

			int j = (int) db.insert("usergroup", // table
					null, // nullColumnHack
					values);
			db.close();
			return j;
		}

		return 0;

	}

	public ArrayList<Group> get_user_groups(String user_id) {
		ArrayList<Group> list_groups = new ArrayList<Group>();
		Cursor cursor;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db
				.query("usergroup", // a. table
						usergroup_columns, // b. column names
						" user_id = ? ", // c. selections
						new String[] { 
								String.valueOf(user_id) }, // d. selections args
						null, // e. group by
						null, // f. having
						null, // g. order by
						null); // h. limit

		Group g = null;
		if (cursor.moveToFirst()) {
			do {
				g = new Group(cursor.getString(1), cursor.getString(2),
						cursor.getString(3), cursor.getString(4),
						cursor.getString(5));
				;
				

				// Add book to books
				list_groups.add(g);
			} while (cursor.moveToNext());
		}
		db.close();
		return list_groups;

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		if(oldVersion == 1)
		{
			db.execSQL("drop table usergroup");
		String create_community_groups_table = "CREATE TABLE usergroup ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "group_name TEXT ,"
				+ "group_id TEXT, " + "group_type TEXT,  " + "user_id TEXT, "
				+ "role_id TEXT )";
		db.execSQL(create_community_groups_table);
		}

	}

}

package idc.aast.edu.database;

import java.util.ArrayList;

import idc.aast.edu.classes.Post;
import idc.aast.edu.classes.result_item;
import idc.aast.edu.classes.community.Group;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CommunityDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 4;

	private static final String DATABASE_NAME = "Community";

	// /--------------------------------------------------------------
	private static final String[] usergroup_columns = { "id", "group_name",
			"group_id", "group_type", "user_id", "role_id", };
	private static final String[] posts_column = { "id", "post_id", "user_id",
			"user_name", "group_id", "post_text", "comment_count",
			"comment_enabled", "post_date", };

	public CommunityDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String create_community_groups_table = "CREATE TABLE usergroup ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "group_name TEXT ," + "group_id TEXT, "
				+ "group_type TEXT,  " + "user_id TEXT, " + "role_id TEXT )";
		db.execSQL(create_community_groups_table);
		String create_posts_table = "CREATE TABLE posts ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "post_id TEXT ,"
				+ "user_id TEXT, " + "user_name TEXT,  " + "post_date TEXT,  "
				+ "group_id TEXT,  " + "post_text TEXT, "
				+ "comment_count TEXT, " + "comment_enabled TEXT )";
		db.execSQL(create_posts_table);
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

	public int insert_post(Post p, String user_id) {
		SQLiteDatabase db = this.getReadableDatabase();

		ContentValues values = new ContentValues();
		values.put("post_id", p.post_id); // get title
		values.put("user_id", user_id);
		values.put("user_name", p.user_name); // get title
		values.put("group_id", p.group_id);
		values.put("post_text", p.post_text);
		values.put("comment_count", p.comment_count); // get title
		values.put("comment_enabled", p.comment_enabled); // get title
		values.put("post_date", p.post_date); // get title

		int j = (int) db.insert("posts", // table
				null, // nullColumnHack
				values);
		db.close();
		return j;

	}

	public ArrayList<Post> get_user_posts(String user_id, String group_id) {
		ArrayList<Post> list_posts = new ArrayList<Post>();
		Cursor cursor;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.query(
				"posts", // a. table
				posts_column, // b. column names
				" user_id = ? and group_id = ? ", // c. selections
				new String[] { String.valueOf(user_id),
						String.valueOf(group_id) }, // d. selections args
				null, // e. group by
				null, // f. having
				null, // g. order by
				null); // h. limit

		Post p = null;
		if (cursor.moveToFirst()) {
			do {
				p = new Post(cursor.getString(1), cursor.getString(2),
						cursor.getString(3), cursor.getString(4),
						cursor.getString(5), cursor.getString(5),
						cursor.getString(6),cursor.getString(7));
				;

				// Add book to books
				list_posts.add(p);
			} while (cursor.moveToNext());
		}
		db.close();
		return list_posts;

	}

	public ArrayList<Group> get_user_groups(String user_id) {
		ArrayList<Group> list_groups = new ArrayList<Group>();
		Cursor cursor;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.query("usergroup", // a. table
				usergroup_columns, // b. column names
				" user_id = ? ", // c. selections
				new String[] { String.valueOf(user_id) }, // d. selections args
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
		if (oldVersion == 3) {

			db.execSQL("ALTER TABLE posts ADD COLUMN post_date TEXT");
		}
		// TODO Auto-generated method stub
		if (oldVersion == 1) {
			db.execSQL("drop table usergroup");
			String create_community_groups_table = "CREATE TABLE usergroup ( "
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "group_name TEXT ," + "group_id TEXT, "
					+ "group_type TEXT,  " + "user_id TEXT, "
					+ "role_id TEXT )";
			db.execSQL(create_community_groups_table);
			String create_posts_table = "CREATE TABLE posts ( "
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "post_id TEXT ," + "user_id TEXT, " + "user_name TEXT,  "
					+ "group_id TEXT,  " + "post_text TEXT, "
					+ "comment_count TEXT, " + "comment_enabled TEXT )";
			db.execSQL(create_posts_table);
		}
		if (oldVersion == 2) {

			String create_posts_table = "CREATE TABLE posts ( "
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "post_id TEXT ," + "user_id TEXT, " + "user_name TEXT,  "
					+ "group_id TEXT,  " + "post_text TEXT, "
					+ "comment_count TEXT, " + "comment_enabled TEXT )";
			db.execSQL(create_posts_table);
		}

	}

}

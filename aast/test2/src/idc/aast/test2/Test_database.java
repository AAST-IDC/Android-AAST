package idc.aast.test2;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Test_database extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_database);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_database, menu);
		MySQLiteHelper db = new MySQLiteHelper(this);
	//	Message msg = db.getMessage("seri");
		db.addMessage(new Message("mes","title","desc","read","datatime","link","sys","sysname","username","type","seri"));
		db.getall("username", "type","1");
		return true;
	}

}

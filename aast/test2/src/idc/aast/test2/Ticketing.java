package idc.aast.test2;

import idc.aast.edu.activities.Community;
import idc.aast.edu.activities.Login;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ticketing extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ticketing);
		Button b = (Button) findViewById(R.id.test_but);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Community.class);
				
				startActivity(i);
				finish();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
	
		getMenuInflater().inflate(R.menu.ticketing, menu);
	
		return true;
	}

}

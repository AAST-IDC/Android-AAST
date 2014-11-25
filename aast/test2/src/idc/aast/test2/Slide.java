/*
 * 
 */
package idc.aast.test2;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

// TODO: Auto-generated Javadoc
/**
 * The Class Slide.
 */
public class Slide extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide);
		 MyPagerAdapter adapter1 = new MyPagerAdapter();
		    ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
		    myPager.setAdapter(adapter1);
		    myPager.setCurrentItem(0);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.slide, menu);
		return true;
	}

}

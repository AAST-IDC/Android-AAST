/*
 * 
 */
package idc.aast.test2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
// TODO: Auto-generated Javadoc


/**
 * The Class SettingsActivity.
 */
@TargetApi(10)
/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends Activity implements OnCheckedChangeListener {
	/**
	 * Determines whether to always show the simplified settings UI, where
	 * settings are presented in a single list. When false, settings are shown
	 * as a master/detail two-pane view on tablets. When true, a single pane is
	 * shown on tablets.
	 */
	static String x="11^22^33";
	
	/** The y. */
	static String y;
	  
	/** The lis. */
	static List<String> lis = new ArrayList<String>();  
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		SharedPreferences pref = getSharedPreferences("AAST",0);
		String name = pref.getString("username", "noone");
		Editor edit=pref.edit();
		setContentView(R.layout.settings);
	//	x="11^22^33^44";
		int prev=0;
		int nw=0;
		int prevy=0;
		int nwy=0; 
		int i=0;
		LinearLayout lm = (LinearLayout) findViewById(R.id.lay223);
		while (x.indexOf('^',prev)!=-1) {
			nw=x.indexOf('^',prev);
			nwy=y.indexOf('^',prevy);
			LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            lis.add(x.substring(prev, nw));
            TextView product = new TextView(this);
            product.setText(y.substring(prevy, nwy));
            product.setId(i);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            product.setLayoutParams(params);
            ll.addView(product);
          
            CheckBox box = new CheckBox(this);
           box.setId(i);
            box.setOnCheckedChangeListener(this);
            if(pref.contains(name+"__"+x.substring(prev,nw)))
            {
            	
            	box.setChecked(pref.getBoolean(name+"__"+x.substring(prev,nw ), false));
            }
            else
            {
            	box.setChecked(false);
            	edit.putBoolean(name+"__"+x.substring(prev,nw), false);
            	edit.commit();
            }
            ll.addView(box);
           
            lm.addView(ll);
            prev=nw+1;
            prevy=nwy+1;
			i++;
		}
	}	
	
	/* (non-Javadoc)
	 * @see android.widget.CompoundButton.OnCheckedChangeListener#onCheckedChanged(android.widget.CompoundButton, boolean)
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		SharedPreferences pref= getSharedPreferences("AAST", 0);
		Editor edit = pref.edit();
		String name =pref.getString("username", "noone");
	
		edit.putBoolean(name +"__"+lis.get(buttonView.getId()), isChecked);
		edit.commit();
	}
}

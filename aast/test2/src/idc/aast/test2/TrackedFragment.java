package idc.aast.test2;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

public class TrackedFragment extends Fragment {
	  private Tracker tracker;
	    private String activityId;
	    private String fragmentId;

	    @Override
	    public void onCreate(final Bundle  savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.tracker = EasyTracker.getInstance(getActivity().getApplicationContext());
	        
	        this.fragmentId = getClass().getSimpleName();
	        this.activityId = getActivity().getClass().getSimpleName();
	    }

	    @Override
	    public void onResume() {
	        super.onResume();

	        this.tracker.set(Fields.SCREEN_NAME, this.fragmentId);
	        this.tracker.send( MapBuilder.createAppView().build() );
	    }
}

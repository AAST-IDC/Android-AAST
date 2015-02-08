package idc.aast.edu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import idc.aast.test2.R;
public class SchRootFragment  extends Fragment {

	public SchRootFragment() {
		// TODO Auto-generated constructor stub
	}
	private static final String TAG = "RootFragment";

	@Override
	public void onStart() {
		Log.d("sch", "start");
		super.onStart();
	}
	@Override
	public void onPause() {
		Log.d("sch", "pause");
		super.onPause();
	}
	@Override
	public void onDestroy() {
		Log.d("sch", "destrou");
		super.onDestroy();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/* Inflate the layout for this fragment */
		Log.d("sch", "create");
		View view = inflater.inflate(R.layout.sch_root_fragment, container, false);

		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
		transaction.replace(R.id.sch_root_frame, new SchedueleFragment());

		transaction.commit();
		//super.onCreate(savedInstanceState);
		return view;
	}
}

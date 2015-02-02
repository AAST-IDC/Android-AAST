package idc.aast.edu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/* Inflate the layout for this fragment */
		View view = inflater.inflate(R.layout.sch_root_fragment, container, false);

		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		/*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
		transaction.replace(R.id.sch_root_frame, new SchedueleFragment());

		transaction.commit();

		return view;
	}
}

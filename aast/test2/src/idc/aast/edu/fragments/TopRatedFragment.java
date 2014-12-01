package idc.aast.edu.fragments;

import idc.aast.test2.R;
import idc.aast.test2.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class TopRatedFragment extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.activity_top_rated_fragment, container, false);
         
        return rootView;
    }
}
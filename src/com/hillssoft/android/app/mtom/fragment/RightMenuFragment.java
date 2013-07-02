package com.hillssoft.android.app.mtom.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hillssoft.android.app.mtom.R;

public class RightMenuFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.mtom_fragment_right_menu_fragment, container, false);
	
	}
}

package net.mindsoup.charactersoup.fragments;

import net.mindsoup.charactersoup.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EquipmentFragment extends CharacterFragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_equipment, container, false);

    }

	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

}

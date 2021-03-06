package net.mindsoup.charactersoup.fragments;

import net.mindsoup.charactersoup.CharacterActivity;
import net.mindsoup.charactersoup.R;
import net.mindsoup.charactersoup.adapters.ItemAdapter;
import net.mindsoup.charactersoup.pf.items.Item;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class InventoryFragment extends CharacterFragment {
	
	private ItemAdapter adapter;
	private CharacterActivity ca;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }
	
	@Override
	public void onResume() {
		super.onResume();
		
		if(isAdded()) {
			ca = (CharacterActivity)this.getActivity();			
			
			ListView list = (ListView)this.getActivity().findViewById(R.id.inventory_list);
			adapter = new ItemAdapter(this.getActivity(), R.layout.items_list_item, ca.getCharacter().getInventoryItems(), this.getSherlockActivity());
			list.setAdapter(adapter);
			
			list.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
					Item i = ca.getCharacter().getInventoryItems().get(position);
					
					new AlertDialog.Builder(ca)
			        .setIcon(android.R.drawable.ic_dialog_alert)
			        .setTitle("Delete item")
			        .setMessage("Delete " + i.getName() + " from inventory?")
			        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			        	@Override
			        	public void onClick(DialogInterface dialog, int which) {
			        		deleteItem(position);
			        	}

			        })
			        .setNegativeButton("No", null)
			        .show();
					
					
					return true;
				}
			});
			
			Button button = (Button)this.getActivity().findViewById(R.id.add_item_button);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					addItem();
					
				}
			});
			
			refresh();
		}
	}
	
	private void deleteItem(int position) {
		Item i = ca.getCharacter().getInventoryItems().get(position);
		ca.removeItem(i, 1);
	}
	
	private void addItem() {
		 FragmentManager fm = this.getActivity().getSupportFragmentManager();
	     CreateItemFragment createChar = new CreateItemFragment();
	     createChar.show(fm, "fragment_create_item");
	}

	@Override
	public void refresh() {
		if(isAdded()) {
			adapter.notifyDataSetChanged();
			
			TextView tv = (TextView)this.getActivity().findViewById(R.id.character_wealth);
			tv.setText("Gold: " + Float.toString((float)ca.getCharacter().getMoney() / 100.0f));
			
			tv = (TextView)this.getActivity().findViewById(R.id.total_weight);
			tv.setText(Float.toString(ca.getCharacter().getTotalCarryingWeight()) + " Lbs");
		}
	}

}

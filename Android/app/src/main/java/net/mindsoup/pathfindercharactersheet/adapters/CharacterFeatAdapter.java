/**
 * 
 */
package net.mindsoup.pathfindercharactersheet.adapters;

import java.util.List;

import net.mindsoup.pathfindercharactersheet.R;
import net.mindsoup.pathfindercharactersheet.pf.feats.FeatFactory;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeat;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeats;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Valentijn
 *
 */
public class CharacterFeatAdapter extends ArrayAdapter<PfFeats> {
	
	private List<PfFeats> feats;
	private int viewResourceId;
	
	public CharacterFeatAdapter(Context context, int textViewResourceId, List<PfFeats> objects) {
		super(context, textViewResourceId, objects);
		
		this.feats = objects;
		this.viewResourceId = textViewResourceId;
	
	}
	
	@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(viewResourceId, null);
        
        PfFeat feat = FeatFactory.getFeat(this.getContext(), feats.get(position));
        
        TextView tv = (TextView)view.findViewById(R.id.feat_name);
        tv.setText(feat.getName());
        tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ViewGroup description = (ViewGroup)view.findViewById(R.id.feat_description_group);
				
				if(description.getVisibility() == View.GONE)
					description.setVisibility(View.VISIBLE);
				else
					description.setVisibility(View.GONE);
			}
		});
        
        tv = (TextView)view.findViewById(R.id.feat_description);
        tv.setText(feat.getDescription());
        
        return view;
	}

}

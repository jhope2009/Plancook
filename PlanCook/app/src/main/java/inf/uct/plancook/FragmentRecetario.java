package inf.uct.plancook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentRecetario extends Fragment {
	
	View view;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    	LinearLayout linear = new LinearLayout(getActivity());
    	linear.setOrientation(LinearLayout.VERTICAL);
    	linear.setBackground(getResources(). getDrawable(R.drawable.walpaper_general));
    	TextView text = new TextView(getActivity());
    	text.setText("Recetario");
    	linear.addView(text);
    	view = linear;
    	view = linear;
        return view;
    }
}

package inf.uct.plancook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentCalendario extends Fragment {

View view;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    	LinearLayout linear = new LinearLayout(getActivity());
    	linear.setOrientation(LinearLayout.VERTICAL);
    	linear.setBackgroundDrawable(getResources(). getDrawable(R.drawable.walpaper_general));
    	TextView text = new TextView(getActivity());
    	text.setText("Calendario");
    	linear.addView(text);
    	view = linear;
    	view = linear;
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
}

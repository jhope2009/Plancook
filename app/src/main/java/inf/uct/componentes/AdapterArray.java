package inf.uct.componentes;

/**
 * Created by jairo on 25-10-2014.
 */
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterArray extends ArrayAdapter<ItemList>{

    private Context context;

    public AdapterArray(Context context) {
        super(context,android.R.layout.simple_list_item_1);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemList item = this.getItem(position);
        LinearLayout layout=new LinearLayout(context);

        ImageView icono=new ImageView(context);
        TextView textView=new TextView(context);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(10,0,0,0);
        ///textView.setTextColor(Color.WHITE);

        icono.setImageDrawable(this.context.getResources().getDrawable(item.icon));
        textView.setText(item.name);

		/*tamaño del icono dependiendo de la densidad de la pantalla*/
        int size=(int)TypedValue.applyDimension (TypedValue.COMPLEX_UNIT_DIP ,50,context.getResources().getDisplayMetrics ());

        layout.addView(icono,size,size);
        layout.addView(textView,-1,size);

        return layout;
    }


}

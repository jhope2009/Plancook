package inf.uct.plancook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import inf.uct.componentes.ImageView;
import inf.uct.componentes.LinearLayout;
import inf.uct.componentes.TextView;

/**
 * Created by jairo on 15-10-2014.
 */
public class ActivityDespensa extends Activity implements OnClickListener{

    private LinearLayout Layout_principal;
    private LinearLayout Layout_cabecera;
    private LinearLayout Layout_lista;
    private LinearLayout Layout_separador;
    private ListView listview;

    private String[] menus = {"Canelones de Merlusa","Carne al Horno", "Fideos", "Porotos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //super.setTheme(android.R.style.Holo_Light_ButtonBar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DisplayMetrics met = getResources().getDisplayMetrics();
        Layout_separador = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.TOP, Color.TRANSPARENT);
        Layout_principal = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.TOP, Color.RED);
        Layout_cabecera = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.TOP, Color.TRANSPARENT);
        Layout_lista = new LinearLayout(this,LinearLayout.VERTICAL,Gravity.BOTTOM,Color.TRANSPARENT);

/*
___________________________________________________________________________________________________
        PROPIEDADES DEL LAYOUT PRINCIPAL.
___________________________________________________________________________________________________
*/
        Layout_principal.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));
        Layout_principal.setBackgroundDrawable(getResources().getDrawable(R.drawable.walpaper_general));
/*
___________________________________________________________________________________________________
LISTA QUE CONTIENE LOS MENUS
___________________________________________________________________________________________________
*/
        listview = new ListView(this);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < menus.length; ++i) {
            list.add(menus[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        listview.setScrollingCacheEnabled(true);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(ActivityDespensa.this, ActivityVisorRecetas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(ActivityDespensa.this, ActivityVisorRecetas.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(ActivityDespensa.this, ActivityVisorRecetas.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(ActivityDespensa.this, ActivityVisorRecetas.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
/*
___________________________________________________________________________________________________
LAYOUT PRINCIPAL QUE CONTIENE EL SCROL, EL CUAL A SU VEZ CONTIENE EL LAYOUT SEPARADOR
___________________________________________________________________________________________________
*/
        ImageView im_perfil = new ImageView(this,R.drawable.assets_30px_de_0_0028_home_despensa);
        Layout_cabecera.addView(im_perfil);
        TextView nom_user = new TextView(this,Layout_cabecera,"Los ingredientes que",Gravity.CENTER);
        TextView nom_user1 = new TextView(this,Layout_cabecera,"tienes para cocinar...",Gravity.CENTER);
        nom_user.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, met));
/*
___________________________________________________________________________________________________
LAYOUT PRINCIPAL QUE CONTIENE EL SCROL, EL CUAL A SU VEZ CONTIENE EL LAYOUT SEPARADOR
___________________________________________________________________________________________________
*/
        Layout_lista.setPadding(0,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 50, met),0,0);
        Layout_lista.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT ));
        Layout_separador.setPadding(0,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 100, met),0,0);
        Layout_separador.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        Layout_lista.addView(listview);
        Layout_separador.addView(Layout_cabecera);
        Layout_principal.addView(Layout_separador);
        Layout_principal.addView(Layout_lista);

        setContentView(Layout_principal);
    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, FragmentHome.class);
        intent.putExtra("result", "mensaje de vuelta");
        this.setResult(1, intent);
        super.onBackPressed();
    }


    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}

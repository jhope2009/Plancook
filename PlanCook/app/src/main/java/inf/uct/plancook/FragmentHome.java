package inf.uct.plancook;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import inf.uct.componentes.Lista;
import inf.uct.componentes.ItemList;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import inf.uct.componentes.ImageView;
import inf.uct.componentes.LinearLayout;
import android.widget.ListView;
import inf.uct.componentes.TextView;
import inf.uct.componentes.Button;
import android.view.ViewGroup.LayoutParams;

import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentHome extends Fragment {

    View view;
    private ListView listview;
    private LinearLayout Layout_separador;
    private LinearLayout layout;
    private LinearLayout Layout_perfil;
    private LinearLayout Layout_menu;


    private String[] menus = {"Recetas Favoritas", "Recetas que me Gustan", "Despensa", "Ingredientes que no me Gustan", "Agregar Recetas","Invitar Amigos", "Ajustes"};
    private int [] draw = {R.drawable.assets_30px_de_0_0030_home_favorito,R.drawable.assets_30px_de_0_0029_home_me_gustan,R.drawable.assets_30px_de_0_0028_home_despensa,
            R.drawable.assets_30px_de_0_0027_home_ing_no_mg,
            R.drawable.assets_30px_de_0_0026_home_agregar_receta,R.drawable.assets_30px_de_0_0025_home_invitar_amigos, R.drawable.assets_30px_de_0_0024_home_ajustes};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        /*
        LinearLayout linear = new LinearLayout(getActivity());
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.setBackground(getResources(). getDrawable(R.drawable.walpaper_general));
        TextView text = new TextView(getActivity());
        text.setText("Recetario");
        */
        /*
___________________________________________________________________________________________________
TODOS LOS LAYOUTS DEL HOME INSTANCIADOS.
___________________________________________________________________________________________________
*/
        DisplayMetrics met = getResources().getDisplayMetrics();

        Layout_separador = new LinearLayout(getActivity(), LinearLayout.VERTICAL, Gravity.CENTER_VERTICAL, Color.TRANSPARENT);
        layout = new LinearLayout(getActivity(), LinearLayout.VERTICAL, Gravity.BOTTOM, Color.TRANSPARENT);
        Layout_perfil = new LinearLayout(getActivity(), LinearLayout.VERTICAL, Gravity.CENTER_VERTICAL, Color.TRANSPARENT);
        Layout_menu = new LinearLayout(getActivity(),LinearLayout.VERTICAL,Gravity.BOTTOM,Color.TRANSPARENT);
/*
___________________________________________________________________________________________________
PROPIEDADES DEL LAYOUT PRINCIPAL.
___________________________________________________________________________________________________
*/
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.walpaper_general));
/*
___________________________________________________________________________________________________
LISTA QUE CONTIENE LOS MENUS
___________________________________________________________________________________________________
*/
        Layout_separador.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
/*
___________________________________________________________________________________________________
LISTA QUE CONTIENE LOS MENUS
___________________________________________________________________________________________________
*/

        Lista li = new Lista(getActivity());
        for (int i = 0; i < menus.length; ++i) {
            li.InsertToList(new ItemList(draw[i],menus[i]));
        }
/**
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(getActivity(), ActivitiRecetasFavoritas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(getActivity(), ActivityRecetasqueMeGustan.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(getActivity(), ActivityDespensa.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(getActivity(), ActivitiRecetasFavoritas.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                //animacion jajjajjaja
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        view.setAlpha(1);
                    }
                });

            }

        });

*/
/*
___________________________________________________________________________________________________
PROPIEDADES DEL LAYOUT QUE CONTIENE LOS DATOS DEL PERFIL
___________________________________________________________________________________________________
*/
        Layout_perfil.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        Layout_perfil.setPadding(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 250, met), 0,0);
/*
___________________________________________________________________________________________________
LAYOUT PRINCIPAL QUE CONTIENE EL SCROL, EL CUAL A SU VEZ CONTIENE EL LAYOUT SEPARADOR
___________________________________________________________________________________________________
*/
        Layout_menu.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 220, met)));
/*
___________________________________________________________________________________________________
SE CREA EL IMAGEVIEW Y SE LE AGREGA LA IMAGEN
___________________________________________________________________________________________________
*/
        ImageView im_perfil = new ImageView(getActivity(),R.drawable.icono_1);
/*
___________________________________________________________________________________________________
LAYOUT PRINCIPAL QUE CONTIENE EL SCROL, EL CUAL A SU VEZ CONTIENE EL LAYOUT SEPARADOR
___________________________________________________________________________________________________
*/
        Layout_perfil.addView(im_perfil);
        TextView nom_user = new TextView(getActivity(),Layout_perfil,"Jairo Paredes Candia",Gravity.CENTER);
        nom_user.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, met));
/*
___________________________________________________________________________________________________

LAYOUT PRINCIPAL QUE CONTIENE EL SCROL, EL CUAL A SU VEZ CONTIENE EL LAYOUT SEPARADOR

___________________________________________________________________________________________________
*/      //Layout_menu.addView(listview);
        Layout_menu.addView(li.GetLista());
        Layout_separador.addView(Layout_perfil);
        layout.addView(Layout_separador);
        layout.addView(Layout_menu);

        view = layout;

        return view;
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
}

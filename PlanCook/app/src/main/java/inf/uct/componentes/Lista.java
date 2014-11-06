package inf.uct.componentes;

import android.content.Context;
import android.widget.ListView;

/**
 * Created by jairo on 25-10-2014.
 */
public class Lista {

    public ListView listView;
    public AdapterArray adapter;

    public Lista(Context context) {
        listView = new ListView(context);
        adapter = new AdapterArray(context);
    }

    public void InsertToList(ItemList items) {
        this.adapter.add(items);
    }

    public ListView GetLista() {
        this.listView.setAdapter(this.adapter);
        return this.listView;
    }
}

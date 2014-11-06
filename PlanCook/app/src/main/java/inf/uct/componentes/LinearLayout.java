package inf.uct.componentes;

import android.content.Context;
import android.graphics.Rect;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by jairo on 11-10-2014.
 */
public class LinearLayout extends android.widget.LinearLayout {

    public LinearLayout (Context context){
        super(context);
    }

    public LinearLayout (Context context, ImageView ima, TextView texto, ArrayList list){
        super(context);
        this.addView(ima);
        this.addView(texto);
        list.add(this);
        this.setOrientation(LinearLayout.HORIZONTAL);
    }
    public LinearLayout (Context context, int ima, int grav, LinearLayout lin){
        super(context);
        this.addView(new ImageView(context,ima));
        this.setGravity(grav);
        lin.addView(this);
    }
    public LinearLayout (Context context, int ima, int grav, LinearLayout lin, int alto, int ancho,int col,DisplayMetrics met){
        super(context);
        ImageView imag = new ImageView(context,ima);
        this.setLayoutParams(new ViewGroup.LayoutParams(
                ancho,
                alto));
        this.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, met),0,0,0);

        this.addView(imag);
        this.setBackgroundColor(col);
        this.setGravity(grav);
        lin.addView(this);
    }
    public LinearLayout (Context context, int ori, int grav, int col){
        super(context);
        this.setOrientation(ori);
        this.setGravity(grav);
        this.setBackgroundColor(col);
    }

}

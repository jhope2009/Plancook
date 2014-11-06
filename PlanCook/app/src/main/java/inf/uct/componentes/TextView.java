package inf.uct.componentes;

/**
 * Created by jairo on 10-10-2014.
 */
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TextView extends android.widget.TextView {

//    public TextView(Context context, LinearLayout layout, String text, int color, String font, float textSize, int gra, int topMargin){
//        super(context);
//        this.setText(text);
//        this.setTextColor(color);
//        this.setTextSize(textSize);
//        this.setGravity(gra);
//        this.setTop(topMargin);
//        this.setTypeface(Typeface.createFromAsset(context.getAssets(), font));
//        LayoutParams params= new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        params.gravity=gra;
//        params.topMargin=topMargin;
//        this.setLayoutParams(params);
//        layout.addView(this);
//    }

    public TextView(Context context, LinearLayout layout, String text, int color, String font, float textSize){
        super(context);
        this.setText(text);
        this.setTextColor(color);
        this.setTextSize(textSize);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), font));
        layout.addView(this);
    }

    public TextView(Context context, LinearLayout layout, String texto, int color,int gra ){
        super(context);
        this.setText(texto);
        this.setTextColor(color);
        this.setGravity(gra);
        layout.addView(this);
    }
    public TextView(Context context,String texto){
        super(context);
        this.setText(texto);
    }

    public TextView(Context context, LinearLayout layout, String texto, int gra){
        super(context);
        this.setText(texto);
        this.setTextColor(Color.BLUE);
        this.setGravity(gra);
        layout.addView(this);
    }

}

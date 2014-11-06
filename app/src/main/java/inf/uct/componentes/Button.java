package inf.uct.componentes;

/**
 * Created by jairo on 11-10-2014.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.LinearLayout;


public class Button extends android.widget.Button {

//    public Button(Context context, LinearLayout layout, int draw, int gra, int width, int height, int topMargin) {
//        super(context);
//        this.setBackgroundDrawable(getResources().getDrawable(draw));
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
//        params.gravity=gra;
//        params.topMargin=topMargin;
//        this.setLayoutParams(params);
//        layout.addView(this);
//    }
//    //BOTON NORMAL
//    public Button(Context context, LinearLayout layout, String text, int colorText, String font, float textSize, int color, int gra, int width, int height, int topMargin) {
//        super(context);
//        this.setBackgroundColor(color);
//        this.setText(text);
//        this.setTextColor(colorText);
//        this.setTextSize(textSize);
//        this.setTypeface(Typeface.createFromAsset(context.getAssets(), font));
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
//        params.gravity=gra;
//        params.topMargin=topMargin;
//        this.setLayoutParams(params);
//        layout.addView(this);
//    }

    public Button(Context context, LinearLayout layout, StateListDrawable states) {
        super(context);
        this.setBackgroundDrawable(states);
        layout.addView(this);
    }
    //BOTON NORMAL
    public Button(Context context, LinearLayout layout, String text, int colorText, String font, float textSize, int color) {
        super(context);
        this.setBackgroundColor(color);
        this.setText(text);
        this.setTextColor(colorText);
        this.setTextSize(textSize);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), font));
        layout.addView(this);
    }
}
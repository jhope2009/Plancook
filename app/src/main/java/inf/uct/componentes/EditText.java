package inf.uct.componentes;

/**
 * Created by jairo on 19-10-2014.
 */
import inf.uct.componentes.Colors;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;

public class EditText extends android.widget.EditText {
    //EDITTEXT NORMAL
//    public EditText(Context context, LinearLayout layout, String text, int color, String font, float textSize, int gra, int width, int height, int topMargin, int draw){
//        super(context);
//        this.setTextColor(color);
//        this.setTypeface(Typeface.createFromAsset(context.getAssets(), font));
//        this.setTextSize(textSize);
//        this.setHintTextColor(color);
//        this.setHint(text);
//        this.setPadding(20,10,10,10);
//        Drawable d= getResources().getDrawable(draw);
//        d.setBounds(0,0,(int)textSize+8,(int)textSize+8);
//        this.setCompoundDrawables(d,null,null,null);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
//        params.gravity=gra;
//        params.topMargin=topMargin;
//        this.setLayoutParams(params);
//        layout.addView(this);
//    }

    public EditText(Context context, LinearLayout layout, String text, int color, String font, float textSize, int draw){
        super(context);
        this.setTextColor(color);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), font));
        this.setTextSize(textSize);
        this.setHintTextColor(color);
        this.setHint(text);
        this.setPadding(20,10,10,10);
        Drawable d= getResources().getDrawable(draw);
        d.setBounds(0,0,(int)textSize+8,(int)textSize+8);
        this.setCompoundDrawables(d,null,null,null);
        layout.addView(this);
    }
}
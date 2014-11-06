package inf.uct.componentes;

/**
 * Created by jairo on 13-10-2014.
 */
import android.content.Context;

public class ImageView extends android.widget.ImageView {
    public ImageView(Context context, int draw) {
        super(context);
        this.setImageDrawable(getResources().getDrawable(draw));
    }

//    public ImageView(Context context, LinearLayout layout, int draw, int gra, int width, int height, int topMargin) {
//        super(context);
//        this.setImageDrawable(getResources().getDrawable(draw));
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
//        params.gravity=gra;
//        params.topMargin=topMargin;
//        this.setLayoutParams(params);
//        layout.addView(this);
//    }

    public ImageView(Context context, LinearLayout layout, int draw) {
        super(context);
        this.setImageDrawable(getResources().getDrawable(draw));
        layout.addView(this);
    }
}

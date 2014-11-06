package inf.uct.plancook;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import inf.uct.componentes.LinearLayout;
import android.widget.TableLayout;
import android.widget.RelativeLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.WrapperListAdapter;

/**
 * Created by jairo on 05-10-2014.
 */
public class SplashActivity extends Activity{
    private LinearLayout fl_main;
    private LinearLayout fl_copyright;
    private LinearLayout fl_barra;
    private LinearLayout fl_ima;
    private ImageView im_plancock;
    private ProgressBar barra;
    private TextView copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTheme(android.R.style.Theme_Holo_Light_NoActionBar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DisplayMetrics met = getResources().getDisplayMetrics();
        //UI
        copyright = new TextView(this);
        copyright.setText("derechos reservados");
        copyright.setGravity(Gravity.CENTER);
        copyright.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        barra = new ProgressBar(this);

        im_plancock = new ImageView(this);
        im_plancock.setImageDrawable(getResources().getDrawable(R.drawable.icono_1));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        im_plancock.setLayoutParams(params);

        fl_main = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_VERTICAL, Color.TRANSPARENT);
        fl_main.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        fl_main.setPadding(0,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 50, met),0,0);

        fl_ima = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_VERTICAL, Color.TRANSPARENT);
        fl_ima.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
        fl_ima.addView(im_plancock);

        fl_copyright = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.BOTTOM, Color.TRANSPARENT);
        fl_copyright.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        fl_copyright.addView(copyright);

        fl_barra = new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        fl_barra.setLayoutParams(new ViewGroup.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
        fl_barra.setPadding(0,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 50, met),0,0);
        fl_barra.addView(barra);

        fl_main.setBackgroundDrawable(getResources().getDrawable(R.drawable.wallpaper_splash_2));
        fl_main.addView(fl_ima);
        fl_main.addView(fl_barra);
        fl_main.addView(fl_copyright);

        this.setContentView(fl_main);

        //FIN INTERFAZ
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, ActivityPrincipal.class);
                startActivity(i);
                finish();
            }
        },3000);
    }


}
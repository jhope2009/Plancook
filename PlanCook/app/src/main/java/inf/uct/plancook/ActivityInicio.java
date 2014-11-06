package inf.uct.plancook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import inf.uct.componentes.Button;
import inf.uct.componentes.Colors;
import inf.uct.componentes.ImageView;
import inf.uct.componentes.LinearLayout;
import inf.uct.componentes.TextView;

/**
 * Created by Javier on 27-10-2014.
 */
public class ActivityInicio extends Activity implements View.OnClickListener {

    private LinearLayout linear;
    private LinearLayout layout_logo;
    private LinearLayout layout_text;
    private LinearLayout layout_buttons;
    private StateListDrawable statesFace;
    private StateListDrawable statesCorreo;
    private StateListDrawable states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        DisplayMetrics met = getResources().getDisplayMetrics();
        states=new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.botones_inicio_0_0000_inicio_sesion_on));
        states.addState(new int[]{}, getResources().getDrawable(R.drawable.botones_inicio_0_0001_inicio_sesion_off));
        statesFace=new StateListDrawable();
        statesFace.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.botones_inicio_0_0004_inicio_facebook_on));
        statesFace.addState(new int[]{}, getResources().getDrawable(R.drawable.botones_inicio_0_0005_inicio_facebook_off));
        statesCorreo=new StateListDrawable();
        statesCorreo.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.botones_inicio_0_0002_inicio_correo_on));
        statesCorreo.addState(new int[]{}, getResources().getDrawable(R.drawable.botones_inicio_0_0003_inicio_correo_off));

        linear=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_logo=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_text=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_buttons=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);

        linear.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linear.setBackgroundDrawable(getResources().getDrawable(R.drawable.wallpaper_splash_2));
        linear.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, -10, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met),0);
        layout_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_logo.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0);
        layout_text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_text.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0);
        layout_buttons.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_buttons.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 40, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 40, met),0);

        ImageView logo = new ImageView(this, layout_logo, R.drawable.logo);
        TextView label1 = new TextView(this, layout_text, "Elige una opcion de ingreso y comienza la experiencia...", Colors.ROJO_GENERAL, "fonts/Roboto-MediumItalic.ttf", 16);
        Button buttonFace = new Button(this, layout_buttons, statesFace);
        Button buttonCorreo = new Button(this, layout_buttons, statesCorreo);
        Button buttonLogin = new Button(this, layout_buttons, states);

        buttonFace.setId(1);
        buttonFace.setOnClickListener(this);
        buttonCorreo.setId(2);
        buttonCorreo.setOnClickListener(this);
        buttonLogin.setId(3);
        buttonLogin.setOnClickListener(this);

        linear.addView(layout_logo, ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 200, met));
        linear.addView(layout_text);
        linear.addView(layout_buttons);
        setContentView(linear);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case 1:
                Toast.makeText(this, "Registro Facebook", Toast.LENGTH_LONG).show();
                break;
            case 2:
                intent = new Intent(this, ActivityRegistro.class);
                this.startActivityForResult(intent, 10);
                break;
            case 3:
                intent = new Intent(this, ActivityLogin.class);
                this.startActivityForResult(intent, 10);
                break;
        }
    }
}

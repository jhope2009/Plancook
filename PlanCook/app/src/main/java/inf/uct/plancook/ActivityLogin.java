package inf.uct.plancook;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;

import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import inf.uct.componentes.Button;
import inf.uct.componentes.EditText;

import inf.uct.componentes.Colors;
import inf.uct.componentes.ImageView;
import inf.uct.componentes.LinearLayout;
import inf.uct.controller.Usuario;
import inf.uct.model.UsuarioFacade;

/**
 * Created by jairo on 19-10-2014.
 */
public class ActivityLogin extends Activity implements OnClickListener {

    private LinearLayout linear;
    private LinearLayout layout_logo;
    private LinearLayout layout_edit;
    private LinearLayout layout_text;
    private LinearLayout layout_buttons;
    private EditText editEmail;
    private EditText editPass;
    private StateListDrawable states;
    public Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        DisplayMetrics met = getResources().getDisplayMetrics();
        states=new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.botones_signin_login_0_0002_boton_iniciar_sesion_on));
        states.addState(new int[]{}, getResources().getDrawable(R.drawable.botones_signin_login_0_0003_boton_inciar_sesion_off));

        linear=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_logo=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_text=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_edit=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_buttons=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);

        linear.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linear.setBackgroundDrawable(getResources().getDrawable(R.drawable.wallpaper_splash_2));
        linear.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, -10, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met),0);
        layout_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_logo.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0);
        layout_edit.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_edit.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, met),0);
        layout_text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_text.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0);
        layout_buttons.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        layout_buttons.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 70, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 70, met),(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met));

        //ImageView logo = new ImageView(this, linear, R.drawable.logo, Gravity.CENTER, 180, 130, 30);
        ImageView logo = new ImageView(this, layout_logo, R.drawable.logo);
        editEmail = new EditText(this, layout_edit, "Correo electronico", Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 12, R.drawable.assets_25px_0001_correo_electronico);
        editPass = new EditText(this, layout_edit, "Contraseña", Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 12, R.drawable.assets_25px_0000_contrasena);
        editPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        Button buttonPass = new Button(this, layout_text, "¿Has olvidado tu contraseña?", Colors.ROJO_GENERAL, "fonts/Roboto-Regular.ttf", 13, Color.TRANSPARENT);
        Button buttonLogin = new Button(this, layout_buttons, states);

        buttonLogin.setOnClickListener(this);
        buttonPass.setOnClickListener(this);
        buttonLogin.setId(1);
        buttonPass.setId(2);

        linear.addView(layout_logo, ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 200, met));
        linear.addView(layout_edit);
        linear.addView(layout_text);
        linear.addView(layout_buttons);
        setContentView(linear);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case 1:
                user=null;
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                    }
                    @Override
                    protected Void doInBackground(Void... params) {
                        user=new UsuarioFacade().find(editEmail.getText().toString(), editPass.getText().toString());
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void result) {

                        super.onPostExecute(result);
                    }
                }.execute();
                Intent intent = new Intent(this, SplashActivity.class);
                this.startActivityForResult(intent, 10);
//                if (ok) {
//                    Intent intent = new Intent(this, ActivityPrincipal.class);
//                    this.startActivityForResult(intent, 10);
//                }else{
//                    Toast.makeText(getApplicationContext(), "¡Correo y/o Contraseña Incorrecta!: "+editEmail.getText().toString()+" "+editPass.getText().toString(), Toast.LENGTH_LONG).show();
//                }
                break;
            case 2:
                Toast.makeText(this, "Olvidaste tu contraseña", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(this, ActivityInicio.class);
        this.setResult(1,intent);
        super.onBackPressed();
    }
}

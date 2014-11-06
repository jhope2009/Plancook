package inf.uct.plancook;

import inf.uct.componentes.Colors;
import inf.uct.componentes.Button;
import inf.uct.componentes.EditText;
import inf.uct.componentes.ImageView;
import inf.uct.componentes.TextView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import inf.uct.componentes.LinearLayout;
import inf.uct.controller.Usuario;
import inf.uct.model.UsuarioFacade;

import android.widget.Toast;

public class ActivityRegistro extends Activity implements OnClickListener {

    private LinearLayout linear;
    private LinearLayout layout_titulo;
    private LinearLayout layout_logo;
    private LinearLayout layout_edit;
    private LinearLayout layout_text;
    private LinearLayout layout_buttons;
    private StateListDrawable states;
    private EditText editEmail;
    private EditText editNombre;
    private EditText editApellido;
    private EditText editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        DisplayMetrics met = getResources().getDisplayMetrics();
        states=new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.botones_signin_login_0_0000_boton_registrarse_on));
        states.addState(new int[]{}, getResources().getDrawable(R.drawable.botones_signin_login_0_0001_boton_registrarse_off));

        linear=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_titulo=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_logo=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_text=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_edit=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);
        layout_buttons=new LinearLayout(this, LinearLayout.VERTICAL, Gravity.CENTER_HORIZONTAL, Color.TRANSPARENT);

        linear.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linear.setBackgroundDrawable(getResources().getDrawable(R.drawable.wallpaper_splash_2));
        linear.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, -10, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 0, met),0);
        layout_titulo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_titulo.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 50, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 50, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, met),0);
        layout_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_logo.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0);
        layout_edit.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_edit.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, met),0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, met),0);
        layout_text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_text.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 40, met),0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 60, met),0);
        layout_buttons.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout_buttons.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 70, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, met),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 70, met),0);

        TextView label1 = new TextView(this, layout_titulo, "¡Registrate y vive la experiencia!", Colors.ROJO_GENERAL, "fonts/Roboto-MediumItalic.ttf", 16);
        //ImageView logo = new ImageView(this, linear, R.drawable.logo, Gravity.CENTER, 120, 70, 5);
        ImageView logo = new ImageView(this, layout_logo, R.drawable.logo);
        this.editNombre = new EditText(this, layout_edit, "Nombre", Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 12, R.drawable.assets_25px_0008_nombre_usuario);
        this.editApellido = new EditText(this, layout_edit, "Apellido",Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 12, R.drawable.assets_25px_0007_apeliido);
        this.editEmail = new EditText(this, layout_edit, "Correo electronico",Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 12, R.drawable.assets_25px_0001_correo_electronico);
        this.editPass = new EditText(this, layout_edit, "Contraseña", Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 12, R.drawable.assets_25px_0000_contrasena);
        this.editPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        TextView label2 = new TextView(this, layout_text, "*Minimo 6 caracteres", Colors.GRIS_700, "fonts/Roboto-Regular.ttf", 10);
        Button buttonRegistro = new Button(this, layout_buttons, states);

        buttonRegistro.setId(1);
        buttonRegistro.setOnClickListener(this);

        linear.addView(layout_titulo);
        linear.addView(layout_logo, ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 120, met));
        linear.addView(layout_edit);
        linear.addView(layout_text);
        linear.addView(layout_buttons);
        setContentView(linear);
        setContentView(linear);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 1:
                if(editEmail.getText().toString().matches("") && editNombre.getText().toString().matches("") && editApellido.getText().toString().matches("") && editPass.getText().toString().matches("")) {
                    Toast.makeText(this, "¡Debes completar todos los datos!", Toast.LENGTH_LONG).show();
                }else {
                    final Usuario user=new Usuario(editEmail.getText().toString(), editNombre.getText().toString(), editApellido.getText().toString(), editPass.getText().toString());
                    new AsyncTask<Void, Void, Void>() {
                        boolean ok=false;
                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                        }
                        @Override
                        protected Void doInBackground(Void... params) {
                            ok=new UsuarioFacade().save(user);
                            return null;
                        }
                        @Override
                        protected void onPostExecute(Void result) {
                            super.onPostExecute(result);
                        }
                    }.execute();
                    Intent intent = new Intent(this, SplashActivity.class);
                    this.startActivityForResult(intent, 10);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(this, ActivityInicio.class);
        this.setResult(1,intent);
        super.onBackPressed();
    }
}

package inf.uct.plancook;


import inf.uct.componentes.LinearLayout;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import inf.uct.componentes.Colors;
import android.view.Menu;
import android.graphics.drawable.ColorDrawable;
/**
 * Created by jairo on 16-10-2014.
 */
public class ActivityPrincipal extends FragmentActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Colors.ROJO_GENERAL));
        getActionBar().setIcon(new ColorDrawable(Color.TRANSPARENT));
        getActionBar().setTitle("");

        LinearLayout linear=new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        setContentView(linear);
        FrameLayout frame=new FrameLayout(this);
        frame.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, 1));
        frame.setId(1);

        mTabHost = new FragmentTabHost(this);
        mTabHost.setBackgroundColor(Colors.ROJO_GENERAL);
        mTabHost.setup(this, getSupportFragmentManager(), frame.getId());
        mTabHost.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("", getResources(). getDrawable(R.drawable.barra_navegacion_0_0004_home)),
                FragmentHome.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("", getResources().getDrawable(R.drawable.barra_navegacion_0_0003_recetario)),
                FragmentCalendario.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("", getResources().getDrawable(R.drawable.barra_navegacion_0_0002_lista_de_compra)),
                FragmentCalendario.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("", getResources().getDrawable(R.drawable.barra_navegacion_0_0001_consejos_y_trucos)),
                FragmentCalendario.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab5").setIndicator("", getResources().getDrawable(R.drawable.barra_navegacion_0_0000_calendario)),
                FragmentCalendario.class, null);

        mTabHost.getTabWidget().getChildAt(2).setBackgroundColor(Colors.AMARILLO);

        linear.addView(frame,0);
        linear.addView(mTabHost,1);
    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(this,FragmentHome.class);
        this.setResult(1,intent);
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

}

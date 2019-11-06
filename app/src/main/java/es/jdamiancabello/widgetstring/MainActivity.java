package es.jdamiancabello.widgetstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgpTipo;
    private LinearLayout contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenido = findViewById(R.id.llyContenido);
        rgpTipo = findViewById(R.id.rgpTipo);
        rgpTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                contenido.removeAllViews();
                switch (id){
                    case R.id.rbEmpresa:
                        contenido.addView(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_bussiness,contenido,false));
                        break;
                    case R.id.rbParticular:
                        contenido.addView(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_particular,contenido,false));
                        break;
                }

            }
        });
    }


}

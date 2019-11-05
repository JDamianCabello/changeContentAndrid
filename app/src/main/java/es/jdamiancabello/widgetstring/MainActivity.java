package es.jdamiancabello.widgetstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgpTipo;
    private ViewStub include;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        include = findViewById(R.id.includeLayout);
        rgpTipo = findViewById(R.id.rgpTipo);
        rgpTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.rbEmpresa:
                        include.setLayoutResource(R.layout.layout_bussiness);
                        break;
                    case R.id.rbParticular:
                        include.setLayoutResource(R.layout.layout_particular);
                        break;
                }
                include.inflate();
            }
        });
    }


}

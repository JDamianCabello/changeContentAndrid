package es.jdamiancabello.widgetstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgpTipo;
    private LinearLayout contenido;
    private AutoCompleteTextView autoCompleteTextViewMonth;
    private WebView webViewInformation;
    private Spinner spNumEmployees;

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
                        webViewInformation = findViewById(R.id.wbinformation);
                        spNumEmployees = findViewById(R.id.spNumeroEmpleados);
                        initialiceWvInformation();
                        initialiceNumEmployees();
                        break;
                    case R.id.rbParticular:
                        contenido.addView(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_particular,contenido,false));
                        autoCompleteTextViewMonth = findViewById(R.id.atMonth);
                        initialiceMonth();
                        break;
                }

            }
        });
    }

    private void initialiceWvInformation() {
        webViewInformation.loadData(getResources().getString(R.string.wvInformation),"text/html","utf-8");
    }

    /**
     * Inicializar el componente y añadir posibles eventos
     */
    private void initialiceMonth(){
        String months[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre", "Noviembre", "Diciembre"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,months);
        autoCompleteTextViewMonth.setAdapter(arrayAdapter);
    }

    /**
     * Iniciar el componente sp y añadir posibles eventos
     */
    private void initialiceNumEmployees(){
        spNumEmployees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(adapterView.getContext(),"Has seleccionado" + spNumEmployees.getItemAtPosition(i).toString() + " empleado",Toast.LENGTH_SHORT);
                String mensaje = spNumEmployees.getResources().getQuantityString(R.plurals.numEmployees,Integer.parseInt(spNumEmployees.getSelectedItem().toString()),Integer.parseInt(spNumEmployees.getSelectedItem().toString()));
                Toast.makeText(adapterView.getContext(),mensaje,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}

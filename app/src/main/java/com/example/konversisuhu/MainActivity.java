package com.example.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.konversisuhu.R;
import com.example.konversisuhu.Rumus.SharedPrefsTemp;
import com.example.konversisuhu.Rumus.Temperatures;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText edit_temp1, edit_temp2;
    private Temperatures temperature;
    private String[] temperatures = new String[]{
            "\u00B0C",
            "\u00B0R",
            "\u00B0F",
            "K"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperature = new Temperatures(this);


        //  edit text temp to conversion 1
        edit_temp1 = findViewById(R.id.edt_suhu);

        //  edit text temp to conversion 2
        edit_temp2 = findViewById(R.id.edt_suhu2);
        edit_temp2.setHint(SharedPrefsTemp.getTempSymbol2(MainActivity.this));
        edit_temp2.setKeyListener(null);
        edit_temp2.setClickable(false);

        //  Spinner & Adapter 1
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, temperatures);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AppCompatSpinner appCompatSpinner1 = findViewById(R.id.suhu_1);
        appCompatSpinner1.setAdapter(arrayAdapter1);

        //  set selection
        appCompatSpinner1.setSelection(SharedPrefsTemp.getTempIndex1(MainActivity.this));
        appCompatSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp_symbol1 = temperatures[position];
                SharedPrefsTemp.setTemperature1(MainActivity.this, temp_symbol1, position);
                edit_temp1.setHint(temperatures[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //  Spinner & Adapter 2
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, temperatures);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AppCompatSpinner appCompatSpinner2 = findViewById(R.id.suhu_2);
        appCompatSpinner2.setAdapter(arrayAdapter2);
        appCompatSpinner2.setSelection(SharedPrefsTemp.getTempIndex2(MainActivity.this));

        //  set selection
        appCompatSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp_symbol2 = temperatures[position];
                SharedPrefsTemp.setTemperature2(MainActivity.this, temp_symbol2, position);
                edit_temp2.setHint(temperatures[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //  Button Count
        AppCompatButton btn_count = findViewById(R.id.btn_hitung);
        btn_count.setOnClickListener(view -> {
            if (Objects.requireNonNull(edit_temp1.getText()).toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Masukan nilai suhu yang ingin dikonversi", Toast.LENGTH_SHORT).show();
            } else {
                String symbol_temp1 = SharedPrefsTemp.getTempSymbol1(MainActivity.this);
                String symbol_temp2 = SharedPrefsTemp.getTempSymbol2(MainActivity.this);
                double value_to_conversion = Double.parseDouble(edit_temp1.getText().toString());

                //  C to R
                if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("\u00B0R")){
                    edit_temp2.setText(temperature.CelciusToReamur(value_to_conversion));
                }
                //  C to F
                else if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("\u00B0F")) {
                    edit_temp2.setText(temperature.CelciusToFahrenheit(value_to_conversion));
                }
                //  C to K
                else if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("K")) {
                    edit_temp2.setText(temperature.CelciusToKelvin(value_to_conversion));
                }
                //  R to C
                else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("\u00B0C")) {
                    edit_temp2.setText(temperature.ReamurToCelcius(value_to_conversion));
                }
                //  R to F
                else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("\u00B0F")) {
                    edit_temp2.setText(temperature.ReamurToFahrenheit(value_to_conversion));
                }
                //  R to K
                else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("K")) {
                    edit_temp2.setText(temperature.ReamurToKelvin(value_to_conversion));
                }
                //  F to C
                else if (symbol_temp1.equals("\u00B0F") && symbol_temp2.equals("\u00B0C")) {
                    edit_temp2.setText(temperature.FahrenheitToCelcius(value_to_conversion));
                }
                //  F to R
                else if (symbol_temp1.equals("\u00B0F") && symbol_temp2.equals("\u00B0R")) {
                    edit_temp2.setText(temperature.FahrenheitToReamur(value_to_conversion));
                }
                //  F to K
                else if (symbol_temp1.equals("\u00B0F") && symbol_temp2.equals("K")) {
                    edit_temp2.setText(temperature.FahrenheitToKelvin(value_to_conversion));
                }
                //  IF C equals C
                else if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("\u00B0C")) {
                    edit_temp2.setText(temperature.check_after_decimal_point(value_to_conversion));
                }
                //  IF R to R
                else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("\u00B0R")) {
                    edit_temp2.setText(temperature.check_after_decimal_point(value_to_conversion));
                }
                //  IF F to F
                else if (symbol_temp1.equals("\u00B0F") && symbol_temp2.equals("\u00B0F")) {
                    edit_temp2.setText(temperature.check_after_decimal_point(value_to_conversion));
                }
            }
        });
    }
}
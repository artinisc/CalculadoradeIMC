package com.trabalhosatc.calculadoradeimc;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.calcular).setOnClickListener( new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                EditText altM = findViewById(R.id.alturaM);
                String met = String.valueOf(altM.getText().toString());
                EditText altC = findViewById(R.id.alturaC);
                String cent = String.valueOf(altC.getText().toString());
                EditText pes = findViewById(R.id.peso);
                TextView res = findViewById(R.id.resultado);
                String alt = met + "." + cent;

                float valorAlt = Float.parseFloat(alt);
                float valorPes = Float.parseFloat(pes.getText().toString());
                float valorRes = 0;
                String resultC = "";
                String result = "";

                valorRes = valorPes/(valorAlt*valorAlt);
                resultC = String.format("%.2f", valorRes);

                if(valorRes < 18.5){
                    result = "IMC: " + resultC + " MAGREZA";
                }else if(valorRes >= 18.5 && valorRes < 25){
                    result = "IMC: " + resultC + " NORMAL";
                }else if(valorRes >= 25 && valorRes < 30){
                    result = "IMC: " + resultC + " SOBREPESO";
                }else if(valorRes >= 30 && valorRes < 35){
                    result = "IMC: " + resultC + " OBESIDADE GRAU 1";
                }else if(valorRes >= 35 && valorRes < 40){
                    result = "IMC: " + resultC + " OBESIDADE GRAU 2";
                }else if(valorRes >= 40){
                    result = "IMC: " + resultC + " OBESIDADE MORBIDA";
                }

                res.setText(result);

            }
        });
    }


}
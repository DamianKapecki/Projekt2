package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Other extends AppCompatActivity {
    int zmienna3=0;
    List<String> listaO = new ArrayList<>();
    List<String> listaP =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other2);
        final Spinner spinnerT = (Spinner) findViewById(R.id.spinnerT);
        Button buTT = findViewById(R.id.CONV2);
        Button RETT = findViewById(R.id.rett);
        EditText VAL = findViewById(R.id.VALUE);
        TextView WYN = findViewById(R.id.textView82);
        listaO.add("Choose your conversion");






        ArrayAdapter adapter14 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaO);
        spinnerT.setAdapter(adapter14);
        spinnerT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        load();



        RETT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert2();
            }






            private void convert2() {
                SharedPreferences sp = getApplicationContext().getSharedPreferences("Danee", MODE_PRIVATE);
                int licznik = sp.getInt("licznikk", 0);
                zmienna3 = spinnerT.getSelectedItemPosition();
                String ide = "0";
                int war =0;

                while(war<=licznik){
                    if (zmienna3==war+1){
                        ide=listaP.get(war);
                    }
                    war++;
                }
                if (ide.isEmpty() == true){
                    ide="0";

                }
                String wartosc = VAL.getText().toString();
                if(wartosc.isEmpty()==true){
                    WYN.setText("Value is empty");
                }
                else{
                    double wartosc1 = Double.parseDouble(wartosc);
                    double przelicznik = Double.parseDouble(ide);
                    double wynik = wartosc1 * przelicznik;
                    WYN.setText("Result " + wynik);

                }

            }
        });

    }

    private void load() {
        SharedPreferences sp = getApplicationContext().getSharedPreferences("Danee", MODE_PRIVATE);
        int licznik = sp.getInt("licznikk", 0);

        for (int i=0;i<=licznik-1;i++){


            String el1 = sp.getString("el11" + i, "");
            String el2 = sp.getString("el22" + i, "");
            String el3 = sp.getString("el33" + i, "");


            listaO.add(el1+"---->"+el2);
            listaP.add(el3);



        }
    }
}

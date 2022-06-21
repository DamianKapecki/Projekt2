package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView, textView2;
    Button button, button2, button3;
    int zmienna1 = 0;
    int zmienna2 = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView19);
        editText = findViewById(R.id.editTextNumber5);
        textView2 = findViewById(R.id.textView17);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        final Spinner spinner = (Spinner) findViewById(R.id.spinner6);
        List<String> lista1 = new ArrayList<>();
        lista1.add("Kilometr");lista1.add("Metr");lista1.add("Cal");lista1.add("Stopa");lista1.add("Mila");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista1);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Wybrano opcje" + (id  ), Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner7);

        List<String> lista2 = new ArrayList<>();
        lista2.add("Kilometr");lista2.add("Metr");lista2.add("Cal");lista2.add("Stopa");lista2.add("Mila");
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista2);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 Toast.makeText(MainActivity.this, "Wybrano opcje" + (id), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zmienna2 = spinner1.getSelectedItemPosition();
                zmienna1 = spinner.getSelectedItemPosition() + 1;
                Convert();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtherPage.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(MainActivity.this,Other.class);
                startActivity(intent2);

            }


        });




    }

    private void Convert() {

        String[] Przeliczniki = new String[] {"1","1000","39370.07874","3280.8399","0.62137","0.001","1","39.37008",
                "3.28084","0.00062","0.00003","0.02540","1","0.08333","0.00002","0.0003","0.30480","12","1","0.00019","1.60934",
                "1609.344","63360","5280","1"};


        String idp = "0";
        for(int i=1;i<6;i++){
            if(zmienna1 ==i){
                idp=Przeliczniki[zmienna2+((zmienna1-1)*5)];
            }
        }

        String wartosc = editText.getText().toString();
        if(wartosc.isEmpty()==true){
            textView2.setText("Value is empty");
        }
        else{
            double wartosc1 = Double.parseDouble(wartosc);
            double przelicznik = Double.parseDouble(idp);
            double wynik = wartosc1 * przelicznik;
            textView2.setText("Result " + wynik);

        }



    }
}






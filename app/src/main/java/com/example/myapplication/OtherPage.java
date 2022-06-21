package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class OtherPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Button butt,butt2;
        butt=findViewById(R.id.save);
        butt2=findViewById(R.id.butt);



        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               transfer();


            }
        });


    }

    private void transfer() {

        EditText editText11,editText22,editText33;
        SharedPreferences sp;

        editText11=findViewById(R.id.primary);
        editText22=findViewById(R.id.tagetunit);
        editText33=findViewById(R.id.editTextNumber2);
        sp =getSharedPreferences("Danee",MODE_PRIVATE);

        String pierwszy = editText11.getText().toString();
        String drugi = editText22.getText().toString();
        String przelstr = editText33.getText().toString();
        if (przelstr.isEmpty() == true || pierwszy.isEmpty() == true || drugi.isEmpty() == true) {
            Toast.makeText(OtherPage.this, "NO SUFFICIENT DATA", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = sp.edit();
            int licznik = sp.getInt("licznikk", 0);


            editor.putString("el11" + licznik, pierwszy);
            editor.putString("el22" + licznik, drugi);
            editor.putString("el33" + licznik, przelstr);
            licznik++;
            editor.putInt("licznikk", licznik);


            editor.commit();
            Toast.makeText(OtherPage.this, "Correct save", Toast.LENGTH_SHORT).show();


        }


    }
}

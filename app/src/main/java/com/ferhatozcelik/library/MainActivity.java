package com.ferhatozcelik.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ferhatozcelik.wordfilter.Filter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button buttonKontrolEt;
    TextView textView2;
    Filter filter;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = new Filter();
        filter.run(MainActivity.this);



        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);
        buttonKontrolEt = findViewById(R.id.buttonKontrolEt);



        buttonKontrolEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /// FilterGetBoolean Methodu true yada false döndürür
                if (filter.FilterGetBoolean(editText.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Argo ve Küfür İçerir.",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Argo ve Küfür İçermiyor.",Toast.LENGTH_LONG).show();
                }

                textView2.setText(filter.FilterGetString(editText.getText().toString(),"Argo Kelime Kullandınız!"));



            }
        });




    }
}

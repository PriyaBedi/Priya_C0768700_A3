package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Candidate extends AppCompatActivity {

    TextView c1,c2,c3, v1, v2, v3;
    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        c1 = findViewById(R.id.cand1);
        c2 = findViewById(R.id.cand2);
        c3 = findViewById(R.id.cand3);
        v1 = findViewById(R.id.vote1);
        v2 = findViewById(R.id.vote2);
        v3 = findViewById(R.id.vote3);
        backbtn = findViewById(R.id.backbutton);

        String num1 = getIntent().getStringExtra("ref1");
        String num2 = getIntent().getStringExtra("ref2");
        String num3 = getIntent().getStringExtra("ref3");

        v1.setText(num1);
        v2.setText(num2);
        v3.setText(num3);

        backbtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Candidate.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }


}
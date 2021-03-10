package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    String[] country = { "Choose Candidate", "Candidate 1", "Candidate 2", "Candidate 3"};
    Button userVote;
    EditText username, id;
    ToggleButton togglebtn;
    int count1 = 0, count2 = 0 , count3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        userVote = findViewById(R.id.vote);
        username = findViewById(R.id.name);
        id = findViewById(R.id.idtext);
        togglebtn = findViewById(R.id.toggleButton);
        List<String> userid = new ArrayList<>();
        String idnew = id.getText().toString();



                if (userid.contains(idnew)) {
                    Toast.makeText(getApplicationContext(), "A user can vote only once.", Toast.LENGTH_SHORT);
                } else {
                    togglebtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                userid.add(idnew);

                                spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        String item = String.valueOf(parent.getItemAtPosition(position));
                                        switch (item) {
                                            case "Candidate 1":
                                                count1++;
                                            case "Candidate 2":
                                                count2++;
                                            case "Candidate 3":
                                                count3++;
                                            default:
                                                Toast.makeText(getApplicationContext(), "No candidate selected", Toast.LENGTH_SHORT);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }else {
                                Toast.makeText(getApplicationContext(), "You need to accept the terms in order to vote", Toast.LENGTH_SHORT);
                            }

                                userVote.setOnClickListener(new View.OnClickListener(){

                                    @Override
                                    public void onClick(View view) {


                                        String c1 = String.valueOf(count1);
                                        String c2 = String.valueOf(count2);
                                        String c3 = String.valueOf(count3);

                                        Intent intent = new Intent(MainActivity.this, Candidate.class);
                                        intent.putExtra("ref1", c1);
                                        intent.putExtra("ref2", c2);
                                        intent.putExtra("ref3", c3);
                                        startActivity(intent);
                                    }
                                });



                            }

                    });




}
}
        }





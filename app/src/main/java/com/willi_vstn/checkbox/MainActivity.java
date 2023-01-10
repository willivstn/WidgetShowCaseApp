package com.willi_vstn.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox box1, box2;
    Button btn;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);
        btn = findViewById(R.id.btn);



        RadioGroup radioGroup;
        radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                RadioButton radioButton = findViewById(checked);
                Toast.makeText(MainActivity.this, "Selected: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        spinner = findViewById(R.id.spinner1);
        String[] courses = {"C++", "Java", "Kotlin", "C#"};
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Selected: "+courses[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(box1.isChecked()){
                    Toast.makeText(MainActivity.this, "Cheese Topping is added", Toast.LENGTH_SHORT).show();
                }else {

                }

                if (box2.isChecked()){
                    Toast.makeText(MainActivity.this, "Tomato topping is added", Toast.LENGTH_SHORT).show();
                }else{

                }
            }


        });


    }
}
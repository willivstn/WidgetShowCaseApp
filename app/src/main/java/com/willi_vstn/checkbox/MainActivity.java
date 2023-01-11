package com.willi_vstn.checkbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
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
        spinner = findViewById(R.id.spinner1);

        RadioGroup radioGroup;
        radioGroup = findViewById(R.id.radioGroup1);
        Button b2;

        //Progress Bar
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
       // progressBar.incrementProgressBy();


        //Time picker
        b2 = findViewById(R.id.button);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Display the time picker
                DialogFragment timePickerFrag = new TimePickerFragment();

                timePickerFrag.show(
                        getSupportFragmentManager(), "Pick Time"
                );
            }
        });


        //RADIO GROUP
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                RadioButton radioButton = findViewById(checked);
                Toast.makeText(MainActivity.this, "Selected: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //SPINNER
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

        Button b3 = findViewById(R.id.btn_date);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "Pick date");
            }
        });

        //CHECKBOX btn
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Increase Progress by 10%
                progressBar.incrementProgressBy(10);

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
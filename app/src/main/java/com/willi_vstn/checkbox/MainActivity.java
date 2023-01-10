package com.willi_vstn.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox box1, box2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);
        btn = findViewById(R.id.btn);

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
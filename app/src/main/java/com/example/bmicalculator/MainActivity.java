package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView heightText;
    EditText heightInput;
    TextView weightText;
    EditText weightInput;
    TextView outputTextView;
    Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightText = findViewById(R.id.heightText);
        heightInput = findViewById(R.id.heightInput);
        weightText = findViewById(R.id.weightText);
        weightInput = findViewById(R.id.weightInput);
        outputTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
//              outputTextView.setText("Button Tapped!");
                String heightString;
                String weightString;

                double height;
                double weight;
                double BMI;

                heightString = heightInput.getText().toString();
                weightString = weightInput.getText().toString();

                height = Double.parseDouble(heightString);
                weight = Double.parseDouble(weightString);
                height = height/100.0;
                BMI = weight/(height*height);

                outputTextView.setText("Your BMI Value is "+BMI);
            }
        });



    }
}
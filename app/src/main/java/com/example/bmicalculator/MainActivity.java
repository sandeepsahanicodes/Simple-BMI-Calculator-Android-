package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;   // Importing required libraries

public class MainActivity extends AppCompatActivity
{
    TextView heightText;   // Creating instance of TextView
    EditText heightInput; // Creating instance of EditText
    TextView weightText;
    EditText weightInput;
    TextView outputTextView;
    Button calculateButton;  // Creating instance of Button

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R file holds id's of elements of used resources
        heightText = findViewById(R.id.heightText); // Initializing TextViews,EditText and Button
        heightInput = findViewById(R.id.heightInput);
        weightText = findViewById(R.id.weightText);
        weightInput = findViewById(R.id.weightInput);
        outputTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener()  // Adding click listener on calculate button
        {
            @Override
            public void onClick(View view)
            {
                // Code executes when button is tapped
                String heightString; // To hold the value of height as string
                String weightString; // To hold the value of weight as string

                double height;
                double weight; // Variable to hold weight value as double
                double BMI;  // Variable to hold BMI value

                heightString = heightInput.getText().toString();
                weightString = weightInput.getText().toString(); // Getting values of weight and height from EditText as string
                if (TextUtils.isEmpty(heightString)) // Checking weather height field is empty
                {
                    outputTextView.setText("Height field is empty!");
                    outputTextView.setTextColor(Color.RED);
                }
                else if (TextUtils.isEmpty(weightString)) // Checking weather weight field is empty
                {
                    outputTextView.setText("Weight field is empty!");
                    outputTextView.setTextColor(Color.RED);
                }
                else
                {
                    height = Double.parseDouble(heightString); // Converting received string to double for the further evaluation
                    weight = Double.parseDouble(weightString);

                    if (weight == 0 || height == 0) // Checking weather height or weight is zero
                    {
                    outputTextView.setText("Enter a non zero value of weight or height!");
                    outputTextView.setTextColor(Color.RED);
                    }
                    else if (height <= 100 || height >= 300) // Checking bound for height
                    {
                        outputTextView.setText("Height value should be in range of 100cm to 300cm");
                        outputTextView.setTextColor(Color.RED);
                    }
                    else
                    {
                        height = height / 100.0; // Converting height from centimeter to meter
                        BMI = weight / (height * height); // Calculating BMI
                        outputTextView.setTextColor(Color.BLUE);
                        outputTextView.setText(String.format("Your BMI is %.2f",BMI)); // Setting text of outputTextView
                    }
                }
            }
        });

        }

    }

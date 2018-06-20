package com.example.keetawatsrichompoo.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateButton(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView resultText = (TextView) findViewById(R.id.resultText);

        EditText heightLabel = (EditText) findViewById(R.id.heightText);
        EditText weightLabel = (EditText) findViewById(R.id.weightText);

        ImageView img = (ImageView) findViewById(R.id.imageDisplay);

        double height = Double.parseDouble(heightLabel.getText().toString());
        double weight = Double.parseDouble(weightLabel.getText().toString());

        if( height > 0 && weight > 0 ) {
            double result = weight / ((height/100)*(height/100));
            String output = String.format("%.2f", result);
            resultText.setText("Your BMI is "+output);

            if(result < 22) {
                img.setImageResource(R.drawable.underweight);
                img.setVisibility(View.VISIBLE);
            }

            else if(result >= 22 && result <= 30) {
                img.setImageResource(R.drawable.normal);
                img.setVisibility(View.VISIBLE);
            }

            else {
                img.setImageResource(R.drawable.fat);
                img.setVisibility(View.VISIBLE);
            }
        }

    }
}

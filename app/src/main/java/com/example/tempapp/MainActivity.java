package com.example.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    EditText edText;
    Button btnCalculate;
    TextView tvResults;
    DecimalFormat formatter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText=findViewById(R.id.edText);
        btnCalculate=findViewById(R.id.btnCalculate);
        tvResults=findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

            formatter= new DecimalFormat("#0.0");



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edText.toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter a number",Toast.LENGTH_SHORT).show();
                }else{

                    int chirps=Integer.parseInt(edText.getText().toString().trim());
                    double temp=(chirps/3.0)+4;

                    String results="The approximate temperature outside is" + formatter.format(temp) + "degrees Celsius.";

                    tvResults.setText(results);
                    tvResults.setVisibility(View.VISIBLE);

                }
            }
        });

    }
}

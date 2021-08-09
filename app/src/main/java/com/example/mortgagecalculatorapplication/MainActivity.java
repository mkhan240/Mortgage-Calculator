package com.example.mortgagecalculatorapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button calculateButton,resetButton;
    private TextView textView1;
    private SeekBar seekYear;
    int currentProgress;

    @Override  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekYear = (SeekBar) findViewById(R.id.loanDurationSeekBar);
        seekYear.setMax(3);

        textView1 = (TextView) findViewById(R.id.loanDurationtxt);
        textView1.setText("Loan Duration: " + seekYear.getProgress() + " years");

        seekYear.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress * 10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, " Duration Selected",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView1.setText("Loan Duration: " + currentProgress + " years");
                Toast.makeText(MainActivity.this, " Duration Selected",Toast.LENGTH_LONG).show();
            }
        });

        // for calculation
        calculateButton =(Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override  public void onClick(View v) {
                EditText txtpurchaseAmmount=(EditText) findViewById(R.id.purchaseAmmounttxt);
                EditText txtintrest=(EditText) findViewById(R.id.interestRatetxt);
                EditText txtdownPayment=(EditText) findViewById(R.id.downPaymenttxt);
                EditText txttotal=(EditText) findViewById(R.id.totaltxt);

                float purchaseAmount = Float.parseFloat(txtpurchaseAmmount.getText().toString());
                float downPayment= Float.parseFloat(txtdownPayment.getText().toString());
                float interest_rate = Float.parseFloat(txtintrest.getText().toString());


                // here we calculate amount
                float principal = purchaseAmount - downPayment;
                double number_of_months = currentProgress * 12;
                float monthly_interest_rate = (interest_rate/100)/12;
                double x_variable = 1 + monthly_interest_rate;
                float y_variable = (float) Math.pow(x_variable,number_of_months);
                float monthlypay = principal * ((monthly_interest_rate * y_variable)/(y_variable - 1));
                String s = String.format("%.2f", monthlypay);

                txttotal.setText("$" + s + " per month for next " + "\n" + Integer.toString(currentProgress) + " years.");
            }
        });
        resetButton =(Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View v) {
                EditText txtpurchaseAmmount=(EditText) findViewById(R.id.purchaseAmmounttxt);
                EditText txtintrest=(EditText) findViewById(R.id.interestRatetxt);
                EditText txtdownPayment=(EditText) findViewById(R.id.downPaymenttxt);
                EditText txttotal=(EditText) findViewById(R.id.totaltxt);
                txtintrest.setText("");  txtpurchaseAmmount.setText("");
                txtdownPayment.setText("");  txttotal.setText("");
            }
        });
    }

}
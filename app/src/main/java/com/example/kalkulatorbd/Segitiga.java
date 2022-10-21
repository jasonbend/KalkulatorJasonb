package com.example.kalkulatorbd;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Segitiga extends AppCompatActivity {
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    EditText a;
    EditText t;
    EditText k1;
    EditText k2;
    Button hitung;
    TextView luas;
    TextView keliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        relativeLayout = findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        a = (EditText)findViewById(R.id.alas);
        t = (EditText)findViewById(R.id.tinggi);
        k1 = (EditText)findViewById(R.id.kaki1);
        k2 = (EditText)findViewById(R.id.kaki2);
        hitung = (Button) findViewById(R.id.button);
        luas = (TextView)findViewById(R.id.hasilluas);
        keliling = (TextView) findViewById(R.id.hasilkeliling);

        hitung.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a.length() == 0 && t.length() == 0 && k1.length() == 0 && k2.length() == 0) {
                    Toast.makeText(getApplication(), "TIDAK BOLEH KOSONG SEMUA", Toast.LENGTH_LONG).show();
                }
                else if (a.length() > 0 && t.length() > 0 && k1.length() == 0 && k2.length() == 0) {
                    String alas = a.getText().toString();
                    String tinggi = t.getText().toString();

                    double a = Double.parseDouble(alas);
                    double t = Double.parseDouble(tinggi);
                    double miring = Math.sqrt( Math.pow(a,2) + Math.pow(t,2) );
                    double hs = a+miring+t;
                    double hs2 = 0.5*a*t;

                    String output = String.valueOf(hs);
                    keliling.setText(output.toString());
                    output = String.valueOf(hs2);
                    luas.setText(output.toString());
                }
                else if (a.length() > 0 && t.length() == 0 && k1.length() > 0 && k2.length() > 0) {
                    String alas = a.getText().toString();
                    String kaki1 = k1.getText().toString();
                    String kaki2 = k2.getText().toString();

                    double a = Double.parseDouble(alas);
                    double k1 = Double.parseDouble(kaki1);
                    double k2 = Double.parseDouble(kaki2);
                    double hs = a+k1+k2;
                    double s = 0.5*hs;
                    double hs2 = Math.sqrt(s*(s-a)*(s-k1)*(s-k2));

                    String output = String.valueOf(hs);
                    keliling.setText(output.toString());
                    output = String.valueOf(hs2);
                    luas.setText(output.toString());
                }
                else {
                    Toast.makeText(getApplication(), "ERROR", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void kembali(View view) {
        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()){
            animationDrawable.stop();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()){
            animationDrawable.start();
        }
    }
}
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

public class Persegi extends AppCompatActivity {
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    EditText s;
    Button hitung;
    TextView luas;
    TextView keliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        relativeLayout = findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        s = (EditText)findViewById(R.id.sisi);
        hitung = (Button) findViewById(R.id.button);
        luas = (TextView)findViewById(R.id.hasilluas);
        keliling = (TextView) findViewById(R.id.hasilkeliling);

        hitung.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (s.length() == 0) {
                    Toast.makeText(getApplication(), "SISI TIDAK BOLEH KOSONG", Toast.LENGTH_LONG).show();
                }
                else {
                    String sisi = s.getText().toString();

                    double s = Double.parseDouble(sisi);
                    double hs = (s*s);
                    double hs2 = (s*4);

                    String output = String.valueOf(hs);
                    luas.setText(output.toString());

                    output = String.valueOf(hs2);
                    keliling.setText(output.toString());
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
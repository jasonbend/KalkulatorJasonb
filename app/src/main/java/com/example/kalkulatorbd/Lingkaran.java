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

public class Lingkaran extends AppCompatActivity {
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    EditText r;
    Button hitung;
    TextView luas;
    TextView keliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        relativeLayout = findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        r = (EditText)findViewById(R.id.jari);
        hitung = (Button) findViewById(R.id.button);
        luas = (TextView)findViewById(R.id.hasilluas);
        keliling = (TextView) findViewById(R.id.hasilkeliling);

        hitung.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r.length() == 0) {
                    Toast.makeText(getApplication(), "JARI-JARI TIDAK BOLEH KOSONG", Toast.LENGTH_LONG).show();
                }
                else {
                    String jari = r.getText().toString();

                    double r = Double.parseDouble(jari);
                    double hs = (22*r*r)/7;
                    double hs2 = (22*r*2)/7;

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
package com.example.kalkulatorbd;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        Button Lingkaran = findViewById(R.id.lingkaran);

        Lingkaran.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent Lingkaran = new Intent(MainActivity.this, Lingkaran.class);
                startActivity(Lingkaran);
            }
        });
        Button Segitiga = findViewById(R.id.segitiga);

        Segitiga.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent Segitiga = new Intent(MainActivity.this, Segitiga.class);
                startActivity(Segitiga);
            }
        });
        Button Persegi = findViewById(R.id.persegi);

        Persegi.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent Persegi = new Intent(MainActivity.this, Persegi.class);
                startActivity(Persegi);
            }
        });
    }
    public void keluar(View view){
        System.exit(0);
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
package com.dam.snippets.a3_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.dam.snippets.R;

public class A31_Splash_Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a31_splash_animation);

        ImageView imageView = findViewById(R.id.ivSplash);

        imageView.animate().alpha(1).rotation(3600).setDuration(2000);

    }
}
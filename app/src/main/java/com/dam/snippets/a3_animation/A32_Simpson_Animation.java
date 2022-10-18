package com.dam.snippets.a3_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.dam.snippets.R;

public class A32_Simpson_Animation extends AppCompatActivity {

    // Déclartion des var
    ImageButton ivBtnLesSimpson;
    ImageView ivBart;
    ImageView ivHomer;

    // On fait le lien entre la vue et le code
    public void initUI() {
        ivBtnLesSimpson = findViewById(R.id.ivBtnLesSimpson);
        ivBart = findViewById(R.id.ivBart);
        ivHomer = findViewById(R.id.ivHomer);
    }

    public void Anim(View view) {
        // On fait un fade pour faire apparaitre notre image et on la fait tourner en même temps
        ivBtnLesSimpson.animate().alpha(0).rotation(3600).setDuration(2000);
        ivBart.animate().translationXBy(-3000).setDuration(4000);
        ivHomer.animate().translationXBy(-3000).setDuration(5000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a32_simpson_animation);

        initUI();
    }
}
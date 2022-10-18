package com.dam.snippets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dam.snippets.a1_layout_xml.A11_LinearLayoutXml;
import com.dam.snippets.a1_layout_xml.A12_FrameLayoutXml;
import com.dam.snippets.a1_layout_xml.A13_RelativeLayoutXml;
import com.dam.snippets.a3_animation.A31_Splash_Animation;

public class A0_AccueilActivity extends AppCompatActivity {

    /** Var globales **/
    TextView tvLinearLayout, tvFrameLayout, tvRelativeLayout, tvTableLayout;

    TextView tvAnimationSplash;

    /******* Méthodes  Perso *******/
    /** Méthode pour l'initialisation des composants **/
    private void initUI(){
        // Layout Xml
        tvLinearLayout = findViewById(R.id.tvLinearLayout);
        tvFrameLayout = findViewById(R.id.tvFrameLayout);
        tvRelativeLayout = findViewById(R.id.tvRelativeLayout);
        tvTableLayout = findViewById(R.id.tvTableLayout);

        // Animation
//        tvAnimationSplash = findViewById(R.id.tvAnimationSplash);
    }

    private void clicLinear(){
        tvLinearLayout.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                // Action effectuée lors du clic ici un intent pour se rendre sur l'activité des linear layout
                // Départ                   // Arrivée
                Intent intent = new Intent(A0_AccueilActivity.this, A11_LinearLayoutXml.class);
                startActivity(intent);
            }
        });
    }

    private void clicFrame(){
        tvFrameLayout.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A12_FrameLayoutXml.class);
                startActivity(intent);
            }
        });
    }

    private void clicRelative(){
        tvRelativeLayout.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A13_RelativeLayoutXml.class);
                startActivity(intent);
            }
        });
    }

//    private void clicSplash(){
//        tvAnimationSplash.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(A0_AccueilActivity.this, A31_Splash_Animation.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void clicSimpson(){
        tvAnimationSplash.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A31_Splash_Animation.class);
                startActivity(intent);
            }
        });
    }

    private void clicTableLayout(){

    }


    /******* Cycles de vie de l'app *******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a0_accueil);
        initUI();

        // Clic sur les boutons
        clicLinear();
        clicFrame();
        clicRelative();
//        clicSplash();
    }
}
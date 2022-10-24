package com.dam.snippets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dam.snippets.a1_layout_xml.A11_LinearLayoutXml;
import com.dam.snippets.a1_layout_xml.A12_FrameLayoutXml;
import com.dam.snippets.a1_layout_xml.A13_RelativeLayoutXml;
import com.dam.snippets.a1_layout_xml.A14_TableLayoutXml;
import com.dam.snippets.a1_layout_xml.A15_ConstraintLayoutXml;
import com.dam.snippets.a3_animation.A31_Splash_Animation;
import com.dam.snippets.a3_animation.A32_Simpson_Animation;
import com.dam.snippets.a4_media.A41_AudioAuto;
import com.dam.snippets.a4_media.A42_Video;

public class A0_AccueilActivity extends AppCompatActivity {

    /** Var globales **/
    // Les layouts xml
    TextView tvLinearLayout, tvFrameLayout, tvRelativeLayout, tvTableLayout, tvConstraintLayout;

    // Les animations
    TextView tvAnimationSplash, tvAnimationSimpson;

    // Les médias
    TextView tvMediaAudio, tvMediaVideo;

    /******* Méthodes  Perso *******/
    /** Méthode pour l'initialisation des composants **/
    private void initUI(){
        // Layout Xml
        tvLinearLayout = findViewById(R.id.tvLinearLayout);
        tvFrameLayout = findViewById(R.id.tvFrameLayout);
        tvRelativeLayout = findViewById(R.id.tvRelativeLayout);
        tvTableLayout = findViewById(R.id.tvTableLayout);
        tvConstraintLayout = findViewById(R.id.tvConstraintLayout);

        // Animation
        tvAnimationSplash = findViewById(R.id.tvAnimationSplash);
        tvAnimationSimpson = findViewById(R.id.tvAnimationSimpson);

        // Les médias
        tvMediaAudio = findViewById(R.id.tvMediaAudio);
        tvMediaVideo = findViewById(R.id.tvMediaVideo);
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

    private void clicTableLayout(){
        tvTableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A0_AccueilActivity.this, A14_TableLayoutXml.class);
                startActivity(intent);
            }
        });
    }

    private void clicConstraintLayout(){
        tvConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A0_AccueilActivity.this, A15_ConstraintLayoutXml.class);
                startActivity(intent);
            }
        });
    }

    // Animations
    private void clicSplash(){
        tvAnimationSplash.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A31_Splash_Animation.class);
                startActivity(intent);
            }
        });
    }

    private void clicSimpson(){
        tvAnimationSimpson.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A32_Simpson_Animation.class);
                startActivity(intent);
            }
        });
    }

    // Les médias
    private void clicAudio(){
        tvMediaAudio.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A41_AudioAuto.class);
                startActivity(intent);
            }
        });

    }

    private void clicVideo() {
        tvMediaVideo.setOnClickListener(new View.OnClickListener() { // Gestion du clic avec le listener
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(A0_AccueilActivity.this, A42_Video.class);
                startActivity(intent);
            }
        });
    }

    /******* Cycles de vie de l'app *******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a0_accueil);
        initUI();

        // Gestion du clic sur les boutons
        // Les Layout XML
        clicLinear();
        clicFrame();
        clicRelative();
        clicTableLayout();
        clicConstraintLayout();

        // Les Animations
        clicSplash();
        clicSimpson();

        // Les Médias
        clicAudio();
        clicVideo();
    }
}
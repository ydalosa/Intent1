package com.dam.snippets.a1_layout_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dam.snippets.R;

public class A11_LinearLayoutXml extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a11_linear_layout_xml);

        // Méthode 1 avec un listener sur le bouton
        Button btnLinearVertical;
        btnLinearVertical = findViewById(R.id.btnLinearVertical);
        btnLinearVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // LE code pour l'action
                Intent intent = new Intent(A11_LinearLayoutXml.this, A11_1_LinearLayoutVerticalXml.class);
                startActivity(intent);
            }
        });
        // END méthode 1
    }
    // Méthode 2 avec l'appel de la méthode onClick du XML
    public void gestionDuClic(View view){
        // Attaché le widget à cette méthode avec l'attribut onClick du xml
        Intent intent = new Intent(A11_LinearLayoutXml.this, A11_1_LinearLayoutVerticalXml.class);
        startActivity(intent);
    }
}
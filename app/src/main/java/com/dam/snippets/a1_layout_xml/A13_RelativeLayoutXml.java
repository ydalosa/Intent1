package com.dam.snippets.a1_layout_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.snippets.R;

public class A13_RelativeLayoutXml extends AppCompatActivity {

    /** Méthode pour la gestion de l'affichage des Toasts lors du clic sur les textViews **/
    public void tvClic(View view) {
        // On crée une variable de type TextView qui prend comme valeur le TextView cliqué
        TextView textView_presse = (TextView) view;
        // On récupère son Tag
        String texteDuToast = textView_presse.getTag().toString();
        // On affiche le Tag dans le Toast
        Toast.makeText(this, "Vous avez cliqué sur "+ texteDuToast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a13_relative_layout_xml);
    }
}
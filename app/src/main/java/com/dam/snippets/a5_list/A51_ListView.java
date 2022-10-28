package com.dam.snippets.a5_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.dam.snippets.R;

public class A51_ListView extends AppCompatActivity {

    /**
     * Méthode 1 avec un tableau dans le Java
     **/
    private final String[] listeStagiaires = new String[]{
            "Théodore", "Fred", "Silvère", "Jacques", "Jasem", "Mostafa", "Serge", "Patrick", "Andy", "Taha"
    };

    private void affichageLIstView() {
        // Le lien entre Java et design
        ListView lvListView = findViewById(R.id.lvListView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, listeStagiaires);

        lvListView.setAdapter(adapter);

        lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String valItem = (String) lvListView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Le stagiaire : " + valItem, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a51_list_view);
        affichageLIstView();

    }
}
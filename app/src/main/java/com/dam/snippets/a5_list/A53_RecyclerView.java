package com.dam.snippets.a5_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dam.snippets.R;

public class A53_RecyclerView extends AppCompatActivity {

    RecyclerView rvRecycler;

    String[] stagiaires, descriptions;

    int[] avatars = {
      R.drawable.stagiaire_01,
      R.drawable.stagiaire_02,
      R.drawable.stagiaire_03,
      R.drawable.stagiaire_04,
      R.drawable.stagiaire_05,
      R.drawable.stagiaire_06,
      R.drawable.stagiaire_07,
      R.drawable.stagiaire_08,
      R.drawable.stagiaire_09,
      R.drawable.stagiaire_010,
      R.drawable.stagiaire_011,
      R.drawable.stagiaire_012,
      R.drawable.stagiaire_013,
      R.drawable.stagiaire_014
    };

    private void initUI(){
        rvRecycler = findViewById(R.id.rvRecycle);
        stagiaires = getResources().getStringArray(R.array.stagiaires);
        descriptions = getResources().getStringArray(R.array.descriptions);
    }

    private void remplissageRecycler(){
        A53_Adapter_Recycler adapter = new A53_Adapter_Recycler(this, stagiaires, descriptions, avatars);
        rvRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rvRecycler.setLayoutManager(layoutManager);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a53_recycler_view);

        initUI();
        remplissageRecycler();
    }
}
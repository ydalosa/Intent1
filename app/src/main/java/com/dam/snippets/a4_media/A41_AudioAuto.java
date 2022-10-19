package com.dam.snippets.a4_media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.dam.snippets.R;

public class A41_AudioAuto extends AppCompatActivity {

    // 2.1 Media play de type global pour étre utilisé dans plusieurs méthodes
    MediaPlayer mediaPlayer;

    // 2.3 La méthode Play
    public void Play(View view){
        mediaPlayer.start();
    }
    // 2.4 La méthode Pause
    public void Pause(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a41_audio_auto);

        // 1- Lancement auto de la musique / son au lancement de l'activité
//        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mp_audio_uptown_funk);
//        mediaPlayer.start();

        // 2.0 - Media player avec contrôle
        // 2.2 Valorisation du médiaController
        mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);

        // 2.5 Gestion du Volume
        SeekBar sbVolume = findViewById(R.id.sbVolume);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Definir le volume max du terminal utilisé
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setMax(volumeMax);

        // Définition du volume courant (celui qui réglé dans le terminal au lancement de l'app)
        int volumeCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setProgress(volumeCurrent);

         sbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean flag) {
                 audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
             }
             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {            }
             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {             }
         });


    }
}
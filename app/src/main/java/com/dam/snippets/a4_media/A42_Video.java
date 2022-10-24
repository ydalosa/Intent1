package com.dam.snippets.a4_media;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.VideoView;

import com.dam.snippets.R;

public class A42_Video extends AppCompatActivity {

    // Vars globales
    MediaController mediaController;
    int position;
    VideoView vvVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a42_video);
//
//        // Phase 1 lancement automatique de la vidéo
//        VideoView vvVideo = findViewById(R.id.vvVideo);
//
//        String uriPath = ("android.resource://" + getPackageName() + "/raw/" + R.raw.mp_ts_drunk);
//        Uri uri = Uri.parse(uriPath);
//        vvVideo.setVideoURI(uri);
//        vvVideo.start();

        // Phase 2 avec le mediacontroller
        vvVideo = findViewById(R.id.vvVideo);
        String uriPath = ("android.resource://" + getPackageName() + "/raw/" + R.raw.mp_ts_drunk);
        Uri uri = Uri.parse(uriPath);
        vvVideo.setVideoURI(uri);

        // Création d'un nouvel objet mediacontroller que l'on associe à la vue
        if(this.mediaController == null){
            this.mediaController = new MediaController(A42_Video.this);
        }

        mediaController.setAnchorView(vvVideo);
        vvVideo.setMediaController(mediaController);

        vvVideo.start();


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
            position = savedInstanceState.getInt("CurrentPosition");
            vvVideo.seekTo(position);
        vvVideo.start();
    }

    @Override
    protected void onPause() {
        position = vvVideo.getCurrentPosition();
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentPosition", position);
        vvVideo.pause();
    }
}
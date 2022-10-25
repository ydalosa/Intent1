package com.dam.snippets.a4_media;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dam.snippets.R;

public class A42_Video extends AppCompatActivity {

    /**
     * Cette version du player montre les différents passages dans les cycles de vies d'une application.
     * 2 choses sont à prendre en compte : la rotation et la perte de focus (la vue n'est plus visible)
     * De ce fait pour na pas perdre le fil de la vidéo, on fera appelle à la méthode seekToPositionInVideo
     * a 2 endroits :
     * - Dans la méthode onStart dans le cas ou on perd le focus
     * - Dans la méthode onRestoreInstanceState pour la rotation
     * <p>
     * De plus il est observable via le log la gesticulation des cycles de vie de l'app
     * Pour n'afficher que lescycles de vie coller ceci dans le logcat --> package:mine level:INFO tag:A42
     * <p>
     **/


    // Vars globales
    MediaController mediaController; // Le gestionnaire des contrôles
    int position; // La position dans la vidéo, valorisée en fonction de l'action
    VideoView vvVideo; // La vue VideoView
    private static final String TAG = "A42_Video"; // Le tag pour le log, obtenu avec le raccourci logt
    private Configuration newConfig;

    // Méthodes persos
    // La préparation de la VideoView
    private void initVideoView() {
        vvVideo = findViewById(R.id.vvVideo); // Définition et valorisation d'un objet de type VideoView
        String uriPath = ("android.resource://" + getPackageName() + "/raw/" + R.raw.mp_ts_drunk); // Chemin vers le fichier à lire
        // Noter qu'il est possible d'utiliser des URL (web) ie:
        //String uriPath = "https://youtu.be/HyQMW-xGzkU";
        Uri uri = Uri.parse(uriPath); // Transformation du string du chemin du fichier en URI
        vvVideo.setVideoURI(uri); // Application de l'URI à notre objet VideoView
    }

    // Phase 1 du TP : le lancement automatique
    private void phase1_AutoStartVideo() {
        initVideoView();
        vvVideo.start(); // Lancement automatique de la video au focus de l'activité
    }

    // Phase 2 ajout des contrôles sur la vidéo (Noter l'encapsulation de videoiew dans un FrameLayout pour avoir les commandes sur la vidéo)
    private void phase2_videoWithControl() {
        initVideoView();
        // Création d'un nouvel objet MediaController que l'on associe à notre vue (this)
        if (this.mediaController == null) {
            this.mediaController = new MediaController(A42_Video.this);
        }

        // Ancrages des controles à la fenêtre de la vidéo
        mediaController.setAnchorView(vvVideo);
        // Association du MediaController à la vue en question
        vvVideo.setMediaController(mediaController);
        // Ici il faut cliquer sur play pour lancer la vidéo
    }

    // Gestion de la position et "relancement de la vidéo"
    private void seekToPositionInVideo() {
        vvVideo.seekTo(position); // Jump à la position enregistrée
        vvVideo.start(); // Re lancement de la vidéo
    }

    // Gestion de l'enregistrement de la position après la mise le passage par la méthode onPuase
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentPosition", position);
        Log.i(TAG, "onSaveInstanceState: stockage de la position dans le bundle                       //  position = " + position);
        vvVideo.pause();
    }

    // Gestion de la position après rotation
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        Log.i(TAG, "onRestoreInstanceState: récupération de la position après rotation                //  position = " + position);
        seekToPositionInVideo(); // Après rotation
    }

    // Méthodes des cycles de vie
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a42_video);
        Log.i(TAG, "onCreate: lancement ou relancement de l'activité                                  //  posistion = " + position);
        // Appel des différentes phases de lecture
        // phase1_AutoStartVideo();
        phase2_videoWithControl();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Si position ≠ 0 --> Perte du focus                                       //  position = " + position);
        seekToPositionInVideo(); // Perte de Focus de l'activité (sorti ou clic sur le bouton rond)
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume:                                                                         //  position = " + position);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart:                                                                        //  position = " + position);
    }

    @Override
    protected void onPause() {
        position = vvVideo.getCurrentPosition();
        Log.i(TAG, "onPause: l'activité est mise en pause et perd le focus                            //  position = " + position);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop:                                                                           //  position = " + position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: l'activité est détruite                                                //  position = " + position);
    }
}
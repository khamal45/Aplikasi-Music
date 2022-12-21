package com.example.aplikasi_music;

import android.content.Context;
import android.media.MediaPlayer;

import org.jetbrains.annotations.NotNull;

public class music {

    public static MediaPlayer mediaPlayer;




    public static void context(Context c) {

        mediaPlayer = MediaPlayer.create(c, listmusic.music(0));
    }

    public static void start() {
        mediaPlayer.start();
    }

    public static void pause() {
        mediaPlayer.pause();
    }

    public static boolean playing() {
        return mediaPlayer.isPlaying();
    }

    public static void seek(int a) {

        mediaPlayer.seekTo((a));

    }

    public static int duration() {
        return mediaPlayer.getDuration();
    }

    public static int abc() {
        int a = mediaPlayer.getCurrentPosition();
        return a;
    }

    public static void change(int a,Context b) {

        if (a != listmusic.aktif()) {
            listmusic.setaktif(a);
            mediaPlayer.reset();
            mediaPlayer = new MediaPlayer();
            mediaPlayer = MediaPlayer.create(b, listmusic.music(listmusic.aktif()));
            mediaPlayer.start();
            listmusic.setchange(true);

        }
    }


    public static void next(int i, Context b) {
        if (listmusic.shufle){
            if (listmusic.urutan.size() == 0){
                listmusic.makeashufle();
            }
            change(listmusic.urutan.get(0),b);
        listmusic.urutan.remove(0);
        }else {
            change(i , b);
        }

        
    }
}

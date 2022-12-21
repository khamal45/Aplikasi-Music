package com.example.aplikasi_music;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listmusic {
    public static int musiclist[]={
            R.raw.beforeiforget,R.raw.duality,R.raw.psychosocial,R.raw.glassanimalsweatwaves,R.raw.dointime,R.raw.harrystylesasitwas,R.raw.imaginedragonbones,R.raw.justthetwoofus,
            R.raw.k391alanwalkeremeliehollowlily,R.raw.kenshiyonezukickback,R.raw.mrkittytheneighbourhoodafterdarkxsweaterweather,R.raw.rosalinnsnap,R.raw.ruthbdandelions,R.raw.tomodellonotherloveofficialvideo
            ,R.raw.thechainsmokerscloserfthalsey,R.raw.samsmithunholyftkimpetras
    };
    public static String album[]={
            "Vol. 3: (The Subliminal Verse","Vol. 3: (The Subliminal Verse","All Hope Is Gone","Glass Animal","Doin Time","Harry Style","Imagine Dragon","Just The Two Of Us","K391 X AlanWalker","kenshi Yonezu","Mr Kitty the Neighbourhood"
            ,"Rosa Linn","Ruth B","Tomodell","The Chainsmokers","Sam Smith"

    };
    public static String judul[]={
            "Before I Forget","Duality","Psychosocial","Heat Waves","Unknown","As It Was","Bones","Unknown","Lily","KICKBACK","After Dark X Sweaterweather","SNAP","Dandelions","Another Love","Closer","Unholy"
    };
    public static boolean change = false;

   public static int aktiv = 0;

   public static boolean shufle = false;
    public static int music(int a){


        return musiclist[a];
    }
    public static List <Integer> urutan = new ArrayList<>();
    public static void makeashufle(){

        for (int i = 0;i < album.length;i++){
           urutan.add(0 + i);
        }
        Collections.shuffle(urutan);
    }


    public static String judul(int a){
        return judul[a];
    }
    public static String album(int a){
        return album[a];
    }
    public static int aktif(){
        return aktiv;
    }
    public static void setaktif(int a) {

        if (a < musiclist.length) {
            aktiv = a;
        }  else {
            aktiv = 0;
        }
        if (a < 0) {
            aktiv = musiclist.length -1;
        }

    }


    public static boolean change(){
     return change;
    }
    public static void setchange(boolean a){

        change = a;
    }
    public static int banyak_music(){
        return musiclist.length;
    }

}

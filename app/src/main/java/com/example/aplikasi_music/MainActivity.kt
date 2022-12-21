package com.example.aplikasi_music

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.example.aplikasi_music.databinding.ActivityMainBinding
import com.example.aplikasi_music.databinding.FragmentBlank1Binding
import com.google.android.material.tabs.TabLayoutMediator





class MainActivity : AppCompatActivity() {
    private lateinit var runnable: Runnable
    private var handler = Handler()


    private lateinit var binding : ActivityMainBinding

    private lateinit var  viewPagerAdapeter: ViewPagerAdapeter


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        music.context(this)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewPagerAdapeter = ViewPagerAdapeter(supportFragmentManager,lifecycle)

        with(binding){
            idPager.adapter = viewPagerAdapeter
            TabLayoutMediator(idTablayout, idPager){
                tab,position ->
                when(position){
                    0 -> tab.text = "Music"
                    1 -> tab.text = "List"
                }
            }.attach()
            shufle.setOnClickListener {
              listmusic.shufle = !listmusic.shufle
                if (listmusic.shufle){
                    listmusic.makeashufle()
                }
            }
            playbtn.setOnClickListener {

            if (!music.playing()){
                music.start();
                playbtn.setImageResource(R.drawable.aause)
            }
                else{
                    music.pause()
                playbtn.setImageResource(R.drawable.play)
            }

            }
            binding.idnext.setOnClickListener {
                music.next(listmusic.aktif()+1,this@MainActivity)
            }
            binding.idprev.setOnClickListener {
                music.next(listmusic.aktif()-1,this@MainActivity)
            }

            with(binding){
              fastb.setOnClickListener {
                  music.mediaPlayer.seekTo(music.mediaPlayer.currentPosition -  5000)
              }
                fastf.setOnClickListener {
                    music.mediaPlayer.seekTo(music.mediaPlayer.currentPosition +  5000)
                }
                seekBar.max = music.duration()
                seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                        if (p2) {
                            music.seek(p1)

                        }

                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {

                    }
                }


                )
                1


            }








        }




        runnable = Runnable {
            music.mediaPlayer.setOnCompletionListener{
                music.next(listmusic.aktif()+1,this@MainActivity)
            }
            if(listmusic.shufle){
                binding.shufle.setImageResource(R.drawable.ic_baseline_shuffle_24)
            }
            else(
                    binding.shufle.setImageResource(R.drawable.ic_baseline_loop_24)
            )
            binding.JudulMusic.setText(listmusic.judul(listmusic.aktif()))
            binding.seekBar.progress = music.mediaPlayer.currentPosition
            binding.album1.setText(listmusic.album(listmusic.aktif()))
            if (listmusic.change() == true){
                binding.seekBar.progress = 0
                binding.seekBar.max = music.mediaPlayer.duration
                listmusic.setchange(false);
            }
            if (music.playing()){
                binding.playbtn.setImageResource(R.drawable.aause);

            }
            else{
                binding.playbtn.setImageResource(R.drawable.play);
            }

            handler.postDelayed(runnable,500)
        }
        handler.postDelayed(runnable,500)



    }


    }









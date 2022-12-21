package com.example.aplikasi_music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasi_music.databinding.FragmentBlank2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var newrecyclerview : RecyclerView
private lateinit var newarraylisy :ArrayList<data_music>
lateinit var judul : Array<String>
lateinit var album : Array<String>
private lateinit var binding2: FragmentBlank2Binding



/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var das : String = "asu"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            binding2 = FragmentBlank2Binding.inflate(layoutInflater)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding2 = FragmentBlank2Binding.inflate(inflater,container,false)
        return binding2.getRoot()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding2){
            newrecyclerview = recyleviewgg
            newrecyclerview.layoutManager =LinearLayoutManager(context)
            newrecyclerview.setHasFixedSize(true)

            newarraylisy = arrayListOf<data_music>()
            getuserdata()
        }

    }

    private fun getuserdata() {
        for (i in 0 .. listmusic.banyak_music() - 1){

                val music = data_music(listmusic.judul(i), listmusic.album(i))
                newarraylisy.add(music)

        }
        var adapeter = RecycleViewAdapter(newarraylisy)
        newrecyclerview.adapter = adapeter
        adapeter.setonclixk(object : RecycleViewAdapter.onclicllistener{
            override fun onpitez(urutan: Int) {
listmusic.makeashufle()
                music.change(urutan,context);


            }


        })
    }


}

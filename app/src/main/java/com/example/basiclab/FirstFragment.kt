package com.example.basiclab

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var bgColor: Int = Color.argb(255, 255, 255, 255)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bgColor = savedInstanceState?.getInt("backgroundColor") ?: Color.argb(255, 255, 255, 255)
        Log.d("FRAGONCRVIEW", bgColor.toString())
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        view.findViewById<Button>(R.id.button_prev_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ThirdFragment)
        }

        Log.d("FRAGCOLOR", (arguments?.getInt("backgroundColor")).toString())
        val newBGColor = arguments?.getInt("backgroundColor") ?: bgColor
        Log.d("FRAGCOLORNEW", newBGColor.toString())
        bgColor = newBGColor
        view.setBackgroundColor(bgColor)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("backgroundColor", bgColor)
        Log.d("FRAGSAVE", bgColor.toString())
        super.onSaveInstanceState(outState)
    }
}
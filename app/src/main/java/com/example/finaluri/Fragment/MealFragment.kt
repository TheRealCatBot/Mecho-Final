package com.example.finaluri.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.finaluri.*
import com.example.finaluri.Calcium

class MealFragment:Fragment(R.layout.fragment_meal) {
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button
    private lateinit var Button10: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Button1 = view.findViewById(R.id.button1)
        Button2 = view.findViewById(R.id.button2)
        Button3 = view.findViewById(R.id.button3)
        Button4 = view.findViewById(R.id.button4)
        Button5 = view.findViewById(R.id.button5)
        Button6 = view.findViewById(R.id.button6)
        Button7 = view.findViewById(R.id.button7)
        Button8 = view.findViewById(R.id.button8)
        Button9 = view.findViewById(R.id.button9)
        Button10 = view.findViewById(R.id.button10)


        Button3.setOnClickListener {
            val intent = Intent (getActivity(), C::class.java)
            getActivity()?.startActivity(intent)
        }
        Button1.setOnClickListener {
            val intent = Intent(getActivity(), A::class.java)
            getActivity()?.startActivity(intent)
        }
        Button2.setOnClickListener {
            val intent = Intent(getActivity(), B::class.java)
            getActivity()?.startActivity(intent)
        }
        Button4.setOnClickListener {
            val intent = Intent(getActivity(), D::class.java)
            getActivity()?.startActivity(intent)
        }
        Button5.setOnClickListener {
            val intent = Intent(getActivity(), E::class.java)
            getActivity()?.startActivity(intent)
        }
        Button6.setOnClickListener {
            val intent = Intent(getActivity(), Carbs::class.java)
            getActivity()?.startActivity(intent)
        }
        Button7.setOnClickListener {
            val intent = Intent(getActivity(), Proteins::class.java)
            getActivity()?.startActivity(intent)
        }
        Button8.setOnClickListener {
            val intent = Intent(getActivity(), Fats::class.java)
            getActivity()?.startActivity(intent)
        }
        Button9.setOnClickListener {
            val intent = Intent(getActivity(), Calcium::class.java)
            getActivity()?.startActivity(intent)
        }
        Button10.setOnClickListener {
            val intent = Intent(getActivity(), Iron::class.java)
            getActivity()?.startActivity(intent)
        }




    }



}
package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import androidx.fragment.app.Fragment
import com.example.finaluri.Fragment.HomeFragment
import com.example.finaluri.Fragment.LeafFragment
import com.example.finaluri.Fragment.MealFragment
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)


        val firstFragment=HomeFragment()
        val secondFragment=MealFragment()
        val thirdFragment=LeafFragment()

        setCurrentFragment(firstFragment)

        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.meal->setCurrentFragment(secondFragment)
                R.id.leaf->setCurrentFragment(thirdFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment,fragment)
            commit()
        }
}


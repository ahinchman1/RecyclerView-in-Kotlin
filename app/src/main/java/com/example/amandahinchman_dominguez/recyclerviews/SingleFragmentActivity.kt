package com.example.amandahinchman_dominguez.recyclerviews

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity() {

    private val layoutResId: Int
        @LayoutRes
        get() = R.layout.activity_fragment

    protected abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)

        // ensures fragments already created will not be created
        if (fragment == null) {
            fragment = createFragment()
            // create and commit a fragment transaction
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
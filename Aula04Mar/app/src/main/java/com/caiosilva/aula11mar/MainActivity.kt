package com.caiosilva.aula11mar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caiosilva.aula11mar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragments()
    }

    private fun showFragments() {
        var segundoFragment = SegundoFragment()
        var primeiroFragment = PrimeiroFragment.newInstance("", "", {
            segundoFragment.printString(it)
        })
        supportFragmentManager
            .beginTransaction()
            .replace(
                binding.frameLayoutPrimeiroFragment.id,
                primeiroFragment
            )
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(
                binding.frameLayoutSegundoFragment.id,
                segundoFragment
            )
            .commit()
    }
}

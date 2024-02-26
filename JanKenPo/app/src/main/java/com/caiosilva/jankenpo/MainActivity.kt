package com.caiosilva.jankenpo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val images = listOf(R.drawable.papel, R.drawable.pedra, R.drawable.tesoura)
    private val options = listOf("Papel", "Pedra", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewPapel.setOnClickListener {
            println("Clicou papel")
            checkResult(0, onOptionSelected())
        }

        binding.imageViewPedra.setOnClickListener {
            println("Clicou pedra")
            checkResult(1, onOptionSelected())
        }

        binding.imageViewTesoura.setOnClickListener {
            println("Clicou tesoura")
            checkResult(2, onOptionSelected())
        }
    }

    private fun onOptionSelected(): Int {
        val appChoice: Int = Random.nextInt(3)
        binding.imageViewApp.setImageDrawable(getDrawable(images[appChoice]))
        println(appChoice)

        return appChoice
    }

    private fun checkResult(playerChoice: Int, appChoice: Int) {
        val results = listOf(
            listOf(
                getString(R.string.draw, options[playerChoice]),
                getString(R.string.user_wins, options[playerChoice]),
                getString(R.string.user_loses, options[playerChoice])
            ),
            listOf(
                getString(R.string.user_loses, options[playerChoice]),
                getString(R.string.draw, options[playerChoice]),
                getString(R.string.user_wins, options[playerChoice])
            ),
            listOf(
                getString(R.string.user_wins, options[playerChoice]),
                getString(R.string.user_loses, options[playerChoice]),
                getString(R.string.draw, options[playerChoice])
            )
        )

        println(results[playerChoice][appChoice])
        Toast.makeText(this, results[playerChoice][appChoice], Toast.LENGTH_LONG).show()
    }

//    [0, 0], [0, 1], [0, 2]
//    [1, 0], [1, 1], [1, 2]
//    [2, 0], [2, 1], [2, 2]
//
//    (papel(papel, pedra, tesoura)),
//    (pedra(papel, pedra, tesoura)),
//    (tesoura(papel, pedra, tesoura)),
}

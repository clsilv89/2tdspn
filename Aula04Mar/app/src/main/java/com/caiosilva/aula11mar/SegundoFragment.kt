package com.caiosilva.aula11mar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.compose.ui.node.ViewAdapter
import androidx.fragment.app.Fragment
import com.caiosilva.aula11mar.databinding.FragmentSegundoBinding

class SegundoFragment : Fragment() {

    private lateinit var binding: FragmentSegundoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(inflater)

        showSpinner()

        return binding.root
    }

    private fun showSpinner() {
        val lista: List<String> = listOf(
            "Cachorro",
            "Papagaio",
            "Gato",
            "Rato",
            "Iguana",
            "Coelho",
            "Cobra",
            "Rã",
            "Pombos",
            "Tartaruga",
            "Chinchila"
        )
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            lista
        )

        binding.primeiroFragmentoSpinner.adapter = adapter
        binding.primeiroFragmentoSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    println(lista[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }

    fun printString(string: String) {
        println("Printou no segundo fragment " + string)
    }
}
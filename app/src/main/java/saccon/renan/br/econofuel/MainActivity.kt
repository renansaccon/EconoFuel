package saccon.renan.br.econofuel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import saccon.renan.br.econofuel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btBuscar1.setOnClickListener{
            btBusca1OnClick()
        }

        binding.btBuscar2.setOnClickListener{
            btBusca2OnClick()
        }

        binding.btComparar.setOnClickListener{
            btCompararOnClick()
        }

    }

    private fun btBusca1OnClick() {
        val intent = Intent(this, BuscaActivity :: class.java)
        getResultado1.launch( intent )
    }

    private val getResultado1 = registerForActivityResult( ActivityResultContracts.StartActivityForResult() ) {

        if ( it.resultCode == RESULT_OK){
            if (it.data != null){
                val retorno = it.data?.getDoubleExtra( "codRetorno" , 0.0 )
                binding.Comb1.setText ( retorno.toString())
            }
        }

    }

    private fun btBusca2OnClick() {
        val intent = Intent(this, BuscaActivity :: class.java)
        getResultado2.launch( intent )
    }

    private val getResultado2 = registerForActivityResult( ActivityResultContracts.StartActivityForResult() ) {

        if ( it.resultCode == RESULT_OK){
            if (it.data != null){
                val retorno = it.data?.getDoubleExtra( "codRetorno" , 0.0 )
                binding.Comb2.setText ( retorno.toString())
            }
        }

    }


    private fun btCompararOnClick() {
        val rendimento1 = binding.Comb1.text.toString()
        val rendimento2 = binding.Comb2.text.toString()
        val valor1 = binding.Valor1.text.toString()
        val valor2 = binding.Valor2.text.toString()

        if ( rendimento1.isEmpty() ) {
            binding.Comb1.error = getString(R.string.insira_um_valor)
            binding.Comb1.requestFocus()
            return
        } else if ( rendimento2.isEmpty() ) {
            binding.Comb2.error = getString(R.string.insira_um_valor)
            binding.Comb2.requestFocus()
            return
        } else if ( valor1.isEmpty() ) {
            binding.Valor1.error = getString(R.string.insira_um_valor)
            binding.Valor1.requestFocus()
            return
        } else if ( valor2.isEmpty() ){
            binding.Valor2.error = getString(R.string.insira_um_valor)
            binding.Valor2.requestFocus()
            return
        } else {

            val coefGas = valor1.toDouble() / rendimento1.toDouble()
            val coefEta = valor2.toDouble() / rendimento2.toDouble()

            if (coefGas < coefEta) {
                binding.tvResultado.text = getString(R.string.economia1)
            } else {
                binding.tvResultado.text = getString(R.string.economia2)
            }
        }
    }
}



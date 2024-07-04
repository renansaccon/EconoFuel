package saccon.renan.br.econofuel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import saccon.renan.br.econofuel.databinding.ActivityBuscaBinding


class BuscaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBuscaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscaBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.lvCombustiveis.setOnItemClickListener { parent, view, position, id ->
           var codSelecionado = position + 1
           if (codSelecionado == 1){
               codSelecionado = 18
               intent.putExtra( "codRetorno" , codSelecionado.toDouble() )
               setResult( RESULT_OK , intent )
               finish()
           }else {
               codSelecionado = 12
               intent.putExtra("codRetorno", codSelecionado.toDouble())
               setResult(RESULT_OK, intent)
               finish()
           }
       }
    }
}
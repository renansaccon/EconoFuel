package saccon.renan.br.econofuel

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import saccon.renan.br.econofuel.databinding.ActivityBuscaBinding
import saccon.renan.br.econofuel.databinding.ActivityMainBinding


class BuscaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBuscaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscaBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.lvCombustiveis.setOnItemClickListener { parent, view, position, id ->
           val codSelecionado = position + 1
           intent.putExtra( "codRetorno" , codSelecionado.toDouble() )
           setResult( RESULT_OK , intent )
          finish()
       }
    }
}
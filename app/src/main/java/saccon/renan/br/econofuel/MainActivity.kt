package saccon.renan.br.econofuel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import saccon.renan.br.econofuel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}
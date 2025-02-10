package com.example.ex_05

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityLoginOkBinding

class LoginOkActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginOkBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val listaAlunos = ArrayList<Aluno>()

        listaAlunos.add(Aluno("Filipa", "Famalicão", "filipa@gmail.com") )
        listaAlunos.add(Aluno("Andreia", "VNDG", "andreia@email.com"))
        listaAlunos.add(Aluno("Tiago", "Chavs", "tiago.tt@mail.com"))
        listaAlunos.add(Aluno("Rui", "Matosinhos", "rui@gmail.com") )
        listaAlunos.add(Aluno("Rúben", "Baião", "ruben@email.com"))
        listaAlunos.add(Aluno("Paula", "Familicão", "paula.textil@mail.com"))

        binding.listaAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAlunos)

        binding.listaAlunos.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(this, alunoView::class.java)
            intent.putExtra("nome", listaAlunos.get(position).nome )
            intent.putExtra("morada", listaAlunos.get(position).morada)
            intent.putExtra("email", listaAlunos.get(position).email)
            startActivity(intent)
        }

        binding.adicionarButton.setOnClickListener{
            val nomeNovo:String = binding.adicionarNome.text.toString()
            val moradaNova:String = binding.adicionarMorada.text.toString()
            val emailNovo:String = binding.adicionarEmail.text.toString()

            listaAlunos.add(Aluno(nomeNovo, moradaNova, emailNovo))

            binding.listaAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAlunos)
//            finish()
//            startActivity(getIntent())

        }

    }
}
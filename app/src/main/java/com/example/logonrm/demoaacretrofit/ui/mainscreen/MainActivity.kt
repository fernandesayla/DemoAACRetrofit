package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.logonrm.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        btPesquisar.setOnClickListener {
            mainViewModel.pesquisarEndereco(etCep.text.toString())
        }

        mainViewModel.apiResponse.observe(this, Observer {
            apiRespose ->
            if(apiRespose?.erro == null){
                val end = apiRespose?.endereco
                tvResultado.text =
                        "Logradouro: ${end?.logradouro} \n"+
                                "Complemento: ${end?.complemento} \n"+
                                "Bairro: ${end?.bairro} \n"+
                                "Localidade: ${end?.localidade} \n"+
                                "UF: ${end?.uf} \n"+
                Log.i("TAG", "Sucesso!")

            } else{
                Log.i("TAG", "ERRO: ${apiRespose.erro}")
            }
        })
    }
}

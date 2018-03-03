package com.example.logonrm.demoaacretrofit.entities


data class Endereco (val cep: String, val logradouro: String, val complemento : String, val bairro: String,
                     val localidade: String, val uf: String)

/**
 * Created by logonrm on 03/03/2018.
 * {
cep: "03042-001",
logradouro: "Rua Piratininga",
complemento: "lado ímpar",
bairro: "Brás",
localidade: "São Paulo",
uf: "SP",
unidade: "",
ibge: "3550308",
gia: "1004"
}
https://viacep.com.br/ws/03042001/json/
 */


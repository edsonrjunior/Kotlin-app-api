package br.com.fiap.kotlinwebflux

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PessoaRepository : ReactiveMongoRepository<Pessoa, String>{


}
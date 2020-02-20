package br.com.fiap.kotlinwebflux

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class PessoaServiceImpl constructor(
        private val repository: PessoaRepository)
    : PessoaService{


    override fun save(pessoaDTO: PessoaDTO): Mono<PessoaDTO>  = Mono.just(pessoaDTO)
            .map { Pessoa(nome = it.nome ?: "sem nome") }
            .flatMap { repository.save(it) }
            .delayElement(Duration.ofSeconds(1))
            .map { PessoaDTO(nome = it.nome) }

    override fun findAll(): Flux<PessoaDTO> = repository.findAll()
            .map { PessoaDTO(nome = it.nome) }
            .delayElements(Duration.ofSeconds(1))

}

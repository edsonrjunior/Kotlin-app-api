package br.com.fiap.kotlinwebflux

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("pessoas")
class PessoaController constructor(
        private val service: PessoaService
){
    @GetMapping(produces =
    [MediaType.APPLICATION_STREAM_JSON_VALUE])

    fun findAll(): Flux<PessoaDTO> = service.findAll()
    @PostMapping

    fun create(@RequestBody PessoaDTO: PessoaDTO):
            Mono<PessoaDTO> = service.save(PessoaDTO)
}
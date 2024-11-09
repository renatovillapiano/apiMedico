package md.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import md.voll.api.clinica.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clinica")
public class ClinicaController {

    @Autowired
    private ClinicaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroClinica dados){
        repository.save(new Clinica(dados));
    }

    @GetMapping
    public Page<DadosListagemClinica> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return  repository.findAllByAtivoTrue(paginacao).map(DadosListagemClinica::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoClinica dados){

        var clinica = repository.getReferenceById(dados.id());
        clinica.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var clinica = repository.getReferenceById(id);
        clinica.excluir();
    }

}

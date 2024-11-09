package md.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import md.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {



}

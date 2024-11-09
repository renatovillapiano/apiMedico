package md.voll.api.clinica;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoClinica(
        @NotNull
        Long id,
        String nome,
        String cidade,
        Boolean ativo
) {

}

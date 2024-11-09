package md.voll.api.clinica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroClinica(

        @NotBlank
        String nome,

        @NotBlank
        String cidade,

        @NotNull
        Boolean ativo
) {
}

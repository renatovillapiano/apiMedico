package md.voll.api.medico;

import jakarta.validation.constraints.NotNull;

public record DadosApagarMedico(

        @NotNull
        Long id
)
{


}

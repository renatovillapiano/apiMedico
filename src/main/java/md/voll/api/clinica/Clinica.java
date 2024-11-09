package md.voll.api.clinica;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="clinica")
@Entity(name="Clinica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotNull
    private Boolean ativo;

    public Clinica(DadosCadastroClinica dados){
        this.nome = dados.nome();
        this.cidade = dados.cidade();
        this.ativo = dados.ativo();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoClinica dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.ativo() != null){
            this.ativo = dados.ativo();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

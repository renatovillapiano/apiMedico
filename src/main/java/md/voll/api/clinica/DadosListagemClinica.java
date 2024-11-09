package md.voll.api.clinica;

public record DadosListagemClinica(
        Long id,
        String nome,
        String cidade

){

    public DadosListagemClinica(Clinica clinica){
        this(clinica.getId(), clinica.getNome(), clinica.getCidade());
    }

}



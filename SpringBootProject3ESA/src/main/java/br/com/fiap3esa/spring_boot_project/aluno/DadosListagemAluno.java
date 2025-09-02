package br.com.fiap3esa.spring_boot_project.aluno;

public record DadosListagemAluno(
        String nome,
        String email,
        String cpf,
        String telefone) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getTelefone());
    }
}

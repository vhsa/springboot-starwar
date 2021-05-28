package br.com.startwars.dtos;

public class PersonagemResponse {

    private String nome;

    public PersonagemResponse(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

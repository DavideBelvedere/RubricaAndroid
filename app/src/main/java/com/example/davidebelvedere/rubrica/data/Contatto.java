package com.example.davidebelvedere.rubrica.data;

/**
 * Created by davidebelvedere on 15/02/18.
 */

public class Contatto {
    private String nome;
    private String telefono;

    public Contatto(String nome, String telefono) {
        this.nome = nome;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

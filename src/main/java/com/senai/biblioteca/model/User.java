package com.senai.biblioteca.model;

public class User{

    private long id;
    private String nome;
    private String email;

    public User(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    public User(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
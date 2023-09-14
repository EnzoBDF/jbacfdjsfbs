package com.example.cadastroveiculos.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
public class Livro {
    @Id
    private String placa;
    private String modelo;
    private int ano;
    private String cor;


    @ManyToOne
    private Genero fabricante;


    @ManyToOne
    private Autor categoria;
}

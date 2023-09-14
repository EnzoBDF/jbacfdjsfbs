package com.example.cadastroveiculos.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
public class Livro {
    @Id
    private long isbn;
    private String nome;
    private String tipo;
    private String cor;
 


    @ManyToOne
    private Genero fabricante;


    @ManyToOne
    private Autor categoria;
}

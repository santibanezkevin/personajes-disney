package com.alkemy.personajes.personajes.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter
@Setter

public class personajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private int edad;

    private double peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes",cascade = CascadeType.ALL)
    private List<peliculaEntity> peliculas = new ArrayList<>();
}

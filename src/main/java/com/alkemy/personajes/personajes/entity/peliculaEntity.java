package com.alkemy.personajes.personajes.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Getter
@Setter

public class peliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaCreacion;

    private int puntuacion;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id",insertable = false,updatable = false)
    private generoEntity genero;

    @Column(name = "continente_id",nullable = false)
    private Long generoId;

    @ManyToMany(
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<personajeEntity> personajes = new HashSet<>();

}

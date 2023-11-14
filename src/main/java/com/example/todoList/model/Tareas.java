
package com.example.todoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Nico Morales
 */
@Getter
@Setter
@Entity
public class Tareas {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String descripcion;

    public Tareas(Long Id, String titulo, String descripcion) {
        this.Id = Id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Tareas() {
    }

}
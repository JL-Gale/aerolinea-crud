package com.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Pasajero implements Serializable {

    @Id
    private Integer asiento;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Integer edad;
    private Integer numeroDoc;
    private Integer numeroTel;

    public Pasajero() {
    }

    public Pasajero(Integer asiento, String nombre, String apellido, String nacionalidad, Integer edad, Integer numeroDoc, Integer numeroTel) {
        this.asiento = asiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.numeroDoc = numeroDoc;
        this.numeroTel = numeroTel;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(Integer numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Integer getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(Integer numeroTel) {
        this.numeroTel = numeroTel;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "asiento=" + asiento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                ", numeroDoc=" + numeroDoc +
                ", numeroTel=" + numeroTel +
                '}';
    }
}

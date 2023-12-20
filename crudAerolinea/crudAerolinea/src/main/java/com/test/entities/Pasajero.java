package com.test.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Pasajero implements Serializable {

    @Id
    private Integer asiento;

    @Column(length = 25)
    private String nombres;

    @Column(length = 25)
    private String apellido;

    @Column(length = 30)
    private String nacionalaidad;

    private Integer edad;

    @Column(name = "numero_tel")
    private Integer numeroTel;

    @Column(name = "numero_doc")
    private Integer numeroDoc;

    public Pasajero() {
    }

    public Pasajero(Integer asiento, String nombres, String apellido, String nacionalaidad, Integer edad, Integer numeroTel, Integer numeroDoc) {
        this.asiento = asiento;
        this.nombres = nombres;
        this.apellido = apellido;
        this.nacionalaidad = nacionalaidad;
        this.edad = edad;
        this.numeroTel = numeroTel;
        this.numeroDoc = numeroDoc;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalaidad() {
        return nacionalaidad;
    }

    public void setNacionalaidad(String nacionalaidad) {
        this.nacionalaidad = nacionalaidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(Integer numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Integer getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(Integer numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "asiento=" + asiento +
                ", nombres='" + nombres + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalaidad='" + nacionalaidad + '\'' +
                ", edad=" + edad +
                ", numeroTel=" + numeroTel +
                ", numeroDoc=" + numeroDoc +
                '}';
    }
}

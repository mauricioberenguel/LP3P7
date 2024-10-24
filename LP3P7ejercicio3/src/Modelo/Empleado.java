package Modelo;

import java.io.Serializable;

public class Empleado implements Serializable {
    private int numero;
    private String nombre;
    private double sueldo;

    // Constructor
    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    // Método toString para mostrar los detalles del empleado
    @Override
    public String toString() {
        return "Empleado{" +
                "Número=" + numero +
                ", Nombre='" + nombre + '\'' +
                ", Sueldo=" + sueldo +
                '}';
    }
}
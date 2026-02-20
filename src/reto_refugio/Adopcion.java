/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_refugio;

/**
 *
 * @author s.ortega
 */
public class Adopcion {
    private Persona persona;
    private Animal animal;
    private LocalDate fecha;

    public Adopcion(Persona persona, Animal animal, LocalDate fecha) {
        this.persona = persona;
        this.animal = animal;
        this.fecha = fecha;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
    
}

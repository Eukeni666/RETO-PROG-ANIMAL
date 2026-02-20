/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_refugio;

/**
 *
 * @author s.ortega
 */
public class Adoptante extends Persona{
    private Adopcion[] adopcion;

    public Adoptante(Adopcion[] adopcion, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.adopcion = adopcion;
    }
    
    public void elige(Animal a)
    {
        //Posteriormente se añadirá
    }
}

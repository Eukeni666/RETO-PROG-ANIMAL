/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_refugio;

import java.time.LocalDate;

/**
 *
 * @author s.ortega
 */
public class Adoptante extends Persona{
    private Adopcion[] adopcion;
    private int num;

    public Adoptante(Adopcion[] adopcion, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.adopcion = adopcion;
        num = 0;
    }
    
    public void elige(Animal a, Administrativo admin)
    {
        admin.registrar(this);
        a.setFechaBaja(LocalDate.now());
        adopcion[num++] = new Adopcion(this, a, LocalDate.now()); 
    }
}

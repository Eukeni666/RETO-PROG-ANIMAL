/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_refugio;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author s.ortega
 */
public class Adoptante extends Persona{
    private ArrayList<Adopcion> adopcion;

    public Adoptante(String nombre, String apellidos) {
        super(nombre, apellidos);
        this.adopcion = new ArrayList<Adopcion>();
    }
    
    public void elige(Animal a, Administrativo admin)
    {
        admin.registrar(this);
        a.setFechaBaja(LocalDate.now());
        adopcion.add(new Adopcion(this, a, LocalDate.now())); 
    }
}

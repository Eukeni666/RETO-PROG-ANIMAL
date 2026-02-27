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
public class Administrativo extends Empleado{
    private Adoptante[] adoptantes;

    public Administrativo(Adoptante[] adoptantes, String nombre, String apellido, LocalDate alta, float salario) {
        super(nombre, apellido, alta, salario);
        this.adoptantes = adoptantes;
    }
    
    public void anotar()
    {
        //Especificar metodo
    }
}

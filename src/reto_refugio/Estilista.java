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
public class Estilista extends Empleado{
    
    public Estilista(LocalDate alta, String nombre, String apellidos, float salario) {
        super(nombre, apellidos, alta, salario);
    }
    
    public void tratar(Animal animal)
    {
        //falta que el animal puedad ser tratado
    }
}

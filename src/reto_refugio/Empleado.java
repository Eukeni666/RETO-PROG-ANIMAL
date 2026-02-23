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
public class Empleado {
    
    // añadir los filtros que se deseen
    public enum Filtro {ESPECIE, FECHA_ALTA;}
    private Filtro filtro;

    private LocalDate alta;
    private float salario;
    
    public Empleado(LocalDate alta, float salario) {
        this.alta = alta;
        this.salario = salario;
    }

    public void setAlta(LocalDate alta) {
        this.alta = alta;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getAlta() {
        return alta;
    }

    public float getSalario() {
        return salario;
    }
    
    public Filtro getFiltro (){
        return filtro;
    }
    
    private void listarAnimales(Animal[] animal, Filtro filtro, String text)
    {
        //hacer aqui el metodo
    }
    
    private void listarAnimales(Animal[] animal, Filtro filtro, boolean depende)
    {
        //hacer aqui el metodo
    }
}

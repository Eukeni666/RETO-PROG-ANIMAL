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
public class Empleado extends Persona{
    
    // añadir los filtros que se deseen
    public enum Filtro {ESPECIE, FECHA_ALTA;}
    private Filtro filtro;

    private LocalDate alta;
    private float salario;
    protected boolean vigente;
    protected String horario;
    
    public Empleado(String nombre, String apellidos, LocalDate alta, float salario) {
        super(nombre, apellidos);
        this.alta = alta;
        this.salario = salario;
        this.vigente = true;
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
        if(filtro.equals("ESPECIE"))
        {
            int length = animal.length;
            int num = 0;
            for(int i = 0; i < length; i++)
            {
                if(animal[i].getEspecie() == text)
                {
                    System.out.println(++num + "º animal compatible:");
                    System.out.print("Nombre: " + animal[i].getNombre());
                    if(animal[i].isSexo())
                        System.out.println("(Macho)");
                    else
                        System.out.println("(Hembra)");
                    System.out.println("Personalidad: " + animal[i].getPersonalidad());
                    System.out.println("Alimentación: " + animal[i].getAlimentacionTipo() + " cada " + animal[i].getAlimentacionPeriodicidad());
                }
            }
        }
        else
        {
            //
        }
    }
    
    private void listarAnimales(Animal[] animal, Filtro filtro, boolean depende)
    {
        //hacer aqui el metodo
    }
}

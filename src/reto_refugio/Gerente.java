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
public class Gerente extends Cuidador{
    private ArrayList<Animal> animalesTot;

    public Gerente(ArrayList<Animal> animalesTot, ArrayList<Animal> animales, String nombre, String apellidos, LocalDate alta, float salario) {
        super(animales, nombre, apellidos, alta, salario);
        this.animalesTot = animalesTot;
    }

    public ArrayList<Animal> getAnimalesTot() {
        return animalesTot;
    }

    public void setAnimalesTot(ArrayList<Animal> animalesTot) {
        this.animalesTot = animalesTot;
    }
    
    public boolean entrevista(Adoptante adoptante)
    {
        // Comprobar que es apto
        return false;
    }
    
    public void asignaAnimal(int animal, Cuidador cuidador)
    {
        animalesTot.get(animal).setCuidador(cuidador);
        cuidador.setAnimales(animalesTot.get(animal));
    }
    
    public Empleado contratar(Persona pers, LocalDate alta, float salario)
    {
        Empleado emp = new Empleado(pers.getNombre(), pers.getApellidos(), alta, salario);
        emp.horario = "Horario no especificado";
        return emp;
    }
    
    public Empleado contratar(String nombre, String apellidos, LocalDate alta, float salario)
    {
        return new Empleado(nombre, apellidos, alta, salario);
    }
    
    public void despedir(Empleado empleado)
    {
        if(empleado != this)
        empleado.vigente = false;
    }
    
    public void modSalario(Empleado empleado, float salario)
    {
        empleado.setSalario(salario);
    }
    
    public void setHorario(Empleado empleado, String horario)
    {
        empleado.horario = horario;
    }
    
    public void seguimiento()
    {
        // Para discutir, puede ser eliminado
    }
}

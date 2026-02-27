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
public class Gerente extends Cuidador{
    private Animal[] animalesTot;

    public Gerente(Animal[] animalesTot, Animal[] animales, String nombre, String apellidos, LocalDate alta, float salario) {
        super(animales, nombre, apellidos, alta, salario);
        this.animalesTot = animalesTot;
    }

    public Animal[] getAnimalesTot() {
        return animalesTot;
    }

    public void setAnimalesTot(Animal[] animalesTot) {
        this.animalesTot = animalesTot;
    }
    
    public boolean entrevista(Adoptante adoptante)
    {
        // Comprobar que es apto
        return false;
    }
    
    public void asignaAnimal(int animal, Cuidador cuidador)
    {
        animalesTot[animal].setCuidador(cuidador);
        Animal[] nuevos = new Animal[cuidador.getAnimales().length + 1];
        System.arraycopy(cuidador.getAnimales(), 0, nuevos, 0, nuevos.length);
        nuevos[nuevos.length - 1] = animalesTot[animal];
        cuidador.setAnimales(nuevos);
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
        // Para discutir
    }
}

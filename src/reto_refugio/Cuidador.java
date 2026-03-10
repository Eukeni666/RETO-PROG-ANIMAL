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
public class Cuidador extends Empleado{
    private ArrayList<Animal> animales;

    public Cuidador(ArrayList<Animal> animales, String nombre, String apellidos, LocalDate alta, float salario) {
        super(nombre, apellidos, alta, salario);
        this.animales = animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    public void setAnimales(Animal animal) {
        this.animales.add(animal);
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public Animal getAnimales(int i) {
        return animales.get(i);
    }
    
    public void alimentar(int cual)
    {
        if(cual < animales.size() && cual >= 0)
            animales.get(cual).comer();
    }
    
    public void revisarSalud(int cual, String revision)
    {
        if(cual < animales.size() && cual >= 0)
        animales.get(cual).pasarRevision(revision);
    }
    
    public void tratamiento(int cual)
    {
        if(cual < animales.size() && cual >= 0)
        animales.get(cual).setSalud(10);
    }
    
    public void curar(int cual)
    {
        if(cual < animales.size() && cual >= 0)
        animales.get(cual).setSalud(2);
    }
    
    public void cuidar(int cual)
    {
        //¿Que es cuidar para nosostros?
    }
    
    public void limpiar(int cual)
    {
        if(cual < animales.size() && cual >= 0)
        animales.get(cual).setHigiene(10);
    }
    
    public Animal entregar(int cual)
    {
        if(cual < animales.size() && cual >= 0)
        return animales.get(cual);
        return null;
    }
    
    public void documentar(Administrativo admin, String reporte)
    {
        admin.addReporte(reporte);
    }
}

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
public class Cuidador extends Empleado{
    private Animal[] animales;

    public Cuidador(Animal[] animales, String nombre, String apellidos, LocalDate alta, float salario) {
        super(nombre, apellidos, alta, salario);
        this.animales = animales;
    }

    public Animal[] getAnimales() {
        return animales;
    }

    public void setAnimales(Animal[] animales) {
        this.animales = animales;
    }
    
    public void alimentar(int cual)
    {
        if(cual < animales.length && cual >= 0)
            animales[cual].comer();
    }
    
    public void revisarSalud(int cual, String revision)
    {
        animales[cual].hacerRevision(revision);
    }
    
    public void tratamiento(int cual)
    {
        animales[cual].setSalud(10);
    }
    
    public void curar(int cual)
    {
        animales[cual].setSalud(2);
    }
    
    public void cuidar(int cual)
    {
        //¿Que es cuidar para nosostros?
    }
    
    public void limpiar(int cual)
    {
        animales[cual].setHigiene(10);
    }
    
    public Animal entregar(int cual)
    {
        return animales[cual];
    }
    
    public void documentar(Administrativo admin, String reporte)
    {
        admin.addReporte(reporte);
    }
}

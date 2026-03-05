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
public class Administrativo extends Empleado{
    private ArrayList<Adoptante> adoptantes;
    private ArrayList<String> reportes;

    public Administrativo(String nombre, String apellido, LocalDate alta, float salario) {
        super(nombre, apellido, alta, salario);
        this.adoptantes = new ArrayList<Adoptante>();
        this.reportes = new ArrayList<String>();
    }
    
    public void addReporte(String reporte)
    {
        reportes.add(reporte);
    }
    
    public void registrar(Adoptante ado)
    {
        for(Adoptante a:adoptantes)
        {
            if(a.getDNI().equalsIgnoreCase(ado.getDNI()))
                return;
        }
        adoptantes.add(ado);
    }
}

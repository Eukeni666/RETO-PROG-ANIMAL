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
    private String[] reportes;
    private int num;
    private int amount;

    public Administrativo(Adoptante[] adoptantes, String nombre, String apellido, LocalDate alta, float salario) {
        super(nombre, apellido, alta, salario);
        this.adoptantes = adoptantes;
        this.reportes = new String[1000];
        num = 0;
        amount = 0;
    }
    
    public void addReporte(String reporte)
    {
        if(reportes.length > num)
            reportes[num++] = reporte;
    }
    
    public void registrar(Adoptante ado)
    {
        if(amount >= adoptantes.length)
            return;
        for(int i = 0; i < amount; i++)
        {
            if(adoptantes[i].getNombre().equalsIgnoreCase(ado.getNombre()))
                return;
        }
        adoptantes[amount++] = ado;
    }
}

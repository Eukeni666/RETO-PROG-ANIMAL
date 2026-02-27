/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_refugio;

import java.time.LocalDate;

/**
 *
 * @author e.fresco
 */
public class Reptil extends Animal {
    private final int MIN_TEMPERATURA = 10;
    private final int MAX_TEMPERATURA = 28;
    
    private boolean temperaturaOptima; // entre 10 y 28 es su temperatura óptima
    
    public Reptil (String especie, LocalDate fechaAlta, boolean sexo){
        super (especie, fechaAlta, sexo);
    }

    
    /* Se pasa por parámetro la temperatura externa y devuelve si es o no un
    rango aceptable para los reptiles , y cuánto hay que ajustarla, en su caso*/
    public boolean getTemperaturaOptima (int i){
        if (i>= MIN_TEMPERATURA && i <= MAX_TEMPERATURA){
            return true;
        } else if (i < MIN_TEMPERATURA){
            System.out.println("Es necesario aumentar la temperatura entre "
                    + (MIN_TEMPERATURA - i) + " y " + (MAX_TEMPERATURA - i) + ""
                            + "grados");
            return false;
        } else {
            System.out.println("Es necesario reducir la temperatura entre " 
                    + (i - MAX_TEMPERATURA) + " y " + (i - MIN_TEMPERATURA) + 
                    "grados");
            return false;
        }
    }
    
  
}

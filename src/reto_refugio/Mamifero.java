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
public class Mamifero extends Animal {
    private boolean presentable;
    
    public Mamifero (String especie, LocalDate fechaAlta, boolean sexo){
        super (especie, fechaAlta, sexo);
    }
}

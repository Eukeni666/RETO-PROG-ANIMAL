/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto_refugio;

import java.time.LocalDate;
import java.util.Random;

/**
 * Clase que representa a un reptil.
 * Se simula la influencia de la temperatura ambiente en su fisiología definiendo
 * un rango óptimo de temperatura para el animal y un atributo que sería la 
 * temperatura ambiente, que se simula aleatoriamente. 
 * La razón de que la temperatura esté en esta clase es que la temperatura solo 
 * es relevante para los reptiles. Por tanto con ello se consigue que cada clase 
 * maneje los datos que son relevantes para ella.
 * @author e.fresco
 */
public class Reptil extends Animal {
    
    static Random rand = new Random ();
    /* simulación de la temperatura ambiente */
    static final int temperatura = rand.nextInt(-5, 30);
    /* simulación del rango de temperaturas aceptable para los reptiles */
    private final int MIN_TEMPERATURA = 10;
    private final int MAX_TEMPERATURA = 28;
    
    private boolean temperaturaOptima; 
    
    public Reptil (String especie, LocalDate fechaAlta, boolean sexo, int salud, int higiene){
        super (especie, fechaAlta, sexo, salud, higiene);
    }
    
    public static int getTemperatura (){
        return temperatura;
    }
    
    /**
     * Se pasa por parámetro la temperatura externa y devuelve si está o no en 
     * un rango aceptable para los reptiles, y cuánto hay que ajustarla, en su 
     * caso */
    public boolean getTemperaturaOptima (int temperatura){
        if (temperatura>= MIN_TEMPERATURA && temperatura <= MAX_TEMPERATURA){
            System.out.println("Temperatura: " + temperatura + " grados. CORRECTA");
            return true;
        } else if (temperatura < MIN_TEMPERATURA){
            System.out.print("\n\t Temperatura " + temperatura + " ES NECESARIO "
                    + "AUMENTAR LA TEMPERATURA: +" + 
                    (MIN_TEMPERATURA - temperatura) + "/+" + 
                    (MAX_TEMPERATURA - temperatura) + " grados");
            return false;
        } else {
            System.out.print("\n\t Temperatura: " + temperatura + " ES NECESARIO"
                    + " REDUCIR LA TEMPERATURA: -" 
                    + (temperatura - MAX_TEMPERATURA) + "/-" + 
                    (temperatura - MIN_TEMPERATURA) + "grados");
            return false;
        }
    }
    
  
}

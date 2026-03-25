package reto_refugio;

import java.time.LocalDate;
import java.util.Random;

/**
 * Superclase que representa a los mamíferos del refugio
 * Debido a que tienen pelaje, se define un atributo booleano presentable
 * @author e.fresco
 */
public class Mamifero extends Animal {
    
    static Random rand = new Random ();
    
    private boolean presentable;
    
    public Mamifero (String especie, LocalDate fechaAlta, boolean sexo, int salud, int higiene){
        super (especie, fechaAlta, sexo, salud, higiene);
        presentable = rand.nextBoolean();
    }
    
    public boolean isPresentable (){
        return this.presentable;
    }
    
    public void setPresentable (boolean b){
        presentable = b;
    }
}

package reto_refugio;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author e.fresco
 */
public class Mamifero extends Animal {
    
    static Random rand = new Random ();
    
    private boolean presentable;
    
    public Mamifero (String especie, LocalDate fechaAlta, boolean sexo){
        super (especie, fechaAlta, sexo);
        presentable = rand.nextBoolean();
    }
    
    public boolean isPresentable (){
        return this.presentable;
    }
    
    public void setPresentable (boolean b){
        presentable = b;
    }
}

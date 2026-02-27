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
    
    public boolean isPresentable (){
        return this.presentable;
    }
    
    public void setPresentable (boolean b){
        presentable = b;
    }
}

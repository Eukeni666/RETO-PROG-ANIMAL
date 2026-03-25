package reto_refugio;

import java.time.LocalDate;

/**
 *Añado cualquier texto para ver lo que ocurre
 * @author e.fresco
 */
public class Ave extends Animal {
    private boolean vuela;
    
    public Ave (String especie, LocalDate fechaAlta, boolean sexo, boolean vuela, int salud, int higiene){
        super (especie, fechaAlta, sexo, salud, higiene);
        this.vuela = vuela;
    }
    
    public void ponerHuevos () {
        
    }
}

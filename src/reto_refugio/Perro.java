package reto_refugio;

import java.time.LocalDate;

/**
 *
 * @author e.fresco
 */
public class Perro extends Mamifero {
    private String tamanno; // P, M, G (pequeño, mediano, grande)
    
    public Perro (LocalDate fechaAlta, boolean sexo, int salud, int higiene) {
        super ("perro", fechaAlta, sexo, salud, higiene);
    }
    
    public String getTamanno (){
        return tamanno;
    }
    
    public void setTamanno (String s){
        tamanno = s;
    }
}

package reto_refugio;

import java.time.LocalDate;

/**
 *
 * @author e.fresco
 */
public class Perro extends Mamifero {
    private String tamanno; // P, M, G (pequeño, mediano, grande)
    
    public Perro (LocalDate fechaAlta, boolean sexo) {
        super ("perro", fechaAlta, sexo);
    }
}

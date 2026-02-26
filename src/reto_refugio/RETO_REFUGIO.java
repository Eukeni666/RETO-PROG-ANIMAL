package reto_refugio;

import java.time.LocalDate;

/**
 *
 * @author e.fresco
 */
public class RETO_REFUGIO {
    
    private static LocalDate fecha;
    static final int MAX_ANIMALES = 60;
    
    /* Array donde se incluyen todos los animales al crearlos */
    static Animal [] animales = new Animal [MAX_ANIMALES];
    static int contadorAnimales;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Método para hacer pruebas */
        inicioAnimal ();
        
    }
    
    /* Método para hacer pruebas */
    public static void inicioAnimal (){
        
        contadorAnimales = 0;
        
        Perro p = new Perro (fecha.now(), false);
        Perro p2 = new Perro (fecha.now().minusWeeks(3), true);
        
        System.out.println(p);
        System.out.println(p2);
        System.out.println("\nNº de animales: " + contadorAnimales);
        for (int i = 0; i < contadorAnimales; i++) {
            System.out.println("");
            System.out.println("ANIMAL " + (i+1) + ":"
                    + "\nESPECIE: " + animales [i].getEspecie() +
                    "\nFECHA DE ALTA: " + animales [i].getFechaAlta());
        }
    }
    
}

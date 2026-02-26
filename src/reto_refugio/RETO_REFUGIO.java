package reto_refugio;

import java.util.Scanner;

/**
 *
 * @author e.fresco
 */
public class RETO_REFUGIO {

    static Scanner scan;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opc = scan.nextInt ();
        
        System.out.println("REFUGIO DE ANIMALES");
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("Seleccione opción:");
        System.out.println("(1) Gestión de ANIMALES");
        System.out.println("(2) Gestión DIARIA");
        System.out.println("(3) Gestión de ADOPCIONES");
        System.out.println("(4) Gestión de EMPLEADOS");
        
        switch (opc){
            case 1: 
                System.out.println("MENÚ DE GESTIÓN DE ANIMALES");
                System.out.println("(1) Dar de alta");
                System.out.println("(2) Dar de baja");
                System.out.println("(3) Mostrar estado");
                System.out.println("(4) Dar animal en adopción");
                System.out.println("(5) Asignar cuidador");
                System.out.println("(6) Revisión médica");
                
                opc = scan.nextInt();
                switch (opc) {
                    case 1: 
                        break;
                    case 2: 
                        break;
                    case 3: 
                        break;
                    case 4: 
                        break;
                    case 5: 
                        break;
                    case 6: 
                        break;
                }
                
                break;
            case 2: System.out.println("MENÚ DE GESTIÓN DIARIA");
                System.out.println("(1) Comprobar estado de animales");
                System.out.println("(2) Alimentar animales");
                System.out.println("(3) Limpiar");
                System.out.println("(4) Documentar");
                System.out.println("(5) Revisar comida disponible");
                break;
            case 3: System.out.println("MENÚ DE GESTIÓN DE ADOPCIONES");
                System.out.println("(1) Revisar solicitud");
                System.out.println("(2) Hacer seguimiento de adopción");
                break;
            case 4: System.out.println("MENÚ DE GESTIÓN DE EMPLEADOS");
                System.out.println("(1) Dar de alta");
                System.out.println("(2) Dar de baja");
                System.out.println("(3) Aumentar salario");
                System.out.println("(4) Asignar horario");
                break;
        }
    
    }
}

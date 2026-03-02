package reto_refugio;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author e.fresco
 */
public class RETO_REFUGIO {
    
    static Scanner scan = new Scanner (System.in);
    static LocalDate fecha;
    static final int MAX_ANIMALES = 60;
    
    /* Array donde se incluyen todos los animales al crearlos */
    //static Animal [] animales = new Animal [MAX_ANIMALES];
    static ArrayList <Animal> animales = new ArrayList <>();
    
    public static void main(String[] args) {
        /* Método para hacer pruebas */
        inicioAnimal ();
        
        boolean salir = false;
        do {
            /**
             * *****************************************
             * ************ MENÚ PRINCIPAL *************
             * *****************************************
             */
            System.out.println("*******************");
            System.out.println("REFUGIO DE ANIMALES");
            System.out.println("*******************");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("Seleccione opción:");
            System.out.println("(1) Gestión de ANIMALES");
            System.out.println("(2) Gestión DIARIA");
            System.out.println("(3) Gestión de ADOPCIONES");
            System.out.println("(4) Gestión de EMPLEADOS");

            int opc = opc(4);
            switch (opc) {
                case 1:
                    System.out.println("[1] MENÚ DE GESTIÓN DE ANIMALES");
                    System.out.println("(1) Dar de alta");
                    System.out.println("(2) Dar de baja");
                    System.out.println("(3) Mostrar estado");
                    System.out.println("(4) Dar animal en adopción");
                    System.out.println("(5) Asignar cuidador");
                    System.out.println("(6) Revisión médica");

                    opc(6);
                    switch (opc) {
                        case 1:
                            System.out.println("ALTA DE ANIMAL.");
                            altaAnimal();
                            break;
                        case 2:
                            System.out.println("BAJA DE ANIMAL.");
                            animales.remove(getIdAnimal());
                            break;
                        case 3:
                            System.out.println("MOSTRAR ESTADO DE ANIMAL");
                            System.out.println(animales.get(getIdAnimal()));
                            break;
                        case 4:
                            System.out.println("ENTREGAR EN ADOPCIÓN");
                            break;
                        case 5:
                            System.out.println("ASIGNAR CUIDADOR");
                            break;
                        case 6:
                            System.out.println("REVISIÓN MÉDICA");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("[2] MENÚ DE GESTIÓN DIARIA");
                    System.out.println("(1) Comprobar estado de animales");
                    System.out.println("(2) Alimentar animales");
                    System.out.println("(3) Limpiar animales y espacios");
                    System.out.println("(4) Documentar actividad");
                    System.out.println("(5) Revisar comida disponible");

                    opc(5);
                    switch (opc) {
                        case 1:
                            System.out.println("ESTADO DE LOS ANIMALES");
                            break;
                        case 2:
                            System.out.println("ALIMENTAR ANIMALES");
                            break;
                        case 3:
                            System.out.println("LIMPIAR ANIMALES Y ESPACIOS");
                            break;
                        case 4:
                            System.out.println("DOCUMENTAR ACTIVIDAD");
                            break;
                        case 5:
                            System.out.println("REVISAR COMIDA DISPONIBLE");
                            break;
                    }

                    break;

                case 3:
                    System.out.println("[3] MENÚ DE GESTIÓN DE ADOPCIONES");
                    System.out.println("(1) Revisar solicitud");
                    System.out.println("(2) Hacer seguimiento de adopción");

                    opc(2);
                    switch (opc) {
                        case 1:
                            System.out.println("REVISAR SOLICITUD DE ADOPCIÓN");
                            break;
                        case 2:
                            System.out.println("SEGUIMIENTO DE ADOPCIÓN");
                            break;
                    }

                    break;

                case 4:
                    System.out.println("[4] MENÚ DE GESTIÓN DE EMPLEADOS");
                    System.out.println("(1) Dar de alta");
                    System.out.println("(2) Dar de baja");
                    System.out.println("(3) Aumentar salario");
                    System.out.println("(4) Asignar horario");

                    opc(4);
                    switch (opc) {
                        case 1:
                            System.out.println("ALTA DE EMPLEADO");
                            break;
                        case 2:
                            System.out.println("BAJA DE EMPLEADO");
                            break;
                        case 3:
                            System.out.println("AUMENTAR SALARIO");
                            break;
                        case 4:
                            System.out.println("ASIGNAR HORARIO");
                            break;
                    }

                    break;
            }
            System.out.println("(0) Salir (1) Continuar");
                opc = scan.nextInt();
                scan.nextLine();
                if (opc == 0) {
                    salir = true;
                }
            
        } while (!salir);
        
        
        
    }
    
    /* Método para hacer pruebas */
    public static void inicioAnimal (){
                
        Perro p = new Perro (fecha.now(), false);
        Perro p2 = new Perro (fecha.now().minusWeeks(3), true);
        Mamifero m1 = new Mamifero ("gato", fecha.now(), false);
        Mamifero m2 = new Mamifero ("hamster", fecha.now().minusDays(37), false);
        Ave a1 = new Ave ("pelícano", fecha.now().minusMonths(3), true, true);
        Reptil r1 = new Reptil ("iguana", fecha.now().minusYears(2), true);
        
        System.out.println(p);
        System.out.println(p2);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(a1);
        System.out.println(r1);
        
        int size = animales.size();
        System.out.println("\n Nº de animales: " + animales.size());
        for (int i = 0; i < size; i++) {
            System.out.println("");
            System.out.println("ANIMAL " + (i+1) + ":"
                    + "\nESPECIE: " + animales.get(i).getEspecie() +
                    "\nFECHA DE ALTA: " + animales.get(i).getFechaAlta());
        }
    }
    
    public static int opc (int i){
        int opc = scan.nextInt();
        scan.nextLine ();
        while (opc < 1 || opc > i){
            System.out.println("Opción no válida."
                    + "\nIntroduzca un número entre 1 y " + i);
            opc = scan.nextInt();
            scan.nextLine ();
        }
        return opc;
    }

    public static void altaAnimal() {
        /* Asegurarse de que no se ha llegado a la capacidad máxima del refugio */
        if (animales.size() < MAX_ANIMALES){
            System.out.println("(1) Perro"
                    + "\n(2) Gato"
                    + "\n(3) Otro mamífero"
                    + "\n(4) Ave"
                    + "\n(5) Reptil");
            
            int opc = opc (5);
            boolean sexo = sexo ();
            String especie = "";
            
            switch (opc){
                case 1: new Perro (fecha.now(), sexo);
                    break;
                case 2: new Mamifero ("gato", fecha.now(), sexo);
                    break;
                case 3:
                    especie = especie ();
                    new Mamifero (especie, fecha.now(), sexo);
                    break;
                case 4: especie = especie ();
                    boolean vuela = vuela ();
                    new Ave (especie, fecha.now(), sexo, vuela);
                    break;
                case 5: especie = especie ();
                    new Reptil (especie, fecha.now(), sexo);
                    break;
            }
        }
    }

    public static boolean sexo() {
        System.out.println("Sexo: (1) Macho (2) Hembra");
        int opc = opc (2);
        if (opc == 1){
            return true;
        } else {
            return false;
        }
    }

    public static String especie() {
        System.out.println("Especie: ");
        String especie = scan.nextLine();
        return especie;
    }

    public static boolean vuela() {
        System.out.println("(1) Voladora (2) No voladora");
        int opc = opc (2);
        if (opc == 1){
            return true;
        } else {
            return false;
        }
    }

    /* Devuelve la id del animal. Este método se utiliza en las búsquedas para
    identificar a los animales */
    public static int getIdAnimal (){
        System.out.println("Id del animal: ");
        int id = scan.nextInt();
        scan.nextLine();
        return id;
    }
    

}

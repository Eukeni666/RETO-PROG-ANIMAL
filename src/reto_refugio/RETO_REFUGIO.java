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
    static final int MAX_RACIONES = 1000; // capacidad de almacenamieento
    static int racionesDisponibles = opc (MAX_RACIONES);

    
    /* Array donde se incluyen todos los animales al crearlos */
    //static Animal [] animales = new Animal [MAX_ANIMALES];
    static ArrayList <Animal> animales = new ArrayList <>();
    static ArrayList <Adoptante> adoptantes = new ArrayList <>();
    static ArrayList <Empleado> empleados = new ArrayList <>();
    
    public static void main(String[] args) {
        /* Método para hacer pruebas */
        
        Gerente boss = new Gerente(animales, animales, "Pepe", "Giménez", fecha.now(), 12000);
        empleados.add(boss);
        empleados.add(new Administrativo("Joaquin", "Romero", fecha.now(), 1500));
        inicioAnimal ();
        
        boolean salir = false;
        do {
            /* Declaración de variables que se utilizan en los menús */
            int opc;
            int id;
            Animal animal;
            
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

            opc = opc(4);
            switch (opc) {
                case 1:
                    System.out.println("[1] MENÚ DE GESTIÓN DE ANIMALES");
                    System.out.println("(1) Dar de alta");
                    System.out.println("(2) Dar de baja");
                    System.out.println("(3) Mostrar estado");
                    System.out.println("(4) Dar animal en adopción");
                    System.out.println("(5) Asignar cuidador");
                    System.out.println("(6) Revisión médica");
                    System.out.println("(7) Mostrar historial médico");

                    opc = opc(7);
                    switch (opc) {
                        case 1:
                            System.out.println("ALTA DE ANIMAL.");
                            altaAnimal();
                            break;
                        case 2:
                            System.out.println("BAJA DE ANIMAL.");
                            id = getIdAnimal();
                            bajaAnimal (id);
                            break;
                        case 3:
                            System.out.println("MOSTRAR ESTADO DE ANIMAL");
                            id = getIdAnimal();
                            System.out.println(animales.get(id));
                            break;
                        case 4: // INCOMPLETO
                            System.out.println("ENTREGAR EN ADOPCIÓN");
                            id = getIdAnimal();
                            animal = animales.get(id);
                            // ENTREGAR EN ADOPCIÓN
                            break;
                        case 5: // INCOMPLETO
                            System.out.println("ASIGNAR CUIDADOR");
                            id = getIdAnimal();
                            animal = animales.get(id);
                            // ASIGNAR EL CUIDADOR
                            break;
                        case 6:
                            System.out.println("REVISIÓN MÉDICA");
                            id = getIdAnimal();
                            revisionMedica (id);
                            break;
                        case 7:
                            System.out.println("MOSTRAR HISTORIAL MÉDICO");
                            id = getIdAnimal();
                            mostrarHistorial (id);
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

                    opc = opc(5);
                    switch (opc) {
                        case 1:
                            System.out.println("ESTADO DE LOS ANIMALES");
                            estadoAnimales ();
                            break;
                        case 2:
                            System.out.println("ALIMENTAR ANIMALES");
                            alimentarAnimales ();
                            break;
                        case 3:
                            System.out.println("LIMPIAR ANIMALES Y ESPACIOS");
                            limpiar ();
                            break;
                        case 4:
                            System.out.println("DOCUMENTAR ACTIVIDAD");
                            break;
                        case 5:
                            System.out.println("REVISAR COMIDA DISPONIBLE");
                            revisarComidaDisponible ();
                            break;
                    }
                    break;

                case 3:
                    System.out.println("[3] MENÚ DE GESTIÓN DE ADOPCIONES");
                    System.out.println("(1) Revisar solicitud");
                    System.out.println("(2) Hacer seguimiento de adopción");

                    opc = opc(2);
                    switch (opc) {
                        case 1:
                            System.out.println("REVISAR SOLICITUD DE ADOPCIÓN");
                            adopcion ();
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

                    opc = opc(4);
                    switch (opc) {
                        case 1:
                            String name;
                            String surnames;
                            float salary;
                            System.out.println("Introduce el nombre del nuevo empleado");
                            name = scan.nextLine();
                            System.out.println("Introduce los apellidos del nuevo empleado");
                            surnames = scan.nextLine();
                            System.out.println("Introduce el salario del nuevo empleado");
                            salary = scan.nextFloat();
                            empleados.add(boss.contratar(name, surnames, fecha, salary));
                            break;
                        case 2:
                            System.out.println("¿Cual empleado deseas despedir?");
                            int cual = opc(empleados.size());
                            boss.despedir(empleados.get(--cual));
                            break;
                        case 3:
                            System.out.println("¿Cual empleado deseas aumentarle el salario?");
                            cual = opc(empleados.size());
                            System.out.println("¿De cuanto deseas sea el salario?");
                            salary = scan.nextFloat();
                            boss.modSalario(empleados.get(--cual), salary);
                            break;
                        case 4:
                            System.out.println("¿Cual empleado deseas cambiarle el horario?");
                            cual = opc(empleados.size());
                            System.out.println("Introduce como quieres que sea su horario");
                            name = scan.nextLine();
                            boss.setHorario(empleados.get(--cual), name);
                            break;
                    }

                    break;
            }
            System.out.println("\n(0) Salir (1) Continuar");
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
    
    /* Método para facilitar la entrada de números */
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

    public static void bajaAnimal(int id) {
        if (id <= animales.size()) {
            animales.remove(id);
        } else {
            System.out.println("Id inexistente");
        }
    }

    public static void revisionMedica(int id) {
        System.out.println("Fecha: ");
        String fecha = scan.next();
        System.out.println("Notas: ");
        String notas = scan.next();
        String revision = fecha + ". " + notas;
        animales.get(id).pasarRevision(revision);
    }

    public static void mostrarHistorial(int id) {
        Animal animal = animales.get(id);
        int nRev = animal.getRevisiones().size();
        if (nRev != 0) {
            for (int i = 0; i < nRev; i++) {
                System.out.println((i + 1) + "- "
                        + animal.getRevisiones().get(i));
            }
        } else {
            System.out.println("No constan revisiones con esa ID");
        }

    }

    public static void estadoAnimales() {
        for (int i = 0; i < animales.size(); i++) {
            Animal a = animales.get(i);
            System.out.print("\nID. " + a.getId() + ". " + a.getEspecie().toUpperCase()
                    + "\t Salud: " + a.getSalud() + "\t HIGIENE: "
                    + a.getHigiene());
            if (a instanceof Mamifero){
                Mamifero m = (Mamifero)a;
                System.out.print("\t Pelaje: ");
                //boolean pelaje = ((Mamifero) a).isPresentable(); // NETBEANS
                boolean pelaje = m.isPresentable();
                if (pelaje){
                    System.out.print("Buen estado");
                } else {
                    System.out.print("Mal estado");
                }
            }
            if (a instanceof Reptil){
                Reptil r = (Reptil)a;
                int temperatura = r.getTemperatura ();
                boolean tOptima = r.getTemperaturaOptima(temperatura);
            }
        }
        System.out.println("");
    }

    public static void alimentarAnimales() {
        for (Animal a : animales){
            a.comer();
        }
    }

    public static void revisarComidaDisponible() {
        int size = animales.size();
        float comidas = racionesDisponibles / size;
        System.out.println("Hay " + comidas + " comidas disponibles");
        
        if (comidas < 3){
            System.out.println("Comprar comida. Introducir cantidad: ");
            int i = scan.nextInt();
            scan.nextLine();
            comprarComida(i);
            comidas = racionesDisponibles / size;
            System.out.println("Hay " + comidas + " comidas disponibles");
        }            
    }
    
    /**
     * Al comprar comida se incrementan las raciones disponibles en el valor
     * del parámetro
     * @param: cantidad de raciones que se compran
     */
    public static void comprarComida (int i){
        racionesDisponibles += i;
    }

    public static void adopcion() {
        String nombre = solicitarDatos ("Nombre del solicitante: ");
        String apellidos = solicitarDatos ("Apellidos: ");
        String dni = solicitarDatos ("DNI: ");
        String direccion = solicitarDatos ("Dirección: ");
        String tfno = solicitarDatos ("Tfno: ");
                
        int id = getIdAnimal ();
        Animal animal = animales.get(id); 
               
        boolean aceptada = evaluarAdopcion ();
        if (aceptada){
            System.out.println("Adopción aprobada");
            animal.setHigiene (10);
            if (animal instanceof Mamifero){
                Mamifero m = (Mamifero)animal;
                m.setPresentable(true);
            }
            
            Administrativo admin;
            for (Empleado e: empleados){
                if (e instanceof Administrativo){
                    admin = (Administrativo)e;
                    
                    for (Adoptante adop : adoptantes){
                        if (adop.getDNI().equalsIgnoreCase(dni)) {
                            adop.elige(animal, admin);
                        } else {
                            Adoptante x = new Adoptante(nombre, apellidos, dni);
                            x.elige(animal, admin);
                        }
                    }                    
                } else {
                    System.out.println("Administrativo no disponible");
                }
            }

            System.out.println("\n******************");
            System.out.println("FICHA DE ADOPCIÓN: ");
            System.out.println("******************");
            System.out.println("ANIMAL:");
            System.out.println(animal);
            System.out.println("ADOPTANTE: " + apellidos + ", " + nombre
                    + "\n DIRECCION: " + direccion + "\t TFNO: " + tfno);
            System.out.println("*******************");
            animales.remove(animal);

        } else {
            System.out.println("Adopción no aprobada");
        }
    }

    public static String solicitarDatos (String s) {
        String txt = "";
        System.out.println(s);
        txt = scan.nextLine();
        return txt;
    }
    
    public static boolean evaluarAdopcion (){
        int n;
        do {
            System.out.println("¿Se aprueba la adopción?"
                + "\n (1)SÍ (2)NO");
            n = scan.nextInt ();
            scan.nextLine ();
        } while (! (n == 1 || n == 0));
        if (n == 1){
            return true;
        } else {
            return false;
        }
    }

    private static void limpiar() {
        for (Animal a : animales){
            a.setHigiene(10);
            if (a instanceof Mamifero){
                Mamifero m = (Mamifero)a;
                m.setPresentable(true);
            }
        }
    }
    

}

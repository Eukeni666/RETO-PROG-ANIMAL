package reto_refugio;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que representa un centro de acogida de animales.
 * Tiene unas capacidades máximas en cuanto al número de animales y al almacenamiento
 * de comida, que se revisan al dar de alta animales y al alimentarlos.
 * El objetivo del centro es dar a los animales en adopción, para lo cual se les
 * hacen revisiones médicas y les mantiene en condiciones higiénicas adecuadas.
 * Cuando hay una solicitud de adopción el responsable del centro realiza una
 * entrevista con el candidato a adoptante y se evalua su idoneidad. Si la adopción
 * se aprueba, se realiza una última revisión del animal, se hace una ficha de
 * adopción, se entrega al animal y el adoptante se añade al registro de adoptantes.
 * 
 * @author Eugenio Fresco, Javier Ortega, Pablo Alvarez
 */
public class RETO_REFUGIO {
    
    static Scanner scan = new Scanner (System.in);
    static LocalDate fecha;
    static Random rand = new Random ();
    
    /* Capacidad máxima de acogida de animales */
    static final int MAX_ANIMALES = 60;
    /* Capacidad máxima de almacenamiento de comida */
    static final int MAX_RACIONES = 1000;
    /* Comida disponible en la apertura del programa (con cierta aleatoriedad)*/
    static int racionesDisponibles = MAX_RACIONES - (rand.nextInt(100, MAX_RACIONES));
    
    /* Listas de actores de la aplicación */
    static ArrayList <Animal> animales = new ArrayList <>();
    static ArrayList <Adoptante> adoptantes = new ArrayList <>();
    static ArrayList <Empleado> empleados = new ArrayList <>();
    
    public static void main(String[] args) {
        
        Gerente boss = new Gerente(animales, animales, "Pepe", "Giménez", fecha.now(), 12000);
        empleados.add(boss);
        empleados.add(new Administrativo("Joaquin", "Romero", fecha.now(), 1500));
        
        /* Introducción de algunos animales*/
        inicio ();
        
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
    
    /* Método para introducir datos iniciales */
    public static void inicio (){
                
        Perro p = new Perro (fecha.now(), false, 5, 6);
        Perro p2 = new Perro (fecha.now().minusWeeks(3), true, 3, 8);
        Mamifero m1 = new Mamifero ("gato", fecha.now(), false, 7, 2);
        Mamifero m2 = new Mamifero ("hamster", fecha.now().minusDays(37), false, 4, 3);
        Ave a1 = new Ave ("pelícano", fecha.now().minusMonths(3), true, true, 5, 5);
        Reptil r1 = new Reptil ("iguana", fecha.now().minusYears(2), true, 5, 5);
             
//        int size = animales.size();
//        System.out.println("\n Nº de animales: " + animales.size());
//        for (int i = 0; i < size; i++) {
//            System.out.println("");
//            System.out.println("ANIMAL " + (i+1) + ":"
//                    + "\nESPECIE: " + animales.get(i).getEspecie() +
//                    "\nFECHA DE ALTA: " + animales.get(i).getFechaAlta());
//        }
    }
    
    /* Método auxiliar para elegir entre un número de opciones que se pasa por
    parámetro */
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

    /**
     * Dar de alta un animal.
     * Se verifica que no se ha llegado a la capacidad máxima del centro y
     * se introducen los datos del animal.
     */
    public static void altaAnimal() {
        if (animales.size() < MAX_ANIMALES){
            System.out.println("(1) Perro"
                    + "\n(2) Gato"
                    + "\n(3) Otro mamífero"
                    + "\n(4) Ave"
                    + "\n(5) Reptil");
            
            int opc = opc (5);
            boolean sexo = sexo ();
            System.out.println("Salud (0-10): ");
            int salud = opc (10);
            System.out.println("Higiene (0-10): ");
            int higiene = opc (10);
            String especie = "";
            
            switch (opc){
                case 1: new Perro (fecha.now(), sexo, salud, higiene);
                    break;
                case 2: new Mamifero ("gato", fecha.now(), sexo, salud, higiene);
                    break;
                case 3:
                    especie = especie ();
                    new Mamifero (especie, fecha.now(), sexo, salud, higiene);
                    break;
                case 4: especie = especie ();
                    boolean vuela = vuela ();
                    new Ave (especie, fecha.now(), sexo, vuela, salud, higiene);
                    break;
                case 5: especie = especie ();
                    new Reptil (especie, fecha.now(), sexo, salud, higiene);
                    break;
            }
        }
    }

    /* Método auxiliar para introducir el sexo del animal */
    public static boolean sexo() {
        System.out.println("Sexo: (1) Macho (2) Hembra");
        int opc = opc (2);
        if (opc == 1){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método auxiliar para introducir la especie.
     * Debido a que al centro llegan más perros y gatos, estos tienen su propia 
     * opción en el menú principal
     */
    public static String especie() {
        System.out.println("Especie: ");
        String especie = scan.nextLine();
        return especie;
    }

    /** 
     * Método auxiliar para introducir si un ave es voladora o no 
     * Podría servir para determinar si se la ubica en una jaula o en otro tipo
     * de espacio.
     */
    public static boolean vuela() {
        System.out.println("(1) Voladora (2) No voladora");
        int opc = opc (2);
        if (opc == 1){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para introducir la id del animal. Este método se utiliza en las 
     * búsquedas para identificar a los animales, y comprueba que el animal
     * efectivamente existe.
    */
    public static int getIdAnimal (){
        System.out.println("Id del animal: ");
        boolean existe = false;
        int id;
        do {
            id = scan.nextInt ();
            if (id >= 0 && id < animales.size()) {
                existe = true;
            } 
        } while (!existe);
        scan.nextLine();
        return id;
    }

    /**
     * Método para dar de baja un animal.
     * Se verifica que el animal existe, aunque no es necesario, puesto que la
     * id viene del método getIdAnimal (), que ya la valida
     */
    public static void bajaAnimal(int id) {
        if (id <= animales.size()) {
            animales.remove(id);
        } else {
            System.out.println("Id inexistente");
        }
    }

    /**
     * Método que representa la revisión médica de un animal, cuya id se pasa 
     * por parámetro.
     * La revisión se añade al historial médico del animal a través de su método 
     * hacerRevision.
     * @param id 
     */
    public static void revisionMedica(int id) {
        System.out.println("Fecha: ");
        String fecha = scan.next();
        System.out.println("Notas: ");
        String notas = scan.next();
        String revision = fecha + ". " + notas;
        animales.get(id).hacerRevision(revision);
    }

    /**
     * Método que muestra el historial de revisiones médicas de un animal que se
     * pasa por parámetro, si es que las hay. Si no, se muestra un aviso.
     * @param id 
     */
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

    /**
     * Muestra los datos y el estado de los animales, incluyendo el pelaje y el
     * estado estético de los mamíferos, y si la temperatura está dentro del 
     * rango aceptable para los reptiles (junto con los ajustes que serían
     * necesarios, en su caso, si no fuera así).
     */
    public static void estadoAnimales() {
        for (int i = 0; i < animales.size(); i++) {
            Animal a = animales.get(i);
            System.out.print("\nID. " + a.getId() + ". " + a.getEspecie().toUpperCase()
                    + "\t SALUD: " + a.getSalud() + "\t HIGIENE: "
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

    /* Método para alimentar a los animales */
    public static void alimentarAnimales() {
        for (Animal a : animales){
            a.comer();
        }
    }

    /**
     * Método para consultar la comida disponible, expresada en términos del
     * número de veces que se podría alimentar a todos los animales.
     * Para ello se divide el número de raciones disponibles entre el número de 
     * animales.
     * Si quedan menos de 3 comidas, se avisa de que hay que comprar comida y se
     * llama al método comprarComida () indicando la cantidad que se compra.
     * Esta cantidad se añade a la cantidad total de comida disponible.
     */
    public static void revisarComidaDisponible() {
        int size = animales.size();
        float comidas = racionesDisponibles / size;
        System.out.println("Hay " + comidas + " comidas disponibles");
        
        if (comidas < 3){
            System.out.println("Comprar comida. Introducir cantidad: ");
            int i = scan.nextInt();
            scan.nextLine();
            comprarComida(i);
//            rd = Animal.getRacionesDisponibles();
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

    /**
     * Método que representa el proceso de adopción.
     * Se solicitan los datos del candidato y la id del animal. La solicitud
     * se evalúa y, si es aprobada, se siguen los siguientes pasos:
     * - el animal es lavado y, si es mamífero, puesto en un estado estético
     * adecuado (atributo presentable)
     * - el administrativo verifica si el adoptante ya está registrado, y, si no 
     * es así, le registra como nuevo adoptante.
     * - se imprime una ficha de adopción con los datos tanto del animal como
     * del adoptante
     * - finalmente, elimina el animal de la lista de animales del refugio.
     */
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

    /* Método auxiliar para introducir cadenas de caracteres*/
    public static String solicitarDatos (String s) {
        String txt = "";
        System.out.println(s);
        txt = scan.nextLine();
        return txt;
    }
    
    /**
     * Método booleano que representa si se aprueba o no una adopción. 
     */
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

    /**
     * Método que representa el proceso de limpieza de animales y espacios.
     * El estado de higiene de los animales se pone a 10, y en el caso de los
     * mamíferos, su atributo presentable a true
     */
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

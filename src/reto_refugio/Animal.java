package reto_refugio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * @author e.fresco
 */
public class Animal {
    
    static Random rand = new Random ();
    
    static final int MAX_RACIONES = 1000; // capacidad de almacenamieento
    static int racionesDisponibles = 40/2; // el almacén está por la mitad
        
    /* Sirve para inicializar el campo id, y sigue aumentando aunque haya
    bajas de animales, de tal manera que ninguna id se repite */
    static int contadorId = 0; // sigue aumentando aunque haya bajas
    
    private int id;
    private String especie;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja; // adopción o muerte
    private String personalidad;
    private String espacio; // ¿debería ser int? ¿cuál es su función?
    private String alimentacionTipo;
    private String alimentacionPeriodicidad;
    private int salud; // de 1 a 10, 0 muerte
    private int higiene; // de 0 a 10, el cuidador lo pone al valor que sea al limpiar ()
    private boolean sexo; // 0 hembra, 1 macho
    private Cuidador cuidador;
    private ArrayList <String> revisiones;
    private String nombre;
    
   
    // ¿inicializar atributos con null?
    public Animal (String especie, LocalDate fechaAlta, boolean sexo){
        id = contadorId;
        contadorId ++;
        this.especie = especie;
        this.fechaAlta = fechaAlta;
        fechaBaja = null;
        personalidad = "";
        espacio = "";
        alimentacionTipo = "";
        alimentacionPeriodicidad = "";
        salud = rand.nextInt(1, 11);
        higiene = rand.nextInt(11);
        this.sexo = sexo;
        cuidador = null;
        revisiones = new ArrayList <String> ();
        RETO_REFUGIO.animales.add (this);
    }

    /* GETTERS */
    public int getId (){
        return id;
    }
    public String getEspecie() {
        return especie;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public String getPersonalidad() {
        return personalidad;
    }
    public String getEspacio() {
        return espacio;
    }
    public String getAlimentacionTipo() {
        return alimentacionTipo;
    }
    public String getAlimentacionPeriodicidad() {
        return alimentacionPeriodicidad;
    }
    public int getSalud() {
        return salud;
    }
    public int getHigiene() {
        return higiene;
    }
    public boolean isSexo() {
        return sexo;
    }
    public Cuidador getCuidador() {
        return cuidador;
    }
    public ArrayList <String> getRevisiones() {
        return revisiones;
    }
    public static int getRacionesDisponibles (){
        return racionesDisponibles;
    }
    
    public String getNombre (){
        return nombre;
    }

    /* SETTERS */
    // no pongo setId porque se asigna en el constructor y no es modificable
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    // tal vez sí convenga poder establecerla
//    public void setFechaAlta(LocalDate fechaAlta) {
//        this.fechaAlta = fechaAlta;
//    }
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }
    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }
    public void setAlimentacionTipo(String alimentacionTipo) {
        this.alimentacionTipo = alimentacionTipo;
    }
    public void setAlimentacionPeriodicidad(String alimentacionPeriodicidad) {
        this.alimentacionPeriodicidad = alimentacionPeriodicidad;
    }
    /* el método curar () llamaría a este para INCREMENTAR el valor de salud. 
    O sea, es += en lugar de un setter real*/
    public void setSalud(int salud) {
        this.salud += salud;
    }
    /* el método cuidar, limpiar o equivalente de Cuidador llama a este y pasa
    por parámetro el valor (NO se incrementa, ES el valor)*/
    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Al comprar comida se incrementan las raciones disponibles en el valor
     * del parámetro
     * @param: cantidad de raciones que se compran
     */
    public static void comprarComida (int i){
        racionesDisponibles += i;
    }
    
    public void hacerRevision (String s){
        revisiones.add(s);
    }

    /* OTROS MÉTODOS */
    /* Comer afecta a la higiene */
    public void comer() {
        boolean hay = racionesDisponibles > 0;
        if (hay) {
            racionesDisponibles--;
            higiene--;
        } else {
            System.out.println("No hay comida");
            salud --;
        }
    }
    
    public void enfermar () {
        salud -= 2;
    }
    
    public void morir (){
        // desaparece del array de animales
        // ¿? hay una plaza más
    }
    
    public void printProvisional (){
        System.out.println(especie + ". Fecha alta: " + fechaAlta + ". Salud: " + salud +
                racionesDisponibles);
    }
    
    @Override
    public String toString (){
        String txt = "\n ID: " + id + "\t ESPECIE: "+ especie.toLowerCase() + ""
                + "\n FECHA DE ALTA: " + fechaAlta +
                "\t SEXO: ";
        if (sexo){
            txt += "Macho";
        } else {
            txt += "Hembra";
        }
        txt += "\n SALUD: " + salud + ""
                + "\t HIGIENE: " + higiene +
//                "\n CUIDADOR " + cuidador.getNombre () +
                "\n REVISIONES: ";
        
        if (revisiones.size() == 0){
            txt += "NO";
        } else {
            for (int i = 0; i < revisiones.size(); i++) {
                txt += "\n- " + (i+1) + ". " + revisiones.get(i);
            }
        }
        return txt;
    }
    
}

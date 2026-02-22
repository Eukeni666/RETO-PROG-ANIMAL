package reto_refugio;

import java.time.LocalDate;
import java.util.Random;


/**
 * 
 * @author e.fresco
 */
public class Animal {
    
    static Random rand = new Random ();
    
    static final int MAX_REVISIONES = 50;
    static final int MAX_RACIONES = 1000; 
    
    static int racionesDisponibles = MAX_RACIONES;
    
    
    private String especie;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja; // adopción o muerte
    private String personalidad;
    private String espacio; // ¿debería ser int? ¿cuál es su función?
    private String alimentacionTipo;
    private String alimentacionPeriodicidad;
    // private boolean salud;
    private int salud; // de 1 a 10, 0 muerte
    // private boolean higiene
    private int higiene; // de 0 a 10, el cuidador lo pone al valor que sea al limpiar ()
    private boolean sexo; // 0 hembra, 1 macho
    private Cuidador cuidador;
    private String [] revisiones;
    private int contadorRevisiones;
    
    public Animal (){
        
    }
    
    public Animal (String especie, LocalDate fechaAlta, boolean sexo){
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
        cuidador = "No asignado";
        revisiones = new String [MAX_REVISIONES];
        contadorRevisiones = 0;
    }

    /* GETTERS */
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
    public String[] getRevisiones() {
        return revisiones;
    }
    public int getRacionesDisponibles (){
        return racionesDisponibles;
    }

    /* SETTERS */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
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

    /* método curar () llamaría a este. Es += en lugar de un setter real*/
    public void setSalud(int salud) {
        this.salud += salud;
    }

    /* el método cuidar, limpiar o equivalente de Cuidador llama a este y pasa
    por parámetro el valor */
    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }
    
    /**
     * Al comprar comida se incrementan las raciones disponibles
     * @param: cantidad de raciones que se compran
     */
    public void setRacionesDisponibles (int i){
        racionesDisponibles += i;
    }
    
    public void hacerRevision (String s){
        revisiones [contadorRevisiones] = s;
        contadorRevisiones ++;
    }

    /* OTROS MÉTODOS */
    /* Comer afecta a la higiene */
    public void comer (){
        racionesDisponibles --;
        higiene --;
    }
    
    public void enfermar () {
        salud -= 2;
    }
    
    public void morir (){
        // desaparece del array de animales
        // ¿? hay una plaza más
    }
    
    @Override
    public String toString (){
        String txt = "\n ESPECIE: "+ especie.toUpperCase() + ""
                + "\t FECHA DE ALTA: " + fechaAlta +
                "\nSEXO: ";
        if (sexo){
            txt += "Macho";
        } else {
            txt += "Hembra";
        }
        txt += "\t SALUD: " + salud + ""
                + "\t HIGIENE: " + higiene +
                "\n CUIDADOR " + cuidador.getNombre () +
                "\n REVISIONES: ";
        
        if (contadorRevisiones == 0){
            txt += "NO";
        } else {
            for (int i = 0; i < revisiones.length; i++) {
                txt += "\n- " + revisiones [i];
            }
        }
        return txt;
    }
    
}

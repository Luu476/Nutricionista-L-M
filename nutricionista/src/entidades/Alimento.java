
package entidades;

import java.util.List;
import java.util.ArrayList;

public class Alimento {
    
    private int codComida;
    private String nombre;
    private double caloriasPorPorcion; // por 100g
    private String tipo; // desayuno, merienda, etc.
    private String detalle; // descripción breve
    private boolean baja;
    private boolean aptoVegetariano;
    private boolean libreDeTACC;
    private boolean lacteo;

    public Alimento(int codComida, String nombre, double caloriasPorPorcion, String tipo, String detalle, boolean baja, boolean aptoVegetariano, boolean libreDeTACC, boolean lacteo) {
        this.codComida = codComida;
        this.nombre = nombre;
        this.caloriasPorPorcion = caloriasPorPorcion;
        this.tipo = tipo;
        this.detalle = detalle;
        this.baja = baja;
        this.aptoVegetariano = aptoVegetariano;
        this.libreDeTACC = libreDeTACC;
        this.lacteo = lacteo;
    }
    
    
    public int getCodComida() {
        return codComida;
    }

    public void setCodComida(int codComida) {
        this.codComida = codComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCaloriasPorPorcion() {
        return caloriasPorPorcion;
    }

    public void setCaloriasPorPorcion(double caloriasPorPorcion) {
        this.caloriasPorPorcion = caloriasPorPorcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public boolean isAptoVegetariano() {
        return aptoVegetariano;
    }

    public void setAptoVegetariano(boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
    }

    public boolean isLibreDeTACC() {
        return libreDeTACC;
    }

    public void setLibreDeTACC(boolean libreDeTACC) {
        this.libreDeTACC = libreDeTACC;
    }

    public boolean isLacteo() {
        return lacteo;
    }

    public void setLacteo(boolean lacteo) {
        this.lacteo = lacteo;
    }

    @Override
    public String toString() {
        return "Alimento{" + "codComida=" + codComida + ", nombre=" + nombre + ", caloriasPorPorcion=" + caloriasPorPorcion + ", tipo=" + tipo + ", detalle=" + detalle + ", baja=" + baja + ", aptoVegetariano=" + aptoVegetariano + ", libreDeTACC=" + libreDeTACC + ", lacteo=" + lacteo + '}';
    }
    
    
    
    /*FUNCIONES*/

    public static List<Alimento> filtrarXIngred(List<Alimento> lista, String ingredientes){
        List<Alimento> filtrados = new ArrayList<>();
        for(Alimento alimento : lista){
            if(alimento.getDetalle().toLowerCase().contains(ingredientes.toLowerCase())){
                filtrados.add(alimento);
            }
        }
        
        return filtrados;
    }

    public List<Alimento> filtrarNombre(List<Alimento> lista, String nombre){
        List<Alimento> filtrados = new ArrayList<>();
        for(Alimento alimento : lista){
            if(alimento.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                filtrados.add(alimento);
            }
        }
        return filtrados;
    }


    public static List<Alimento> filtrarXCalorias(List<Alimento> lista, double maxCalorias) {
        List<Alimento> filtrados = new ArrayList<>();
        for (Alimento alimento : lista) {
            if (alimento.getCaloriasPorPorcion() <= maxCalorias) {
                filtrados.add(alimento);
            }
        }
        return filtrados;
    }
    


}

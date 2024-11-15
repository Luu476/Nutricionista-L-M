
package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Dieta {
    
    private String codDieta;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private Paciente paciente;
    private double pesoInicial;
    private double pesoFinal;
    private ArrayList<MenuDiario> menus;
    private boolean estado;
    private String tipoDeDieta;

    public Dieta(String codDieta, String nombre, Date fechaInicio, Date fechaFin, Paciente paciente, double pesoInicial, double pesoFinal, ArrayList<MenuDiario> menus, boolean estado) {
        this.codDieta = codDieta;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.paciente = paciente;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.menus = menus;
        this.estado = estado;
    }

   

    public String getCodDieta() {
        return codDieta;
    }
     public int getCodDietaInt() {
        return  Integer.parseInt(codDieta);
    }

    public void setCodDieta(String codDieta) {
        this.codDieta = codDieta;
    }

    public String getNombre() {
        return nombre;
    }
   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }


    public ArrayList<MenuDiario> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<MenuDiario> menus) {
        this.menus = menus;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipoDeDieta() {
        return tipoDeDieta;
    }

    public void setTipoDeDieta(String tipoDeDieta) {
        this.tipoDeDieta = tipoDeDieta;
    }
    
    
    
    /*FUNCIONES*/

    public void cargarPeso(double nuevoPeso){
        this.pesoFinal = nuevoPeso;
    }

    public void imprimirDieta(){
        System.out.println("Codigo de Dieta: "+codDieta);
        System.out.println("Nombre de la Dieta: "+nombre);
        System.out.println("Paciente: "+paciente.getNombre() + paciente.getApellido());
        System.out.println("Fecha de Inicio: "+fechaInicio);
        System.out.println("Fecha de Fin: "+fechaFin);
        System.out.println("Peso Incial: "+pesoInicial);
        System.out.println("Peso Final: "+pesoFinal);
        System.out.println("Estado: "+estado);
        System.out.println("Tipo de dieta: "+tipoDeDieta);
        System.out.println("");
        System.out.println("Menus:");
        for(MenuDiario menu : menus){
            System.out.println(" - "+menu.getCodMenu()+" (Dia "+menu.getDia()+"): "+menu.getCaloriasDelMenu()+" kcal");
            
        }
    }
    
    public void addMenu(MenuDiario menu){
        this.menus.add(menu);
    }

}

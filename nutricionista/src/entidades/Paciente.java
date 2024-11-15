
package entidades;

public class Paciente {
    private int nroPaciente;
    private String nombre;
    private String apellido;
    private int edad;
    private int altura; // en metros y entero
    private String sexo;
    private float pesoActual; // en kg
    private float pesoBuscado; // en kg
    private String condicionEspecial;

    public Paciente(int nroPaciente, String nombre, String apellido, int edad, int altura, String sexo, float pesoActual, float pesoBuscado, String condicionEspecial) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.sexo = sexo;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.condicionEspecial = condicionEspecial;
    }

    public Paciente(String nombre, String apellido, int edad, int altura, String sexo, float pesoActual, float pesoBuscado, String condicionEspecial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.sexo = sexo;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.condicionEspecial = condicionEspecial;
    }
    
    
    
    

    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getCondicionEspecial() {
        return condicionEspecial;
    }

    public void setCondicionEspecial(String condicionEspecial) {
        this.condicionEspecial = condicionEspecial;
    }

    
    public float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(float pesoActual) {
        this.pesoActual = pesoActual;
    }

    public float getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(float pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    

    /*FUNCIONES*/

    public void cambiarPesoDeseado(float nuevoPesoBuscado){
        this.pesoBuscado = nuevoPesoBuscado;
    }

    public void actualizarPesoAct(float nuevoPesoAct){
        this.pesoActual = nuevoPesoAct;
    }

    public boolean seAcercaAlPeso(){
        double diferencia = Math.abs(this.pesoBuscado - this.pesoActual);
        return diferencia <= 1.0;
    }

    public void listarLosQueLlegaron(){
        /// hay que hacer el arraylist de tipo paciente para mostrar los pacientes que llegaron al peso
        System.out.println("Nombre Completo: "+nombre + apellido);
        System.out.println("Edad: "+edad);
        System.out.println("Altura: "+altura);
        System.out.println("sexo: "+sexo);
        System.out.println("Peso Actual: "+pesoActual);
        System.out.println("Peso Buscado: "+pesoBuscado);
        System.out.println("Condicion especial: "+condicionEspecial);
    }
    
}

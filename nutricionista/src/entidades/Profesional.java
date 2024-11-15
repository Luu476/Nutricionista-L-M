
package entidades;


public class Profesional {

private String nombre, apellido, correo;
private float telefono;

    public Profesional(String nombre, String apellido, String correo, float telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Profesional() {
        this.nombre = "Juanjo";
        this.apellido = "Profe";
        this.correo = "correo123@hotmail.com";
        this.telefono = 1234567;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public float getTelefono() {
        return telefono;
    }

    public void setTelefono(float telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Profesional{" + "nombre=" + nombre + '}';
    }
    
    

    
   

}

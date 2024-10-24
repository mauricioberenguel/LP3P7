// Clase Persona que representa un contacto
public class Persona {
    // Atributos de la clase Persona
    protected String nombre;
    protected String telefono;
    protected String direccion;

    // Constructor de la clase Persona
    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Método para obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // Método para obtener una representación en cadena de la persona
    public String toString() {
        return this.nombre + "\t" + this.telefono + "\t" + this.direccion + "\n";
    }
}
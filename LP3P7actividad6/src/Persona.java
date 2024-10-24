public class Persona {
    protected String nombre;
    protected String telefono;
    protected int edad;

    public Persona(String nombre, String telefono, int edad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return this.nombre + "\t" + this.telefono + "\t" + this.edad + "\n";
    }
}
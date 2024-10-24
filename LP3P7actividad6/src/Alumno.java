import java.io.Serializable;

public class Alumno extends Persona implements Serializable {
    private String nif;
    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, String telefono, int edad, Fecha fechaMatricula) {
        super(nombre, telefono, edad);
        this.nif = nif;
        this.fechaMatricula = new Fecha();
        setFechaMatricula(fechaMatricula);
    }

    public String getNif() {
        return nif;
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula.setDia(fechaMatricula.getDia());
        this.fechaMatricula.setMes(fechaMatricula.getMes());
        this.fechaMatricula.setAño(fechaMatricula.getAño());
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo = "personajes.dat"; 
    // Archivo donde se almacenarán los personajes

    // Constructor que carga los personajes desde el archivo al iniciar
    public Gestor() {
        personajes = cargarPersonajes();
    }

    // Método para añadir un nuevo personaje
    public void agregarPersonaje(Personaje p) {
        if (buscarPersonaje(p.getNombre()) == null) {
            personajes.add(p);
            guardarPersonajes();
        } else {
            System.out.println("El personaje ya existe.");
        }
    }

    // Método para buscar un personaje por nombre
    public Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // Método para eliminar un personaje por nombre
    public void eliminarPersonaje(String nombre) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            personajes.remove(p);
            guardarPersonajes();
            System.out.println("Personaje eliminado.");
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    // Método para modificar un personaje existente
    public void modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            p.setVida(vida);
            p.setAtaque(ataque);
            p.setDefensa(defensa);
            p.setAlcance(alcance);
            guardarPersonajes();
            System.out.println("Personaje modificado.");
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    // Método para mostrar todos los personajes
    public void mostrarPersonajes() {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    // Método para cargar personajes desde el archivo
    @SuppressWarnings("unchecked")
    private List<Personaje> cargarPersonajes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Personaje>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Método para guardar los personajes en el archivo
    private void guardarPersonajes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(personajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
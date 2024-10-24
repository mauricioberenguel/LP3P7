import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
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
    
    public void filtrarPorAtributo(String atributo) {
        switch (atributo.toLowerCase()) {
            case "vida":
                personajes.sort(Comparator.comparingInt(Personaje::getVida));
                break;
            case "ataque":
                personajes.sort(Comparator.comparingInt(Personaje::getAtaque));
                break;
            case "defensa":
                personajes.sort(Comparator.comparingInt(Personaje::getDefensa));
                break;
            case "alcance":
                personajes.sort(Comparator.comparingInt(Personaje::getAlcance));
                break;
            default:
                System.out.println("Atributo no válido. Usa: vida, ataque, defensa o alcance.");
                return;
        }
        System.out.println("Personajes ordenados por " + atributo + ":");
        mostrarPersonajes(); // Mostrar personajes después de ordenar
    }
    public void mostrarEstadisticas() {
        int totalPersonajes = personajes.size();
        if (totalPersonajes == 0) {
            System.out.println("No hay personajes para mostrar estadísticas.");
            return;
        }

        int sumaVida = 0, sumaAtaque = 0, sumaDefensa = 0, sumaAlcance = 0;

        for (Personaje p : personajes) {
            sumaVida += p.getVida();
            sumaAtaque += p.getAtaque();
            sumaDefensa += p.getDefensa();
            sumaAlcance += p.getAlcance();
        }

        double promedioVida = (double) sumaVida / totalPersonajes;
        double promedioAtaque = (double) sumaAtaque / totalPersonajes;
        double promedioDefensa = (double) sumaDefensa / totalPersonajes;
        double promedioAlcance = (double) sumaAlcance / totalPersonajes;

        System.out.println("Estadísticas Generales:");
        System.out.println("Total de personajes: " + totalPersonajes);
        System.out.println("Promedio de vida: " + promedioVida);
        System.out.println("Promedio de ataque: " + promedioAtaque);
        System.out.println("Promedio de defensa: " + promedioDefensa);
        System.out.println("Promedio de alcance: " + promedioAlcance);
    }
}
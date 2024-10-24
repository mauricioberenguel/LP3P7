import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Agenda {
    // Atributos de la clase
    ArrayPersona lista;
    FileInputStream agendaFile;
    final int longLinea = 32;

    // Constructor de la clase
    public Agenda() {
        this.lista = cargaContactos(); // Inicializa la lista de contactos
    }

    // Método principal del programa
    public void bucle() {
        String nombre = "";  // Inicializa la variable
        System.out.println("Introduzca un nombre o <Enter> para salir:");
        try {
            while (!"".equals(nombre = leeEntrada(System.in))) {  // Asegúrate de que el nombre se lee correctamente
                lista.printArray(nombre);
                System.out.println("Introduzca un nombre o <Enter> para salir:");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para leer una línea de entrada desde un InputStream
    private String leeEntrada(InputStream entrada) throws IOException {
        byte[] chars = new byte[longLinea];
        int contador = 0;
        int leido = 0;  // Variable para almacenar el byte leído

        while (contador < longLinea && (leido = entrada.read()) != -1 && leido != '\n') {
            chars[contador++] = (byte) leido;
        }

        if (leido == -1 && contador == 0) {  // Si no se leyó nada y llegó al final del archivo
            return null;
        }

        return new String(chars, 0, contador);  // Devuelve la cadena leída
    }

    // Carga una persona desde el archivo de agenda
    private Persona cargaAgenda() throws IOException {
        String nombre = leeEntrada(agendaFile);
        if (nombre == null) {
            return null;  // Si no hay más personas, retorna null
        }
        String telefono = leeEntrada(agendaFile);
        String direccion = leeEntrada(agendaFile);
        return new Persona(nombre, telefono, direccion);
    }

    // Carga todos los contactos de la agenda
    private ArrayPersona cargaContactos() {
        ArrayPersona directorio = new ArrayPersona();
        try {
            agendaFile = new FileInputStream("src/agenda.txt");  // Asegúrate de que la ruta del archivo es correcta
            while (true) {
                Persona nuevaPersona = cargaAgenda();  // Carga cada persona
                if (nuevaPersona == null) {
                    break;  // Si no hay más personas, rompe el ciclo
                }
                directorio.addArray(nuevaPersona);  // Añade la nueva persona al directorio
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de agenda");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en la carga de los contactos: " + e.getMessage());
        }

        return directorio;
    }
}

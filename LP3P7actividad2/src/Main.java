import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;

        try (PrintWriter salida = new PrintWriter("d:/pruebasjava/datos.txt")) { // try with resources
            System.out.println("Introduce texto. Para acabar introduce la cadena 'FIN':");
            
            cadena = sc.nextLine();

            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);  // Escribir en el archivo
                salida.flush();  // Forzar que los datos se escriban en el archivo inmediatamente
                System.out.println("Escribiendo: " + cadena);  // Confirmar en consola
                cadena = sc.nextLine();  // Leer la siguiente línea
            }

            System.out.println("Archivo guardado correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

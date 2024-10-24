import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Solicitar al usuario la ruta del archivo o directorio
            System.out.print("Ingrese la ruta del archivo o directorio: ");
            Path ruta = Paths.get(sc.nextLine());

            // Verificar si el archivo o directorio existe
            if (Files.exists(ruta)) {
                // Imprimir información del archivo/directorio
                System.out.println("\nInformación del archivo/directorio:");
                System.out.println("Nombre: " + ruta.getFileName());
                System.out.println("Es directorio: " + Files.isDirectory(ruta));
                System.out.println("Es ruta absoluta: " + ruta.isAbsolute());
                System.out.println("Última modificación: " + Files.getLastModifiedTime(ruta));
                System.out.println("Tamaño: " + Files.size(ruta) + " bytes");
                System.out.println("Ruta completa: " + ruta.toAbsolutePath());

                // Si es un directorio, listar su contenido
                if (Files.isDirectory(ruta)) {
                    System.out.println("\nContenido del directorio:");
                    try (DirectoryStream<Path> directorio = Files.newDirectoryStream(ruta)) {
                        // Iterar sobre cada archivo o subdirectorio en el directorio
                        directorio.forEach(System.out::println);
                    }
                }
            } else {
                // Informar al usuario si el archivo o directorio no existe
                System.out.println("El archivo o directorio no existe.");
            }
        } catch (IOException e) {
            // Manejar cualquier excepción de E/S
            System.err.println("Error: " + e.getMessage());
        }
    }
}
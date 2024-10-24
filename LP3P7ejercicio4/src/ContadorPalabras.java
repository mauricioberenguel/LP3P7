import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ContadorPalabras {

    private int totalLineas;
    private int totalPalabras;
    private int totalCaracteres;
    private Map<String, Integer> contadorPalabras;

    // Constructor
    public ContadorPalabras() {
        this.totalLineas = 0;
        this.totalPalabras = 0;
        this.totalCaracteres = 0;
        this.contadorPalabras = new HashMap<>();
    }

    // Método principal
    public static void main(String[] args) {
        ContadorPalabras cp = new ContadorPalabras();
        cp.ejecutar();
    }

    // Método para ejecutar el flujo principal
    public void ejecutar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo de texto");

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            try {
                leerArchivo(archivoSeleccionado);
                mostrarResultados();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    // Leer el archivo, contar líneas, palabras y caracteres
    public void leerArchivo(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                contarPalabras(linea);
                totalCaracteres += linea.replaceAll("\n", "").length(); // No contar los saltos de línea
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + file.getName());
            throw e;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + file.getName());
            throw e;
        }
    }

    // Contar las palabras en una línea
    private void contarPalabras(String linea) {
        String[] palabras = linea.split("\\s+"); // Separar por espacios
        for (String palabra : palabras) {
            if (palabra.matches("[a-zA-Z0-9]+")) { // Considerar solo palabras que contengan letras o dígitos
                totalPalabras++;
                palabra = palabra.toLowerCase(); // Normalizar a minúsculas
                contadorPalabras.put(palabra, contadorPalabras.getOrDefault(palabra, 0) + 1);
            }
        }
    }

    // Mostrar los resultados en la consola
    public void mostrarResultados() {
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres (sin contar saltos de línea): " + totalCaracteres);
        System.out.printf("Promedio de palabras por línea: %.2f\n", promedioPalabrasPorLinea());
        mostrarPalabrasFrecuentes();
    }

    // Calcular el promedio de palabras por línea
    public double promedioPalabrasPorLinea() {
        return totalLineas == 0 ? 0 : (double) totalPalabras / totalLineas;
    }

    // Mostrar las palabras más frecuentes con su conteo
    public void mostrarPalabrasFrecuentes() {
        System.out.println("\nPalabras más frecuentes:");
        contadorPalabras.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10) // Mostrar solo las 10 más frecuentes
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

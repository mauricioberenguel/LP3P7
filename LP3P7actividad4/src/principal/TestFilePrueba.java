package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class TestFilePrueba {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[1024]; // Crea un arreglo de bytes para almacenar el contenido del archivo 
        try {
            FileInputStream file = new FileInputStream("src/archivos/TestFile.java"); 
          // Intenta abrir el archivo
            file.read(b); // Lee el contenido del archivo y lo almacena en el arreglo de bytes

            String s = new String(b); // Convierte el arreglo de bytes a una cadena
            ViewFile view = new ViewFile(s); 
          // Crea una instancia de la clase ViewFile (asumimos que muestra el contenido)
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          // Configura la acción al cerrar la ventana
            view.setSize(400, 150); // Establece el tamaño de la ventana
            view.setVisible(true); // Hace visible la ventana
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); 
          // Imprime un mensaje de error si el archivo no se encuentra
        } catch (IOException e) {
            System.out.println(e.getMessage()); 
          // Imprime un mensaje de error si ocurre cualquier otra excepción de entrada/salida
        }
    }
}

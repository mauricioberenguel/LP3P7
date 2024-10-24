import java.io.*;

public class Serial5 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Alumno a;
        Fecha f;

        try {
            // Verifica que la carpeta ficheros exista
            File directorio = new File("ficheros");
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            fos = new FileOutputStream("ficheros/alumnos.dat");
            salida = new ObjectOutputStream(fos);

            f = new Fecha(5, 9, 2011);
            a = new Alumno("12345678A", "Lucas González", "123456789", 20, f);
            salida.writeObject(a);

            f = new Fecha(7, 9, 2011);
            a = new Alumno("98765432B", "Anacleto Jiménez", "987654321", 19, f);
            salida.writeObject(a);

            f = new Fecha(8, 9, 2011);
            a = new Alumno("782342122", "María Zapata", "782342122", 21, f);
            salida.writeObject(a);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fos != null) fos.close();
                if (salida != null) salida.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01 {
    public static void main(String[] args) {

        String rutaArchivo = "\\Users\\MINED\\Desktop\\BIBLIA COMPLETA.txt";

        String Buscar = "Dios";

        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                linea = linea.toLowerCase();

                String[] palabras = linea.split(" ");

                for (String palabra : palabras) {

                    palabra = palabra.replaceAll("[^a-zA-Záéíóúüñ]", "");
                    if (palabra.equals(Buscar.toLowerCase())) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el resultado usando JOptionPane
        JOptionPane.showMessageDialog(null, "La palabra \"" + Buscar + "\" se presenta " + contador + " veces en la Biblia.");
    }
}

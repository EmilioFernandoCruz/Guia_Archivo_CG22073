import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        String rutaArchivo = "\\Users\\MINED\\Desktop\\BIBLIA COMPLETA.txt";

        String[] palabras = new String[1000000];
        int[] contadorPalabras = new int[1000000];

        try {
            FileReader archivo = new FileReader(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNext()) {
                String palabra = scanner.next().toLowerCase().replaceAll("[^a-zA-Záéíóúüñ]", "");
                if (!palabra.isEmpty()) {

                    boolean buscar = false;
                    for (int var1 = 0; var1 < palabras.length; var1++) {
                        if (palabras[var1] != null && palabras[var1].equals(palabra)) {
                            contadorPalabras[var1]++;
                            buscar = true;
                            break;
                        } else if (palabras[var1] == null) {
                            palabras[var1] = palabra;
                            contadorPalabras[var1] = 1;
                            buscar = true;
                            break;
                        }
                    }
                    if (!buscar) {
                        for (int var1 = 0; var1 < palabras.length; var1++) {
                            if (palabras[var1] == null) {
                                palabras[var1] = palabra;
                                contadorPalabras[var1] = 1;
                                break;
                            }
                        }
                    }
                }
            }

            for (int var2 = 0; var2 < 10; var2++) {
                int a = 0;
                int i = -1;
                for (int var1 = 0; var1 < palabras.length; var1++) {
                    if (palabras[var1] != null && contadorPalabras[var1] > a) {
                        a = contadorPalabras[var1];
                        i = var1;
                    }
                }
                if (i != -1) {
                    System.out.println(palabras[i] + ": " + a + " veces");
                    palabras[i] = null;
                    contadorPalabras[i] = 0;
                } else {
                    break;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + rutaArchivo);
        }
    }
}


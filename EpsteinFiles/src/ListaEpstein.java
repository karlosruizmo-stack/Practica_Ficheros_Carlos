import java.io.*;
import java.util.Scanner;

public class ListaEpstein {
    public static void main(String[] args) {
        String nombreArchivo = "lista.txt";
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la palabra a buscar: ");
        String palabraObjetivo = sc.nextLine().toLowerCase();//lo pongo en minuscula para que aparezcan más resultados

        int contador = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;//Esto lo encontre pasandolo porque no encontraba un error y la ia me dijo que servia para leer

            while ((linea = br.readLine()) != null) {
                String[] palabrasEnLinea = linea.split("[\\s,.]+");

                for (String p : palabrasEnLinea) {
                    if (p.equalsIgnoreCase(palabraObjetivo)) {
                        contador++;
                    }
                }
            }

            System.out.println("La palabra '" + palabraObjetivo + "' aparece " + contador + " veces.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.out.println(" " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
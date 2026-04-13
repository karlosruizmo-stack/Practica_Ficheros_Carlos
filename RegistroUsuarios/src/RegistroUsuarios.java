import java.io.*;
import java.util.Scanner;

public class RegistroUsuarios {

    private static final String NOMBRE_ARCHIVO = "usuarios.txt";

    public static void main(String[] args) {
        leerUsuarios();

        registrarNuevoUsuario();
    }

    public static void leerUsuarios() {
        System.out.println("Usuarios Registrado ");
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            System.out.println("No hay registros previos.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            boolean tieneContenido = false;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
                tieneContenido = true;
            }
            if (!tieneContenido) System.out.println("No hay nada en el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void registrarNuevoUsuario() {
        Scanner sc = new Scanner(System.in);

        try{
                System.out.print("Ingresar nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingresar edad: ");
                int edad = Integer.parseInt(sc.nextLine());

                System.out.print("Ingresar correo electrónico: ");
                String correo = sc.nextLine();


                try (PrintWriter writer = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
                    writer.println("Nombre: " + nombre + " | Edad: " + edad + " | Email: " + correo);
                    System.out.println("Usuario registrado con éxito");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: La edad debe ser un número válido.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            } finally {
                sc.close();
            }
        }
        }


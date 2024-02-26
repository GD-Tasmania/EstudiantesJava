package co.edu.uniquindio.poo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Estudiantes estudiante = new Estudiantes("Luis", "Contreras", "1092851183", "luiscon123@gmail.com", "3207787962", 18);
        String regexCorreo = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Compilar la expresión regular en un patrón.
        Pattern pattern = Pattern.compile(regexCorreo); // Este objeto representa el patrón que queremos buscar en las cadenas.

        // Crear un objeto Matcher para hacer coincidir el patrón con la cadena de correo electrónico.
        Matcher matcher = pattern.matcher(estudiante.getCorreo()); //Este objeto se utilizará para buscar el patrón definido en la cadena de correo.
        if (estudiante.getNombre() != null && estudiante.getApellido() != null && estudiante.getIdentificacion() != null && estudiante.getCorreo() != null && estudiante.getTelefono() != null &&
            estudiante.getNombre() != "" && estudiante.getApellido() != "" && estudiante.getIdentificacion() != "" && estudiante.getCorreo() != "" && estudiante.getTelefono() != ""){
            if (estudiante.getEdad() >=0) {
                if (matcher.matches()){
                    System.out.println(estudiante.getNombre());
                    System.out.println(estudiante.getApellido());
                    System.out.println(estudiante.getIdentificacion());
                    System.out.println(estudiante.getCorreo());
                    System.out.println(estudiante.getEdad());
                    System.out.println(estudiante.getCorreo());
                } else {
                    System.out.println("Error, el correo del estudiante es invalido.");
                }
            } else {
                System.out.println("Error, la edad no puede ser negativa.");
            }
        } else {
            System.out.println("Error, faltan datos para la creación del estudiante.");
        }
    }
}

/**
 * Clase para probar el funcionamiento del código
 * @author Luis Alejandro Contreras Sanchez
 * @since 17-02-2024
 * 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertTrue(true);
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

    @Test
    public void probandoDatosCompletos() {
        LOG.info("Iniciado test probandoDatosCompletos");
        Estudiantes estudiante = new Estudiantes("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", 18);
        String mensaje = "Estudiante: ("+estudiante.getNombre()+", "+estudiante.getApellido()+", "+estudiante.getIdentificacion()+", "+
        estudiante.getCorreo()+", "+estudiante.getTelefono()+", "+estudiante.getEdad()+")";

        LOG.info("Estudiante creado: "+mensaje);
        LOG.info("Finalizando test probandoDatosCompletos");
    }

    @Test
    public void probandoDatosNullos() {
        LOG.info("Iniciado test probandoDatosNullos");
        Estudiantes estudiante = new Estudiantes(null, null, null, null, null, 18);

        assertAll("Estudiante",
        () -> assertNotNull(estudiante.getNombre(), "El nombre no puede ser nulo."),
        () -> assertNotNull(estudiante.getApellido(), "El apellido no puede ser nulo."),
        () -> assertNotNull(estudiante.getIdentificacion(), "La identificación no puede ser nula."),
        () -> assertNotNull(estudiante.getCorreo(), "El correo no puede ser nulo."),
        () -> assertNotNull(estudiante.getTelefono(), "El telefono no puede ser nulo.")
        );
        LOG.info("Finalizando test probandoDatosNullos");
    }
    @Test
    public void probandoDatosVacios() {
        LOG.info("Iniciado test probandoDatosVacios");
        Estudiantes estudiante = new Estudiantes("", "", "", "", "", 0);

        assertAll("Estudiante",
        () -> assertNotEquals(estudiante.getNombre(), "", "El nombre no puede ser vacio."),
        () -> assertNotEquals(estudiante.getApellido(), "", "El apellido no puede ser vacio."),
        () -> assertNotEquals(estudiante.getIdentificacion(), "", "La identificación no puede ser vacia."),
        () -> assertNotEquals(estudiante.getCorreo(), "", "El correo no puede ser vacio."),
        () -> assertNotEquals(estudiante.getTelefono(), "", "El telefono no puede ser vacio.")
        );
        LOG.info("Finalizando test probandoDatosVacios");
    }

    @Test
    public void probandoEdadesNegativas() {
        LOG.info("Iniciado test probandoEdadesNegativas");
        Estudiantes estudiante = new Estudiantes("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", -18);

        assertTrue(estudiante.getEdad() >= 0, "La edad no puede ser negativa.");
        LOG.info("Finalizando test probandoEdadesNegativas");
    }

    @Test
    public void probandoCorreoInvalido() {
        LOG.info("Iniciado test probandoCorreoInvalido");
        Estudiantes estudiante = new Estudiantes("Camila", "Alzate Rios", "109453264", "cami", "315635674", 18);
        
        String regexCorreo = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"; // Expresión regular para validar un correo electrónico
        assertTrue(estudiante.getCorreo().matches(regexCorreo), "El correo electrónico no es válido.");
        LOG.info("Finalizando test probandoCorreoInvalido");
    }

    @Test
    public void testCompletoEstudiante() {
        LOG.info("Iniciado test testCompletoEstudiante");
        Estudiantes estudiante = new Estudiantes("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", 18);
        // Estudiantes estudiante = new Estudiantes(null, null, null, null, null, 18);
        // Estudiantes estudiante = new Estudiantes("s", "", "", "", "", 18);
        // Estudiantes estudiante = new Estudiantes("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", -18);
        // Estudiantes estudiante = new Estudiantes("Camila", "Alzate Rios", "109453264", "cami", "315635674", 18);
        
        String regexCorreo = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"; // Expresión regular para validar un correo electrónico

        assertAll("Estudiante",
        () -> assertNotNull(estudiante.getNombre(), "El nombre no puede ser nulo."),
        () -> assertNotNull(estudiante.getApellido(), "El apellido no puede ser nulo."),
        () -> assertNotNull(estudiante.getIdentificacion(), "La identificación no puede ser nula."),
        () -> assertNotNull(estudiante.getCorreo(), "El correo no puede ser nulo."),
        () -> assertNotNull(estudiante.getTelefono(), "El telefono no puede ser nulo."),
        () -> assertNotEquals(estudiante.getNombre(), "", "El nombre no puede ser vacio."),
        () -> assertNotEquals(estudiante.getApellido(), "", "El apellido no puede ser vacio."),
        () -> assertNotEquals(estudiante.getIdentificacion(), "", "La identificación no puede ser vacia."),
        () -> assertNotEquals(estudiante.getCorreo(), "", "El correo no puede ser vacio."),
        () -> assertNotEquals(estudiante.getTelefono(), "", "El telefono no puede ser vacio."),
        () -> assertTrue(estudiante.getEdad() >= 0, "La edad no puede ser negativa."),
        () -> assertTrue(estudiante.getCorreo().matches(regexCorreo), "El correo electrónico no es válido.")
        );
        LOG.info("Estudiante creado");

        LOG.info("Finalizando test testCompletoEstudiante");
    }
}
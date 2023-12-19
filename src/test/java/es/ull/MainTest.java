package es.ull;

import org.junit.jupiter.api.*;

/**
 * Clase de prueba para la clase Main.
 * Esta clase contiene pruebas para los métodos públicos de la clase Main.
 */
public class MainTest {

    /**
     * Prueba el método main de la clase Main.
     * Esta prueba se enfoca en ejecutar el método main con un conjunto
     * predefinido de argumentos.
     */
    @Test
    public void main() {
        String[] args = { "abc", "abc", "abc" };
        Main.main(args);
    }

    /**
     * Prueba el método printMenu de la clase Main.
     * Esta prueba verifica si el método printMenu funciona correctamente
     * al ser invocado.
     */
    @Test
    public void printMenu() {
        Main.printMenu();
    }
}

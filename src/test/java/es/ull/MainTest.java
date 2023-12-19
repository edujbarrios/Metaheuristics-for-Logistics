package es.ull;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testPrintMenu() {
		Main.printMenu();
		String output = outContent.toString();
		assertTrue(output.contains("MENÚ PRINCIPAL"));
		assertTrue(output.contains("1. BPP Container Loading Problem"));
		assertTrue(output.contains("2. VRP Vehicle Routing Problem"));
		assertTrue(output.contains("0. Salir"));
		// Puedes agregar más aserciones para verificar el contenido exacto del menú
	}

	// Aquí se pueden agregar más pruebas para otros métodos si es necesario
}

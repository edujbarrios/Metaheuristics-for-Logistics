
package es.ull.menus;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Scanner;

public class VRPvehiclesViewTest {

	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;
	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;

	@BeforeEach
	void setUpOutput() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	String getOutput() {
		return testOut.toString();
	}

	@AfterEach
	void restoreSystemInputOutput() {
		System.setIn(systemIn);
		System.setOut(systemOut);
	}

	@Test
	@DisplayName("Probar la interacción del menú y la selección de usuario")
	void testMenuInteraction() {
		provideInput("1\n0\n"); // Simula la selección de Hill Climbing y luego sali
		assertDoesNotThrow(() -> VRPvehiclesView.run(new Scanner(System.in), "dataFile.txt"));
	}

	@Test
	@DisplayName("Verificar carga correcta de datos desde archivo")
	void testDataLoading() {
		provideInput("0\n"); // Simula salir del menú
		assertDoesNotThrow(() -> VRPvehiclesView.run(new Scanner(System.in), "dataFile.txt"));
	}
	
}

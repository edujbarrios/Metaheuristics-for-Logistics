package es.ull.concrete.metaheuristics.containerBPP;

import es.ull.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BPPSimulatedAnnealingTest {

    private BPPSimulatedAnnealing bppSimulatedAnnealing;
    private ILoadingProblems problemInstance;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Aquí se debe inicializar 'problemInstance' con una implementación concreta o simulada
        // problemInstance = new ...;

        bppSimulatedAnnealing = new BPPSimulatedAnnealing(problemInstance);
        System.setOut(new PrintStream(outputStreamCaptor)); // Captura la salida del sistema
    }

    @Test
    @DisplayName("Constructor initializes BPPSimulatedAnnealing correctly")
    void testConstructor() {
        assertNotNull(bppSimulatedAnnealing, "BPPSimulatedAnnealing should not be null after construction");
    }


    // Después de las pruebas, restablecer el System.out a su estado original
    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}

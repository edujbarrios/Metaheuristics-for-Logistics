package es.ull.concrete.metaheuristics.containerBPP;

import es.ull.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BPPSimulatedAnnealingTest {

    private BPPSimulatedAnnealing bppSimulatedAnnealing;
    private ILoadingProblems problemInstance;

    @BeforeEach
    void setUp() {
        // Aquí se debe inicializar 'problemInstance' con una implementación concreta o simulada
        // problemInstance = new ...;

        bppSimulatedAnnealing = new BPPSimulatedAnnealing(problemInstance);
    }

    @Test
    @DisplayName("Constructor initializes BPPSimulatedAnnealing correctly")
    void testConstructor() {
        assertNotNull(bppSimulatedAnnealing, "BPPSimulatedAnnealing should not be null after construction");
    }

}

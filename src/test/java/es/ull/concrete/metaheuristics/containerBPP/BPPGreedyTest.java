package es.ull.concrete.metaheuristics.containerBPP;

import es.ull.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BPPGreedyTest {

    private BPPGreedy bppGreedy;
    private ILoadingProblems problemInstance;

    @BeforeEach
    void setUp() {
        // Aquí se debe inicializar 'problemInstance' con una implementación concreta o simulada
        // problemInstance = new ...;

        bppGreedy = new BPPGreedy(problemInstance);
    }

    @Test
    @DisplayName("Constructor initializes BPPGreedy correctly")
    void testConstructor() {
        assertNotNull(bppGreedy, "BPPGreedy should not be null after construction");
    }
}

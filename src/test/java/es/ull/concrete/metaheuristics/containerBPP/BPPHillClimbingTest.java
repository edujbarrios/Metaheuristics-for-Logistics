package es.ull.concrete.metaheuristics.containerBPP;

import es.ull.abstracts.problem.ILoadingProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BPPHillClimbingTest {

    private BPPHillClimbing bppHillClimbing;
    private ILoadingProblems problemInstance;

    @BeforeEach
    void setUp() {
        // Aquí se debe inicializar 'problemInstance' con una implementación concreta o simulada
        // problemInstance = new ...;

        bppHillClimbing = new BPPHillClimbing(problemInstance);
    }

    @Test
    @DisplayName("Constructor initializes BPPHillClimbing correctly")
    void testConstructor() {
        assertNotNull(bppHillClimbing, "BPPHillClimbing should not be null after construction");
    }

}

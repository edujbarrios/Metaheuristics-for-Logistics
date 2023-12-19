package es.ull.concrete.metaheuristics.containerBPP;

import es.ull.abstracts.problem.ILoadingProblems;
import es.ull.concrete.solutions.BPPcontainerSolution;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BPPGreedyTest {

    private BPPGreedy bppGreedy;
    private ILoadingProblems problemInstance;

    @BeforeEach
    void setUp() {
        // Aquí se debe inicializar 'problemInstance' con una implementación concreta o una simulada
        // problemInstance = new ...;

        bppGreedy = new BPPGreedy(problemInstance);
    }

    @Test
    @DisplayName("Constructor initializes BPPGreedy correctly")
    void testConstructor() {
        assertNotNull(bppGreedy, "BPPGreedy should not be null after construction");
    }


    // Más pruebas pueden ser añadidas aquí si hay otros métodos públicos
}


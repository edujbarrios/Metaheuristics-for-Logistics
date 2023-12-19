package es.ull.concrete.metaheuristics.vehiclesVRP;

import es.ull.abstracts.problem.ILoadingProblems;
import es.ull.abstracts.problem.IRoutingProblems;
import es.ull.concrete.metaheuristics.containerBPP.BPPGreedy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VRPHillClimbingTest {

	private VRPHillClimbing vrpHillClimbing;
	private
	IRoutingProblems problemInstance;

	@BeforeEach
	void setUp() {
		// Aquí se debe inicializar 'problemInstance' con una implementación concreta o una simulada
		// problemInstance = new ...;

		vrpHillClimbing = new VRPHillClimbing(problemInstance);
	}

	@Test
	void testConstructor() {
		assertNotNull(vrpHillClimbing, "VRPHillClimbing should not be null after construction");
	}

	@Test
	void testGetBestNeighbour() {

	}

	@Test
	void testSolve() {

	}
}

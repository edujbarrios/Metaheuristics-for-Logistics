

/**
 * Comparar con grasp aver donde no estas poniendo print Solution
 */


package concrete.metaheuristics.containerBPP;

import abstracts.metaheuristics.LoadingAbsractMHeuristics;
import abstracts.problem.ILoadingProblems;

public class BPPGreedy extends LoadingAbsractMHeuristics {

	public BPPGreedy(ILoadingProblems instancia) {
		super(instancia);
		// TODO Auto-generated constructor stub
	}
	
	public void solve(){
		initialSolution();
		bestSolution();
	}

	/**
	 * 
	 */
	private void bestSolution() {
		while( !this.solution.isFull() ){
			this.printSolution( this.solution );
			this.solution.addNextBestItem();
		}
		
		this.printBestSolution();
	}

	/**
	 * 
	 */
	private void initialSolution() {
		this.solution = this.resetSolution(lProblem);
	}
	

	protected void printBestSolution(){
		System.out.println("GREEDY:\n" + this.solution.toString(true, true) + "\n");
	}
	
}
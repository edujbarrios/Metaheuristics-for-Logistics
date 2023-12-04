package main.java.concrete.metaheuristics.containerBPP;

import main.java.abstracts.metaheuristics.LoadingAbstractMHeuristics;
import main.java.abstracts.problem.ILoadingProblems;

public class BPPGreedy extends LoadingAbstractMHeuristics {
	public BPPGreedy(ILoadingProblems instancia) {
		super(instancia);
		// TODO Auto-generated constructor stub
	}
	
	public void solve(){
		initialSolution();
		bestSolution();
	}

	private void bestSolution() {
		while( !this.solution.isFull() ){
			this.printSolution( this.solution );
			this.solution.addNextBestItem();
		}
		
		this.printBestSolution();
	}

	private void initialSolution() {
		this.solution = this.resetSolution(lProblem);
	}
	
	protected void printBestSolution(){
		System.out.println("GREEDY:\n" + this.solution.toString(true, true) + "\n");
	}
}

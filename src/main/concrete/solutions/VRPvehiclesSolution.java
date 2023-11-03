package concrete.solutions;

import java.util.ArrayList;
import java.util.Arrays;

import abstracts.metaheuristics.RoutingAbsractMHeuristics;
import abstracts.problem.IRoutingProblems;
import abstracts.solution.IRoutingSolutions;
import abstracts.solution.Solution;

public class VRPvehiclesSolution extends Solution implements IRoutingSolutions {

		/**
		 * The size of a solution (number of cities)
		 */
		private int size;

		/**
		 * Metaheuristics used for resolution
		 */
		private RoutingAbsractMHeuristics metaheuristics;
		
		/**
		 * Default constructor
		 */
		public VRPvehiclesSolution() {
			super();
		}

		/**
		 * Constructor using the class attributes
		 * @param size
		 * @param metaheuristics
		 */
		public VRPvehiclesSolution(int size, RoutingAbsractMHeuristics metaheuristics) {
			super();
			this.size = size;
			this.metaheuristics = metaheuristics;
			this.solution = new int[size];
		}

		public VRPvehiclesSolution(int[] solution,RoutingAbsractMHeuristics methode) {
			this.solution = solution;
			this.size = solution.length;
		}
		
		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#getSize()
		 */
		@Override
		public int getSize() {
			return size;
		}

		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#setSize(int)
		 */
		@Override
		public void setSize(int size) {
			this.size = size;
		}


		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#initialiserSolution()
		 */
		@Override
		public void initialiserSolution(){
			for( int i = 0 ; i < size ; i++ )
				solution[i] = i;
		}
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#randomSolution()
		 */
		@Override
		public void randomSolution(){
			this.initialiserSolution();
			for( int i=0 ; i < size ; i++ ){
				int temp = solution[i];
				int j = (int)((Math.random()*size));
				solution[i] = solution[j];
				solution[j] = temp;
			}
		}
		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#randomSolution()
		 */
		@Override
		public void randomSolutionModified(){
			this.initialiserSolution();
			for( int i=0 ; i < size ; i++ ){
				solution[i] = (int)((Math.random()*size));
			}
		}
		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#getNeighbour(int)
		 */
		@Override
		public VRPvehiclesSolution getNeighbour(int i) throws CloneNotSupportedException{
			VRPvehiclesSolution neighbour = (VRPvehiclesSolution) this.clone();
			int temp = neighbour.solution[i];
			neighbour.solution[i] = neighbour.solution[i+1];
			neighbour.solution[i+1] = temp;
			return neighbour;
		}
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#getNeighbours()
		 */
		@Override
		public ArrayList<VRPvehiclesSolution> getNeighbours() throws CloneNotSupportedException{
			ArrayList<VRPvehiclesSolution> neighbours = new ArrayList<VRPvehiclesSolution>();
			for( int i = 0 ; i < size-1 ; i++) {
				neighbours.add(this.getNeighbour(i));
			}
			return neighbours;
		}
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#getCout(abstracts.problem.IRoutingProblems)
		 */
		@Override
		public int getCostPath(IRoutingProblems vrpProblem){
			int cout = 0;
			for (int i = 0; i < vrpProblem.getSize() - 1; i++){
				cout += vrpProblem.getDistance(solution[i], solution[i + 1]);
			}
			cout += vrpProblem.getDistance(solution[0], solution[vrpProblem.getSize() - 1]);
			return cout;
		}
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#getIndice(int)
		 */
		@Override
		public int getIndice(int i){
			for( int j = 0 ; j < size ; j++)
				if( i == solution[j]) return j;
			return -1;
		}
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#toString()
		 */
		@Override
		public String toString() {
			char nodo = 65;
			String sol = "Solution = [\t";
			for( int i = 0 ; i < solution.length ; i++ ){
				sol += (char)(nodo + solution[i])+"\t";
			}
			sol +="]";
			return sol;

		}
		
		
		public String toString(IRoutingProblems Problem){
			char nodo = 65;
			String sol = "Solution = [\t";
			for( int i = 0 ; i < solution.length ; i++ ){
				if(i < solution.length-1){
					sol += "(";
					sol += (char)(nodo + solution[i]);
					sol += ") --- " + Problem.getDistance(solution[i], solution[i + 1])+ " ---> ";
				}
				else{
					sol +="("+ (char)(nodo + solution[i]) +") --- ";
				}
			}
			
			sol += Problem.getDistance(solution[Problem.getSize() - 1], solution[0]) + " ---> ";
			sol += "(";
			sol += (char)(nodo + solution[0]);
			sol +=")\t]";
			return sol;
		}

		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#clone()
		 */
		@Override
		public Object clone() throws CloneNotSupportedException {
		    VRPvehiclesSolution cloned = (VRPvehiclesSolution)super.clone();
		    cloned.setSolution(cloned.getSolution().clone());
		    return cloned;
		}
		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Object obj) {
			// TODO Auto-generated method stub
			IRoutingSolutions sol = (IRoutingSolutions) obj;
			return this.getCostPath(metaheuristics.getInstance()) - sol.getCostPath(metaheuristics.getInstance());
		}
		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			VRPvehiclesSolution other = (VRPvehiclesSolution) obj;
			if (!Arrays.equals(solution, other.solution))
				return false;
			if (size != other.size)
				return false;
			return true;
		}
		
		/* (non-Javadoc)
		 * @see concrete.solutions.RoutingSolutions#setSolution(java.lang.Object[])
		 */
		@Override
		public void setSolution(Object[] array) {
			// TODO Auto-generated method stub
			for(int i = 0 ; i < solution.length ; i ++){
				solution[i] = (int) array[i];
			}
		}
		
		
}

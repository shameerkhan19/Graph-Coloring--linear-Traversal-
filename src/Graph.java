public class Graph {
	
	private int nodes;//to see how many vertex/nodes we are working with
	private int colors[];//the array that will assign color to each node
	private int matrix[][];//Adjacency Matrix
	

	public Graph(){
		//empty
	}
	
	public Graph(int s, int m[][]){
		nodes=s;
		colors=new int[nodes];
		matrix=new int[nodes][nodes];
		matrix=m;
	}
	
	/*the logic for the OK function is everytime a color gets assigned to a Node it's sent here,
	 * along with all the other previous nodes have been assigned a color so far. It checks which Node we are currently
	 * working on. It looks for that in the adjacency Matrix and finds all it's adjacents w1,w2,.....wn. But we only check
	 * the adjancents of the current node that has been colored so far. We don't check adjacents that we havent reached yet.
	 * There is simply no need for that. If we are working on Node 2 and we only need to check it's adjacency status up to 0,1.
	 * No need to check further. After the adjanceies have been found We check if they already have the color we are trying to assign.
	 * if so we send a false signal back to the coloring function tellling it the current color is already is use and we must try 
	 * another color. If the current coloring passes this test we send the true signal saying that the current color is valid
	 * and we can move to the next node.
	 */
	
	public static boolean isOK(int q[],int Index, int adjacent[][]){
		for(int i=0;i<Index;i++){
			if(adjacent[Index][i]==1 && (q[i]==q[Index]))return false;
		}
		return true;
	}

	
	public static void coloring(Graph g1){
		int Index=0;//it will act as an index for the coloring array.
		boolean causedBacktrack=false;//this will help me identify what caused the backtrack
		boolean backtrackCall=false;//this boolean variable is here for printing reasons i will explain below
		while(Index!=g1.nodes){//until my Index != no of nodes we have to process. if we have 2 nodes array will be size 2;
			g1.colors[Index]=0;
			while(g1.colors[Index]<5 ){//this loop will assign color to each node
				g1.colors[Index]++;//assign a color 
					if(g1.colors[Index]==5){//if we run of out of options we enter here
							if(causedBacktrack==false){
								System.out.println("Backtrack needed due to Node no. "+ Index+ " No more color choice left !!!!!!!!!! ");//the Node that caused backtrack
								System.out.println("configuration so far before backtracking: ");
								printResult(g1.colors,Index,backtrackCall=true);//will print the configuration so far 
								causedBacktrack=true;//set to true so we don't keep printing every backtrack in each sequence. We only want the original Node
							}
							Index--;//backtracking happens here. Go back to previous index and change color.
							continue;	
						}
					if(isOK(g1.colors,Index,g1.matrix)==true){//if our judge function says current assignment is valid we break this loop. and move to next index.
						causedBacktrack=false;//reseting this so we can catch the original node for the next backtrack sequence
						break;
						}
			}
			Index++;//Move to the next Node so it can get colored.
			}
			System.out.println("\nFinal configuration: ");
			printResult(g1.colors,g1.nodes,backtrackCall=false);
			
			System.out.println();
		}
	

	public static void printResult(int []r, int k, boolean Final){//will print current configuration so far. Or the final configuration
		for(int i=0; i<k;i++){
			if(r[i]==1)
			System.out.println("Node "+i +" was colored Red");
			else if(r[i]==2)
			System.out.println("Node "+i +" was colored Green");
			else if(r[i]==3)
			System.out.println("Node "+i +" was colored Blue");
			else if(r[i]==4)
			System.out.println("Node "+i +" was colored Yellow");
		}
		if(Final==true){
		System.out.println("couldn't color Node "+ k +" no more choices left");
		System.out.println();
		}
	}
	
	
}

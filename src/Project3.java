//Name:Shameer Khan
//CS-313
//Project 3
//Graph-Coloring

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		if(args.length==0)
				System.out.println("File doesn't exist");
		try{
			BufferedReader br= new BufferedReader(new FileReader(args[0]));
			String Line=br.readLine();
			while(Line!=null){
				if(!Line.isEmpty()){
					int size = 0;//will read the first line of each matrix and decide its size
					int k=0;//this k will allow me to assign size of the double array
					if(k==0){
						size=Integer.parseInt(Line);//assigning size
						k++;
						Line=br.readLine();
					}
					System.out.println("Given Adjacency martix:");
					int Double[][]= new int[size][size];//creation of the adjacency Matrix
					for(int i=0;i<Double.length;i++){
						String[] reference= Line.split(" ");
						for(int j=0;j<Double.length;j++){
							Double[i][j]=Integer.parseInt(reference[j]);
							System.out.print(Double[i][j]+" ");
						}
						System.out.println();
						Line=br.readLine();
						k++;
						if(k==size)
							k=0;//refreshing K to we can obtain the size for the next matrix.
					}
					Graph g= new Graph(size,Double);//creating the graph Object
					System.out.println("\nSolution: ");
					Graph.coloring(g);
				}
			}
		}
		
		catch(Exception e){
			System.out.println(e);
		}

	}

}

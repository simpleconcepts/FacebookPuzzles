import java.util.*;
import java.lang.*;
import java.io.*;

public class LiarLiar {

	/**
	 * @param args
	 */
	
	public static void bfs(AdjMatrixGraph G, int source){
	boolean[] group1 = new boolean[G.V()];
	boolean[] group2 = new boolean[G.V()];
	boolean[] marked = new boolean[G.V()];
	int[] edgeTo = new int[G.V()];
	// Group Vertices Into Two Groups
	group1[source] = true;
	group2[source] = false;

		Queue<Integer> q = new LinkedList<Integer>();
		marked[source] = true;
		q.offer(source);
		while(!q.isEmpty()){
			int v = q.poll();
			for(int w : G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					if(group1[v])
					
					marked[w] = true;
					// Mark the vertex to be in different group from neighbor
					// Note: Do Not Need To Set False Since Default
					// Note: Setting False is For Intuition
					if(group1[v])
					    group1[w] = false;
			     		if(!group1[v])
					    group1[w] = true;
					if(group2[v])
					    group2[w] = false;
					if(!group2[v])
					    group2[w] = true;
					  
					q.offer(w);
					
					
				}
				
			}
			
		}
		
	int liarsGroup1 = 0;
	int liarsGroup2 = 0;
	
	for(int i = 0; i < group1.length; i++){
		if(group1[i]) liarsGroup1++;
		if(group2[i]) liarsGroup2++;
		
	}
	
	System.out.println(liarsGroup1+ " "+ liarsGroup2);	
	
	
	}
	
	
	
	
	
	public static void main(String[] args) {
	    
	    if(args.length == 0){
		System.out.println("Usage: java LiarLiar input_file.txt");
	    }
	    
	        String filename = args[0];

		LiarLiarInputParser parser = new LiarLiarInputParser();
		
		AdjMatrixGraph G = parser.generateGraphFromFile(filename);
		
		bfs(G,0);
		
		
		
	}

}
